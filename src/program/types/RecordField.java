package program.types;

import program.VarDefinition;

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

    @Override
    public String toString() {
        return String.format("RecordField[type=%s, name=%s]", type.toString(), name);
    }
}
