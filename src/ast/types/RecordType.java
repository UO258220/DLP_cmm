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
        for (RecordField f : fields) {
            if (field.getName().equals(f.getName())) {
                new ErrorType(field.getLine(), field.getColumn(),
                        String.format("Duplicated field \"%s\" in struct", field.getName()));
                return;
            }
        }
        fields.add(field);
    }

    @Override
    public String toString() {
        return "RecordType";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type dot(String name, int line, int column) {
        for (RecordField f : fields) {
            if (f.getName().equals(name)) {
                return f.getType();
            }
        }
        return new ErrorType(line, column, String.format("There is no field \"%s\" in struct type", name));
    }

    @Override
    public int numberOfBytes() {
        return this.fields.stream().mapToInt(rf -> rf.getType().numberOfBytes()).sum();
    }

}
