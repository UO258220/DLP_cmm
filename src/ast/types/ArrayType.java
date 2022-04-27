package ast.types;

import semantic.Visitor;

public class ArrayType extends AbstractType {

    private int size;
    private Type innerType;

    public ArrayType(int line, int column, int size, Type innerType) {
        super(line, column);
        this.size = size;
        this.innerType = innerType;
    }

    public int getSize() {
        return size;
    }

    public Type getInnerType() {
        return innerType;
    }

    public void setInnerType(Type innerType) {
        this.innerType = innerType;
    }

    @Override
    public String toString() {
        return String.format("[%d,%s]", size, innerType.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ArrayType that) {
            return this.getInnerType().equals(that.getInnerType()) && this.getSize() == that.getSize();
        }
        return false;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
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
    public Type squareBrackets(Type type, int line, int column) {
        if (type instanceof ErrorType) {
            return type;
        }
        if (type instanceof IntegerType) {
            return innerType;
        }
        return new ErrorType(line, column, String.format("type %s cannot be used as index", type));
    }

    @Override
    public int numberOfBytes() {
        return this.size * this.innerType.numberOfBytes();
    }
}
