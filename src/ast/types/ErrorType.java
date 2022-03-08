package ast.types;

import errorhandler.ErrorHandler;

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
}
