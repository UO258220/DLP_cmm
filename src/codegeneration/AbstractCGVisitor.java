package codegeneration;

import ast.FuncDefinition;
import ast.Program;
import ast.VarDefinition;
import ast.expression.*;
import ast.statements.*;
import ast.types.*;
import semantic.Visitor;

public abstract class AbstractCGVisitor<TP,TR> implements Visitor<TP,TR> {

    private CodeGenerator cg;

    public AbstractCGVisitor(CodeGenerator cg) {
        this.cg = cg;
    }

    public CodeGenerator getCG() {
        return cg;
    }

    @Override
    public TR visit(Program program, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(FuncDefinition funcDefinition, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(VarDefinition varDefinition, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(FunctionType functionType, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(ArrayType arrayType, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(RecordType recordType, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(RecordField recordField, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(VoidType voidType, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(DoubleType doubleType, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(IntegerType integerType, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(CharType charType, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(ErrorType errorType, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(FuncInvocation funcInvocation, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(WriteStatement writeStatement, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(ReadStatement readStatement, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(Assignment assignment, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(While whileStmt, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(IfElse ifElse, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(ReturnStatement returnStatement, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(Indexing indexing, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(FieldAccess fieldAccess, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(Cast cast, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(UnaryMinus unaryMinus, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(Negation negation, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(Arithmetic arithmetic, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(Comparison comparison, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(Logical logical, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(Variable variable, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(IntLiteral intLiteral, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(CharLiteral charLiteral, TP param) {
        throw new IllegalStateException();
    }

    @Override
    public TR visit(RealLiteral realLiteral, TP param) {
        throw new IllegalStateException();
    }
}
