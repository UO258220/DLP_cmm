package ast.types;

public class RecordField extends AbstractType {

    private Type type;
    private String name;

    public RecordField(int line, int column, Type type, String name) {
        super(line, column);
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("RecordField[type=%s, name=%s]", type.toString(), name);
    }
}
