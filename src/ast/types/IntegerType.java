package ast.types;

import semantic.Visitor;

public class IntegerType extends AbstractType {

    private static final int INT_BYTES = 2;

    public IntegerType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "IntegerType";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof IntegerType;
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
    public void asBoolean(int line, int column) {
        // No error thrown
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
        return new IntegerType(line, column);
    }

    @Override
    public Type not(int line, int column) {
        return new IntegerType(line, column);
    }

    @Override
    public Type arithmetic(Type type, int line, int column) {
        if (type instanceof ErrorType) {
            return type;
        }
        if (type instanceof IntegerType) {
            return new IntegerType(line, column);
        }
        return new ErrorType(line, column,
                String.format("types %s and %s cannot be the terms of an arithmetic operation", this, type));
    }

    @Override
    public Type module(Type type, int line, int column) {
        if (type instanceof ErrorType) {
            return type;
        }
        if (type instanceof IntegerType) {
            return new IntegerType(line, column);
        }
        return new ErrorType(line, column,
                String.format("types %s and %s cannot be the terms of a module operation", this, type));
    }

    @Override
    public Type compare(Type type, int line, int column) {
        if (type instanceof ErrorType) {
            return type;
        }
        if (type instanceof IntegerType) {
            return new IntegerType(line, column);
        }
        return new ErrorType(line, column, String.format("types %s and %s cannot be compared", this, type));
    }

    @Override
    public Type logical(Type type, int line, int column) {
        if (type instanceof ErrorType) {
            return type;
        }
        if (type instanceof IntegerType) {
            return new IntegerType(line, column);
        }
        return new ErrorType(line, column,
                String.format("types %s and %s cannot be the terms of a logical operation", this, type));
    }

    @Override
    public int numberOfBytes() {
        return INT_BYTES;
    }

}
