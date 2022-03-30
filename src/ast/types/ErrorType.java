package ast.types;

import ast.expression.Expression;
import errorhandler.ErrorHandler;
import semantic.Visitor;

import java.util.List;

public class ErrorType extends AbstractType {

    private String message;

    public ErrorType(int line, int column, String message) {
        super(line, column);
        this.message = message;
        ErrorHandler.getInstance().addError(this);
    }

    @Override
    public String toString() {
        return String.format("ERROR: %s on %d:%d", message, getLine(), getColumn());
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type parenthesis(List<Type> argTypes) {
        return this;
    }

    @Override
    public Type squareBrackets(Type type) {
        return this;
    }

    @Override
    public Type dot(String field, Expression expression) {
        return this;
    }

    @Override
    public Type castTo(Type type, Expression expression) {
        return this;
    }

    @Override
    public Type minus() {
        return this;
    }

    @Override
    public Type not() {
        return this;
    }

    @Override
    public Type arithmetic(Type type) {
        return this;
    }

    @Override
    public Type module(Type type) {
        return this;
    }

    @Override
    public Type compare(Type type) {
        return this;
    }

    @Override
    public Type logical(Type type) {
        return this;
    }

    @Override
    public void isWritable() { }

    @Override
    public void isReadable() { }

    @Override
    public void assign(Type type) { }

    @Override
    public void asBoolean() { }

    @Override
    public void isReturning(Type type) { }
}
