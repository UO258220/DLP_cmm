package visitors;

import ast.*;
import ast.expression.*;
import ast.statements.*;
import ast.types.*;

public interface Visitor<TP,TR> {

    public TR visit(Program ast, TP param);

    public TR visit(FuncDefinition ast, TP param);

    public TR visit(VarDefinition ast, TP param);

    public TR visit(FunctionType ast, TP param);

    public TR visit(ArrayType ast, TP param);

    public TR visit(RecordType ast, TP param);

    public TR visit(VoidType ast, TP param);

    public TR visit(DoubleType ast, TP param);

    public TR visit(IntegerType ast, TP param);

    public TR visit(CharType ast, TP param);

    public TR visit(FuncInvocation ast, TP param);

    public TR visit(WriteStatement ast, TP param);

    public TR visit(ReadStatement ast, TP param);

    public TR visit(Assignment ast, TP param);

    public TR visit(While ast, TP param);

    public TR visit(IfElse ast, TP param);

    public TR visit(ReturnStatement ast, TP param);

    public TR visit(Indexing ast, TP param);

    public TR visit(FieldAccess ast, TP param);

    public TR visit(Cast ast, TP param);

    public TR visit(UnaryMinus ast, TP param);

    public TR visit(Negation ast, TP param);

    public TR visit(Arithmetic ast, TP param);

    public TR visit(Comparison ast, TP param);

    public TR visit(Logical ast, TP param);

    public TR visit(Variable ast, TP param);

    public TR visit(IntLiteral ast, TP param);

    public TR visit(CharLiteral ast, TP param);

    public TR visit(RealLiteral ast, TP param);

}
