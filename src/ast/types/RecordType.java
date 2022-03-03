package ast.types;

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
}
