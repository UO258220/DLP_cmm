package ast.types;

import errorhandler.ErrorHandler;
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
        StringBuilder res = new StringBuilder("RecordType[fields=[");
        for (RecordField f : fields) {
            res.append(String.format("\n%s", f.toString()));
        }
        return res.append("]]").toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
