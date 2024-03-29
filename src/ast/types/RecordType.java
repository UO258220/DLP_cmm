package ast.types;

import ast.expression.Expression;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class RecordType extends AbstractType {

    private List<RecordField> fields;

    public RecordType(int line, int column, List<RecordField> fields) {
        super(line, column);
        this.fields = new ArrayList<RecordField>(fields);
    }

    public List<RecordField> getFields() {
        return fields;
    }

    public void addField(RecordField field) {
        if (getField(field.getName()) != null) {
            new ErrorType(field.getLine(), field.getColumn(),
                    String.format("Duplicated field \"%s\" in struct", field.getName()));
            return;
        }
        fields.add(field);
    }

    public RecordField getField(String name) {
        for (RecordField f : fields) {
            if (f.getName().equals(name)) {
                return f;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("record(");
        for ( RecordField field : getFields() ) {
            sb.append(String.format("(%s x %s)x", field.getName(), field.getType().toString()));
        }
        sb.setLength(sb.length() - 1);
        sb.append(")");
        return sb.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type dot(String name, int line, int column) {
        RecordField field = getField(name);
        return field == null ?
                new ErrorType(line, column, String.format("There is no field \"%s\" in struct type", name)) :
                field.getType();
    }

    @Override
    public int numberOfBytes() {
        return this.fields.stream().mapToInt(rf -> rf.getType().numberOfBytes()).sum();
    }

}
