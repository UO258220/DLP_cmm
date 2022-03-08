package errorhandler;

import ast.types.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {

    private static ErrorHandler instance = null;

    private List<ErrorType> errors = new ArrayList<ErrorType>();

    public static ErrorHandler getInstance() {
        if (instance == null) {
            instance = new ErrorHandler();
        }
        return instance;
    }

    public boolean anyErrors() {
        return !errors.isEmpty();
    }

    public void showErrors(PrintStream out) {
        errors.forEach(out::println);
    }

    public void addError(ErrorType error) {
        errors.add(error);
    }
}
