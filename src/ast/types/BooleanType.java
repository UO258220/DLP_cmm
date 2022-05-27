package ast.types;

import codegeneration.CodeGenerator;
import semantic.Visitor;

public class BooleanType extends AbstractType {

    private static final int BOOL_BYTES = 2;

    public BooleanType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "boolean";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof BooleanType;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public void asWritable() {
        // No error thrown
    }

    @Override
    public void asBoolean(int line, int column) {
        // No error thrown
    }

    @Override
    public Type logical(Type type, int line, int column) {
        if (type instanceof ErrorType) {
            return type;
        }
        if (type instanceof BooleanType) {
            return new BooleanType(line, column);
        }
        return new ErrorType(line, column,
                String.format("types %s and %s cannot be the terms of a logical operation", this, type));
    }

    @Override
    public Type not(int line, int column) {
        return new BooleanType(line, column);
    }

    @Override
    public void assign(Type type, int line, int column) {
        if (type instanceof ErrorType) {
            // For now, the only thing to do here is to stop the creation of a new error
            return;
        }
        if (!this.equals(type)) {
            new ErrorType(line, column, String.format("type %s cannot be assigned to type %s", type, this));
        }
    }

    @Override
    public void returnMatching(Type type, int line, int column) {
        if (type instanceof ErrorType) {
            // For now, the only thing to do here is to stop the creation of a new error
            return;
        }
        if (!this.equals(type)) {
            new ErrorType(line, column, String.format("type %s cannot be returned, expected %s", this, type));
        }
    }

    @Override
    public int numberOfBytes() {
        return BOOL_BYTES;
    }

    @Override
    public char getSuffix() {
        return 'i';
    }
}
