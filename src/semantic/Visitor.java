package semantic;

import ast.*;
import ast.expression.*;
import ast.expression.Module;
import ast.statements.*;
import ast.types.*;

public interface Visitor<TP,TR> {

    public TR visit(Program program, TP param);

    public TR visit(FuncDefinition funcDefinition, TP param);

    public TR visit(VarDefinition varDefinition, TP param);

    public TR visit(FunctionType functionType, TP param);

    public TR visit(ArrayType arrayType, TP param);

    public TR visit(RecordType recordType, TP param);

    public TR visit(RecordField recordField, TP param);

    public TR visit(VoidType voidType, TP param);

    public TR visit(DoubleType doubleType, TP param);

    public TR visit(IntegerType integerType, TP param);

    public TR visit(CharType charType, TP param);

    public TR visit(ErrorType errorType, TP param);

    public TR visit(FuncInvocation funcInvocation, TP param);

    public TR visit(WriteStatement writeStatement, TP param);

    public TR visit(ReadStatement readStatement, TP param);

    public TR visit(Assignment assignment, TP param);

    public TR visit(While whileStmt, TP param);

    public TR visit(IfElse ifElse, TP param);

    public TR visit(ReturnStatement returnStatement, TP param);

    public TR visit(Indexing indexing, TP param);

    public TR visit(FieldAccess fieldAccess, TP param);

    public TR visit(Cast cast, TP param);

    public TR visit(UnaryMinus unaryMinus, TP param);

    public TR visit(Negation negation, TP param);

    public TR visit(Arithmetic arithmetic, TP param);

    public TR visit(Module module, TP param);

    public TR visit(Comparison comparison, TP param);

    public TR visit(Logical logical, TP param);

    public TR visit(Variable variable, TP param);

    public TR visit(IntLiteral intLiteral, TP param);

    public TR visit(CharLiteral charLiteral, TP param);

    public TR visit(RealLiteral realLiteral, TP param);
}
