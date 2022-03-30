package ast.types;

import ast.AbstractASTNode;

import java.util.List;

public abstract class AbstractType extends AbstractASTNode implements Type {

    public AbstractType(int line, int column) {
        super(line, column);
    }

    public Type parenthesis(List<Type> argTypes) {
        return new ErrorType(getLine(), getColumn(), String.format("type %s does not support invocation", this));
    }

    public void isWritable() {
        new ErrorType(getLine(), getColumn(), String.format("type %s is not writable", this));
    }

    public void isReadable() {
        new ErrorType(getLine(), getColumn(), String.format("type %s is not readable", this));
    }

    public void assign(Type type) {
        new ErrorType(getLine(), getColumn(), String.format("type %s does not support assignment", this));
    }

    public void asBoolean() {
        new ErrorType(getLine(), getColumn(),
                String.format("expression of type %s cannot be used as boolean value", this));
    }

    public void isReturning(Type type) {
        new ErrorType(getLine(), getColumn(),
                String.format("expression of type %s is not allowed as a return value", this));
    }

    public Type squareBrackets(Type type) {
        return new ErrorType(getLine(), getColumn(), String.format("type %s cannot be indexed", this));
    }

    public Type dot(String field) {
        return new ErrorType(getLine(), getColumn(), String.format("type %s does not support field access", this));
    }

    public Type castTo(Type type) {
        return new ErrorType(getLine(), getColumn(), String.format("type %s does not support cast", this));
    }

    public Type minus() {
        return new ErrorType(getLine(), getColumn(), String.format("type %s does not support unary minus", this));
    }

    public Type not() {
        return new ErrorType(getLine(), getColumn(), String.format("type %s does not support negation", this));
    }

    public Type arithmetic(Type type) {
        return new ErrorType(getLine(), getColumn(),
                String.format("type %s does not support arithmetic operations", this));
    }

    public Type module(Type type) {
        return new ErrorType(getLine(), getColumn(), String.format("type %s does not support module", this));
    }

    public Type compare(Type type) {
        return new ErrorType(getLine(), getColumn(), String.format("type %s does not support comparison", this));
    }

    public Type logical(Type type) {
        return new ErrorType(getLine(), getColumn(),
                String.format("type %s does not support logical operations", this));
    }
}
