package program.types;

public class RecordField {

    private Type type;
    private String name;

    public RecordField(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
