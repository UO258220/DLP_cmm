package ast.types;

import ast.AbstractASTNode;
import ast.expression.Expression;
import codegeneration.CodeGenerator;

import java.util.List;

public abstract class AbstractType extends AbstractASTNode implements Type {

    public AbstractType(int line, int column) {
        super(line, column);
    }

    public void asWritable() {
        new ErrorType(getLine(), getColumn(),
                String.format("type %s is not writable", this));
    }

    public void asReadable() {
        new ErrorType(getLine(), getColumn(),
                String.format("type %s is not readable", this));
    }

    public void asBoolean(int line, int column) {
        new ErrorType(line, column, String.format("expression of type %s cannot be used as boolean value", this));
    }

    public void assign(Type type, int line, int column) {
        new ErrorType(line, column, String.format("type %s does not support assignment", this));
    }

    public void returnMatching(Type type, int line, int column) {
        new ErrorType(line, column, String.format("expression of type %s is not allowed as a return value", this));
    }

    public Type parenthesis(List<Type> argTypes, int line, int column) {
        return new ErrorType(line, column, String.format("type %s does not support invocation", this));
    }

    public Type squareBrackets(Type type, int line, int column) {
        return new ErrorType(line, column, String.format("type %s cannot be indexed", this));
    }

    public Type dot(String field, int line, int column) {
        return new ErrorType(line, column, String.format("type %s does not support field access", this));
    }

    public Type castTo(Type type, int line, int column) {
        return new ErrorType(line, column, String.format("type %s does not support cast", this));
    }

    public Type minus(int line, int column) {
        return new ErrorType(line, column, String.format("type %s does not support unary minus", this));
    }

    public Type not(int line, int column) {
        return new ErrorType(line, column, String.format("type %s does not support negation", this));
    }

    public Type arithmetic(Type type, int line, int column) {
        return new ErrorType(line, column, String.format("type %s does not support arithmetic operations", this));
    }

    public Type module(Type type, int line, int column) {
        return new ErrorType(line, column, String.format("type %s does not support module", this));
    }

    public Type compare(Type type, int line, int column) {
        return new ErrorType(line, column, String.format("type %s does not support comparison", this));
    }

    public Type logical(Type type, int line, int column) {
        return new ErrorType(line, column, String.format("type %s does not support logical operations", this));
    }

    public int numberOfBytes() {
        throw new IllegalStateException("Number of bytes - unsupported");
    }

    public char getSuffix() {
        throw new IllegalStateException("Suffix - unsupported");
    }

    public void convertTo(Type type, CodeGenerator cg) {
        throw new IllegalStateException("Conversion - unsupported");
    }

    public char promoteToInt(CodeGenerator cg) {
        throw new IllegalStateException("Integer promotion - unsupported");
    }
}
