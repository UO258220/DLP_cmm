package ast.types;

import semantic.Visitor;

public class DoubleType extends AbstractType {

    private static final int DOUBLE_BYTES = 4;

    public DoubleType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "DoubleType";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof DoubleType;
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
    public void asReadable() {
        // No error thrown
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
    public Type castTo(Type type, int line, int column) {
        if (type instanceof ErrorType) {
            return type;
        }
        if (type instanceof CharType) {
            return new CharType(line, column);
        }
        if (type instanceof IntegerType) {
            return new IntegerType(line, column);
        }
        if (type instanceof DoubleType) {
            return new DoubleType(line, column);
        }
        return new ErrorType(line, column, String.format("type %s cannot be casted to %s", this, type));
    }

    @Override
    public Type minus(int line, int column) {
        return new DoubleType(line, column);
    }

    @Override
    public Type arithmetic(Type type, int line, int column) {
        if (type instanceof ErrorType) {
            return type;
        }
        if (type instanceof DoubleType) {
            return new DoubleType(line, column);
        }
        return new ErrorType(line, column,
                String.format("types %s and %s cannot be the terms of an arithmetic operation", this, type));
    }

    @Override
    public Type compare(Type type, int line, int column) {
        if (type instanceof ErrorType) {
            return type;
        }
        if (type instanceof DoubleType) {
            return new IntegerType(line, column);
        }
        return new ErrorType(line, column, String.format("types %s and %s cannot be compared", this, type));
    }

    @Override
    public int numberOfBytes() {
        return DOUBLE_BYTES;
    }
}
