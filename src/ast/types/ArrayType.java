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

/**
    public ArrayType(int line, int column, List<Integer> sizes, Type baseType) {
        super(line, column);
        this.size = sizes.get(0);
        if (sizes.size() > 1) {
            this.innerType = new ArrayType(line, column, sizes.subList(1, sizes.size()), baseType);
        }
        else {
            this.innerType = baseType;
        }
    }
**/

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
        return String.format("ArrayType[type=%s, size=%d]", innerType.toString(), size);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
