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
    public Type parenthesis(List<Type> argTypes, int line, int column) {
        return this;
    }

    @Override
    public Type squareBrackets(Type type, int line, int column) {
        return this;
    }

    @Override
    public Type dot(String field, int line, int column) {
        return this;
    }

    @Override
    public Type castTo(Type type, int line, int column) {
        return this;
    }

    @Override
    public Type minus(int line, int column) {
        return this;
    }

    @Override
    public Type not(int line, int column) {
        return this;
    }

    @Override
    public Type arithmetic(Type type, int line, int column) {
        return this;
    }

    @Override
    public Type module(Type type, int line, int column) {
        return this;
    }

    @Override
    public Type compare(Type type, int line, int column) {
        return this;
    }

    @Override
    public Type logical(Type type, int line, int column) {
        return this;
    }

    @Override
    public void asWritable() { }

    @Override
    public void asReadable() { }

    @Override
    public void assign(Type type, int line, int column) { }

    @Override
    public void asBoolean(int line, int column) { }

    @Override
    public void returnMatching(Type type, int line, int column) { }
}
