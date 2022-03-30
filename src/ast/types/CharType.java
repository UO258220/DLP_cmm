package ast.types;

import semantic.Visitor;

public class CharType extends AbstractType {
    public CharType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "CharType[]";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof CharType;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public void isWritable() {
        // No error thrown
    }

    @Override
    public void isReadable() {
        // No error thrown
    }

    @Override
    public void assign(Type type) {
        if (type instanceof ErrorType) {
            // For now, the only thing to do here is to stop the creation of a new error
            return;
        }
        if (!this.equals(type)) {
            new ErrorType(getLine(), getColumn(), String.format("type %s cannot be assigned to type %s", type, this));
        }
    }

    @Override
    public void isReturning(Type type) {
        if (type instanceof ErrorType) {
            // For now, the only thing to do here is to stop the creation of a new error
            return;
        }
        if (!this.equals(type)) {
            new ErrorType(getLine(), getColumn(), String.format("type %s cannot be returned, expected %s", this, type));
        }
    }

    @Override
    public Type castTo(Type type) {
        if (type instanceof ErrorType) {
            return type;
        }
        if (type instanceof CharType) {
            return this;
        }
        if (type instanceof IntegerType) {
            return new IntegerType(getLine(), getColumn());
        }
        return new ErrorType(getLine(), getColumn(), String.format("type %s cannot be casted to %s", this, type));
    }

    @Override
    public Type arithmetic(Type type) {
        if (type instanceof ErrorType) {
            return type;
        }
        if (type instanceof CharType) {
            return new IntegerType(getLine(), getColumn());
        }
        if (type instanceof IntegerType) {
            return new IntegerType(getLine(), getColumn());
        }
        return new ErrorType(getLine(), getColumn(),
                String.format("types %s and %s cannot be the terms of an arithmetic operation", this, type));
    }

    @Override
    public Type compare(Type type) {
        if (type instanceof ErrorType) {
            return type;
        }
        if (type instanceof CharType) {
            return new IntegerType(getLine(), getColumn());
        }
        return new ErrorType(getLine(), getColumn(), String.format("types %s and %s cannot be compared", this, type));
    }
}
