package semantic;

import ast.FuncDefinition;
import ast.Program;
import ast.VarDefinition;
import ast.expression.*;
import ast.statements.*;
import ast.types.*;

public abstract class AbstractVisitor<TP,TR> implements Visitor<TP,TR> {

    public TR visit(Program program, TP param) {
        program.getDefs().forEach(def -> def.accept(this, null));
        return null;
    }

    public TR visit(FuncDefinition funcDefinition, TP param) {
        funcDefinition.getType().accept(this, null);
        funcDefinition.getStatements().forEach(st -> st.accept(this, null));
        return null;
    }

    @Override
    public TR visit(VarDefinition varDefinition, TP param) {
        varDefinition.getType().accept(this, null);
        return null;
    }

    @Override
    public TR visit(FunctionType functionType, TP param) {
        functionType.getReturnType().accept(this, null);
        functionType.getParams().forEach(p -> p.accept(this, null));
        return null;
    }

    @Override
    public TR visit(ArrayType arrayType, TP param) {
        arrayType.getInnerType().accept(this, null);
        return null;
    }

    @Override
    public TR visit(RecordType recordType, TP param) {
        recordType.getFields().forEach(rf -> rf.accept(this, null));
        return null;
    }

    @Override
    public TR visit(RecordField recordField, TP param) {
        recordField.getType().accept(this, null);
        return null;
    }

    @Override
    public TR visit(VoidType voidType, TP param) {
        return null;
    }

    @Override
    public TR visit(DoubleType doubleType, TP param) {
        return null;
    }

    @Override
    public TR visit(IntegerType integerType, TP param) {
        return null;
    }

    @Override
    public TR visit(CharType charType, TP param) {
        return null;
    }

    @Override
    public TR visit(ErrorType charType, TP param) {
        return null;
    }

    @Override
    public TR visit(FuncInvocation funcInvocation, TP param) {
        funcInvocation.getVariable().accept(this, null);
        funcInvocation.getParams().forEach(p -> p.accept(this, null));
        return null;
    }

    @Override
    public TR visit(WriteStatement writeStatement, TP param) {
        writeStatement.getExpression().accept(this, null);
        return null;
    }

    @Override
    public TR visit(ReadStatement readStatement, TP param) {
        readStatement.getExpression().accept(this, null);
        return null;
    }

    @Override
    public TR visit(Assignment assignment, TP param) {
        assignment.getLeft().accept(this, null);
        assignment.getRight().accept(this, null);
        return null;
    }

    @Override
    public TR visit(While whileStmt, TP param) {
        whileStmt.getCondition().accept(this, null);
        whileStmt.getBody().forEach(st -> st.accept(this, null));
        return null;
    }

    @Override
    public TR visit(IfElse ifElse, TP param) {
        ifElse.getCondition().accept(this, null);
        ifElse.getBody().forEach(st -> st.accept(this, null));
        if (ifElse.getElseBody() != null) {
            ifElse.getElseBody().forEach(st -> st.accept(this, null));
        }
        return null;
    }

    @Override
    public TR visit(ReturnStatement returnStatement, TP param) {
        returnStatement.getExpression().accept(this, null);
        return null;
    }

    @Override
    public TR visit(Indexing indexing, TP param) {
        indexing.getLeft().accept(this, null);
        indexing.getRight().accept(this, null);
        return null;
    }

    @Override
    public TR visit(FieldAccess fieldAccess, TP param) {
        fieldAccess.getExpression().accept(this, null);
        return null;
    }

    @Override
    public TR visit(Cast cast, TP param) {
        cast.getCastType().accept(this, null);
        cast.getExpression().accept(this, null);
        return null;
    }

    @Override
    public TR visit(UnaryMinus unaryMinus, TP param) {
        unaryMinus.getExpression().accept(this, null);
        return null;
    }

    @Override
    public TR visit(Negation negation, TP param) {
        negation.getExpression().accept(this, null);
        return null;
    }

    @Override
    public TR visit(Arithmetic arithmetic, TP param) {
        arithmetic.getLeft().accept(this, null);
        arithmetic.getRight().accept(this, null);
        return null;
    }

    @Override
    public TR visit(Comparison comparison, TP param) {
        comparison.getLeft().accept(this, null);
        comparison.getRight().accept(this, null);
        return null;
    }

    @Override
    public TR visit(Logical logical, TP param) {
        logical.getLeft().accept(this, null);
        logical.getRight().accept(this, null);
        return null;
    }

    @Override
    public TR visit(Variable variable, TP param) {
        return null;
    }

    @Override
    public TR visit(IntLiteral intLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(CharLiteral charLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(RealLiteral realLiteral, TP param) {
        return null;
    }

}
