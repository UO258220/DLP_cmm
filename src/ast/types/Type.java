package ast.types;

import ast.ASTNode;
import ast.expression.Expression;
import codegeneration.CodeGenerator;

import java.util.List;

public interface Type extends ASTNode {
    void asWritable();
    void asReadable();
    void asBoolean(int line, int column);
    void assign(Type type, int line, int column);
    void returnMatching(Type type, int line, int column);
    Type parenthesis(List<Type> argTypes, int line, int column);
    Type squareBrackets(Type type, int line, int column);
    Type dot(String field, int line, int column);
    Type castTo(Type type, int line, int column);
    Type minus(int line, int column);
    Type not(int line, int column);
    Type arithmetic(Type type, int line, int column);
    Type compare(Type type, int line, int column);
    Type logical(Type type, int line, int column);

    int numberOfBytes();
    char getSuffix();
    void convertTo(Type type, CodeGenerator cg);
    char promoteToInt(CodeGenerator cg);
}
