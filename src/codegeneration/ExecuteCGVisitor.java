package codegeneration;

import ast.*;
import ast.statements.*;
import ast.types.FunctionType;
import ast.types.Type;
import ast.types.VoidType;

public class ExecuteCGVisitor extends AbstractCGVisitor<ReturnValuesDTO, Void> {

    /**
     * Rules for execute code generation
     *
     * Program[[ Program: program -> definition* ]] =
     *      <' Invocation to the main function>
     *      <call main>
     *      <halt>
     *      definition*.forEach( d -> execute[[ d ]] )
     *
     *
     * Function definition
     * execute[[ FuncDefinition: definition -> type ID statement* ]] =
     *      ID <:>
     *      <enter> definition.localsBytesSum
     *      <' * Parameters>
     *      int paramsBytesSum = type.getParams().stream().mapToInt( vd -> vd.getType().numberOfBytes() ).sum();
     *      ReturnValuesDTO dto = new ReturnValuesDTO(
     *          type.returnType.numberOfBytes(),
     *          definition.getLocalsBytesSum(),
     *          paramsBytesSum
     *      )
     *      type.definitions.forEach( d -> execute[[ d ]] (dto) )
     *      <' * Local variables>
     *      statement*.forEach( s -> execute[[ s ]] ( (dto) )
     *      if ( type.returnType instanceof VoidType ) {
     *          <ret 0, > definition.getLocalsBytesSum() <, > paramsBytesSum
     *      }
     *
     *
     * Variable definition
     * execute[[ VarDefinition: definition -> type ID ]] (ReturnValuesDTO dto) =
     *      <' * > type.toString() ID < (offset > definition.offset <)>
     *
     *
     * Read statement
     * execute[[ ReadStatement: statement -> expression ]] (ReturnValuesDTO dto) =
     *      <' * Read>
     *      address[[ expression ]]
     *      <in> expression.type.suffix()
     *      <store> expression.type.suffix()
     *
     *
     * Write statement
     * execute[[ WriteStatement: statement -> expression ]] (ReturnValuesDTO dto) =
     *      <' * Write>
     *      value[[ expression ]]
     *      <out> expression.type.suffix()
     *
     *
     * Assignment
     * execute[[ Assignment: statement -> expression1 expression2 ]] (ReturnValuesDTO dto) =
     *      address[[ expression1 ]]
     *      value[[ expression2 ]]
     *      <store> expression1.type.suffix();
     *
     *
     * While
     * execute[[ While: statement -> expression statement* ]] (ReturnValuesDTO dto) =
     *      String conditionLabel = cg.nextlabel(), exitLabel = cg.nextLabel();
     *      conditionLabel <:>
     *      value[[ expression ]]
     *      <jz > exitLabel
     *      statement*.forEach( s -> execute[[ s ]] (dto) )
     *      <jmp > conditionLabel
     *      exitLabel <:>
     *
     *
     * IfElse
     * execute[[ IfElse: statement1 -> expression statement2* statement3* ]] (ReturnValuesDTO dto) =
     *      String elseLabel = cg.nextlabel(), exitLabel = cg.nextLabel():
     *      value[[ expression ]]
     *      <jz > elseLabel
     *      statement2*.forEach( s -> execute[[ s ]] (dto) )
     *      <jmp > exitLabel
     *      elseLabel <:>
     *      statement3*.forEach( s -> execute[[ s ]] (dto) )
     *      exitLabel <:>
     *
     * FuncInvocation
     * execute[[ FuncInvocation: statement -> expression1 expression2* ]] (ReturnValuesDTO dto) =
     *      Expression expression0 = (Expression) statement
     *      expression2*.forEach( e -> value[[ e ]] )
     *      <call > expression1.name
     *      if (!expression1.type.returnType instanceof VoidType) {
     *          <pop> expression1.type.returnType.suffix()
     *      }
     *
     *
     * ReturnStatement
     * execute[[ ReturnStatement: statement -> expression ]] (ReturnValuesDTO dto) =
     *      value[[ expression ]]
     *      <ret > dto.returnBytes <, > dto.localsBytes, <, > dto.paramsBytes
     */
    private ValueCGVisitor valueCGVisitor;
    private AddressCGVisitor addressCGVisitor;

    public ExecuteCGVisitor(CodeGenerator cg) {
        super(cg);
        this.valueCGVisitor = new ValueCGVisitor(cg);
        this.addressCGVisitor = new AddressCGVisitor(cg);
        this.valueCGVisitor.setAddressCGVisitor(this.addressCGVisitor);
        this.addressCGVisitor.setValueCGVisitor(this.valueCGVisitor);
    }

    @Override
    public Void visit(Program program, ReturnValuesDTO dto) {
        boolean halted = false;
        for (Definition def : program.getDefs()) {
            if (def instanceof FuncDefinition && !halted) {
                getCG().mainInvocation();
                halted = true;
            }
            def.accept(this, null);
        }
        return null;
    }

