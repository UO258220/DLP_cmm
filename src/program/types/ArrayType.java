package program.types;

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
}
