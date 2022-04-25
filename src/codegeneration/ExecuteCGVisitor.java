package codegeneration;

import ast.*;
import ast.statements.Assignment;
import ast.statements.ReadStatement;
import ast.statements.Statement;
import ast.statements.WriteStatement;
import ast.types.FunctionType;
import ast.types.VoidType;

public class ExecuteCGVisitor extends AbstractCGVisitor<Void, Void> {

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
     *      type.definitions.forEach( d -> execute[[ d ]] )
     *      <' * Local variables>
     *      statement*.forEach( s -> execute[[ s ]] )
     *      if ( type.returnType instanceof VoidType ) {
     *          <ret 0, > definition.localsBytesSum <, > definition.type.paramsBytesSum
     *      }
     *
     *
     * Variable definition
     * execute[[ VarDefinition: definition -> type ID ]] =
     *      <' * > type.toString() ID < (offset > definition.offset <)>
     *
     *
     * Read statement
     * execute[[ ReadStatement: statement -> expression ]] =
     *      <' * Read>
     *      address[[ expression ]]
     *      <in> expression.type.suffix()
     *      <store> expression.type.suffix()
     *
     *
     * Write statement
     * execute[[ WriteStatement: statement -> expression ]] =
     *      <' * Write>
     *      value[[ expression ]]
     *      <out> expression.type.suffix()
     *
     *
     * Assignment
     * execute[[ Assignment: statement -> expression1 expression2 ]] =
     *      address[[ expression1 ]]
     *      value[[ expression2 ]]
     *      <store> expression1.type.suffix();
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
    public Void visit(Program program, Void param) {
        for (Definition def : program.getDefs()) {
            if (def instanceof FuncDefinition) {
                getCG().mainInvocation();
            }
            def.accept(this, null);
        }
        return null;
    }

    @Override
    public Void visit(FuncDefinition funcDefinition, Void param) {
        FunctionType ftype = (FunctionType)funcDefinition.getType();

        getCG().line(funcDefinition.getLine());
        getCG().functionLabel(funcDefinition.getName());
        getCG().comment("Parameters");
        ftype.getParams().forEach( p -> p.accept(this,null) );

        getCG().comment("Local variables");
        boolean entered = false;
        for (Statement st : funcDefinition.getStatements()) {
            if (!(st instanceof VarDefinition) && !entered) {
                getCG().enter(funcDefinition.getLocalsBytesSum());
                entered = true;
            }
            st.accept(this, null);
        }

        if (ftype.getReturnType() instanceof VoidType) {
            int numParams = ftype.getParams().size();
            if (numParams == 0) {
                getCG().ret(0, funcDefinition.getLocalsBytesSum(), 0);
                return null;
            }
            getCG().ret(0, funcDefinition.getLocalsBytesSum(),
                    ftype.getParams().get(numParams - 1).getOffset() - 4);
        }
        return null;
    }

    @Override
    public Void visit(VarDefinition varDefinition, Void param) {
        getCG().commentVariable(varDefinition);
        return null;
    }

    @Override
    public Void visit(ReadStatement readStatement, Void param) {
        getCG().line(readStatement.getLine());
        getCG().comment("Read");
        readStatement.getExpression().accept(addressCGVisitor, null);
        getCG().in(readStatement.getExpression().getType().getSuffix());
        getCG().store(readStatement.getExpression().getType().getSuffix());
        return null;
    }

    @Override
    public Void visit(WriteStatement writeStatement, Void param) {
        getCG().line(writeStatement.getLine());
        getCG().comment("Write");
        writeStatement.getExpression().accept(valueCGVisitor, null);
        getCG().out(writeStatement.getExpression().getType().getSuffix());
        return null;
    }

    @Override
    public Void visit(Assignment assignment, Void param) {
        getCG().line(assignment.getLine());
        assignment.getLeft().accept(addressCGVisitor, null);
        assignment.getRight().accept(valueCGVisitor, null);
        getCG().store(assignment.getLeft().getType().getSuffix());
        return null;
    }

}
