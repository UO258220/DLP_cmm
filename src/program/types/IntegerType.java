package program.types;

public class IntegerType extends AbstractType {
    public IntegerType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "IntegerType[]";
    }
}
