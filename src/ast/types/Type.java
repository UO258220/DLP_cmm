package ast.types;

import ast.ASTNode;

import java.util.List;

public interface Type extends ASTNode {
    Type parenthesis(List<Type> argTypes);
    void isWritable();
    void isReadable();
    void assign(Type type);
    void asBoolean();
    void isReturning(Type type);
    Type squareBrackets(Type type);
    Type dot(String field);
    Type castTo(Type type);
    Type minus();
    Type not();
    Type arithmetic(Type type);
    Type module(Type type);
    Type compare(Type type);
    Type logical(Type type);
}