    @Override
    public Void visit(FuncDefinition funcDefinition, ReturnValuesDTO dto) {
        FunctionType ftype = (FunctionType)funcDefinition.getType();

        getCG().line(funcDefinition.getLine());
        getCG().label(funcDefinition.getName());
        getCG().comment("Parameters");
        ftype.getParams().forEach( p -> p.accept(this,null) );

        dto = new ReturnValuesDTO(
                ftype.getReturnType().numberOfBytes(),
                funcDefinition.getLocalsBytesSum(),
                ((FunctionType) funcDefinition.getType()).getParams().stream().mapToInt(vd -> vd.getType().numberOfBytes()).sum()
        );

        getCG().comment("Local variables");
        boolean entered = false;
        for (Statement st : funcDefinition.getStatements()) {
            if (!(st instanceof VarDefinition) && !entered) {
                getCG().enter(funcDefinition.getLocalsBytesSum());
                entered = true;
            }
            st.accept(this, dto);
        }
        int paramsBytesSum = ftype.getParams().stream().mapToInt( vd -> vd.getType().numberOfBytes() ).sum();
        if (ftype.getReturnType() instanceof VoidType) {
            int numParams = ftype.getParams().size();
            if (numParams == 0) {
                getCG().ret(0, funcDefinition.getLocalsBytesSum(), 0);
                return null;
            }
            getCG().ret(0, funcDefinition.getLocalsBytesSum(), paramsBytesSum);
        }
        return null;
    }

    @Override
    public Void visit(VarDefinition varDefinition, ReturnValuesDTO dto) {
        getCG().commentVariable(varDefinition);
        return null;
    }

    @Override
    public Void visit(ReadStatement readStatement, ReturnValuesDTO dto) {
        getCG().line(readStatement.getLine());
        getCG().comment("Read");
        readStatement.getExpression().accept(addressCGVisitor, null);
        getCG().in(readStatement.getExpression().getType().getSuffix());
        getCG().store(readStatement.getExpression().getType().getSuffix());
        return null;
    }

    @Override
    public Void visit(WriteStatement writeStatement, ReturnValuesDTO dto) {
        getCG().line(writeStatement.getLine());
        getCG().comment("Write");
        writeStatement.getExpression().accept(valueCGVisitor, null);
        getCG().out(writeStatement.getExpression().getType().getSuffix());
        return null;
    }

    @Override
    public Void visit(Assignment assignment, ReturnValuesDTO dto) {
        getCG().line(assignment.getLine());
        assignment.getLeft().accept(addressCGVisitor, null);
        assignment.getRight().accept(valueCGVisitor, null);
        getCG().store(assignment.getLeft().getType().getSuffix());
        return null;
    }

    @Override
    public Void visit(While whileStatement, ReturnValuesDTO dto) {
        String conditionLabel = getCG().nextLabel(), exitLabel = getCG().nextLabel();
        getCG().line(whileStatement.getLine());
        getCG().comment("While");
        getCG().label(conditionLabel);
        whileStatement.getCondition().accept(valueCGVisitor, null);
        getCG().jz(exitLabel);
        getCG().comment("Start of the while body");
        whileStatement.getBody().forEach( s -> s.accept(this, dto) );
        getCG().jmp(conditionLabel);
        getCG().comment("End of the while body");
        getCG().label(exitLabel);
        return null;
    }

    @Override
    public Void visit(IfElse ifElse, ReturnValuesDTO dto) {
        String elseLabel = getCG().nextLabel(), exitLabel = getCG().nextLabel();
        getCG().line(ifElse.getLine());
        getCG().comment("IfElse");
        ifElse.getCondition().accept(valueCGVisitor, null);
        getCG().jz(elseLabel);
        getCG().comment("Start of the if branch body");
        ifElse.getBody().forEach( s -> s.accept(this, dto) );
        getCG().jmp(exitLabel);
        getCG().comment("Start of the else branch body");
        getCG().label(elseLabel);
        ifElse.getElseBody().forEach( s -> s.accept(this, dto) );
        getCG().comment("End of the if-else bodies");
        getCG().label(exitLabel);
        return null;
    }

    @Override
    public Void visit(FuncInvocation funcInvocation, ReturnValuesDTO dto) {
        funcInvocation.getParams().forEach( p -> p.accept(valueCGVisitor, null) );
        getCG().call(funcInvocation.getVariable().getName());
        Type returnType = ((FunctionType)funcInvocation.getVariable().getType()).getReturnType();
        if (!(returnType instanceof VoidType)) {
            getCG().pop(returnType.getSuffix());
        }
        return null;
    }

    /* ReturnStatement
     * execute[[ ReturnStatement: statement -> expression ]] (ReturnValuesDTO dto) =
     *      value[[ expression ]]
     *      <ret > dto.returnBytes <, > dto.localsBytes, <, > dto.paramsBytes
     */
    @Override
    public Void visit(ReturnStatement returnStatement, ReturnValuesDTO dto) {
        returnStatement.getExpression().accept(valueCGVisitor, null);
        getCG().ret(dto.returnBytes, dto.localsBytes, dto.paramsBytes);
        return null;
    }

}
