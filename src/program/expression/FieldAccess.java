package program.expression;

public class FieldAccess extends AbstractExpression {

    private Expression expression;
    private String field;

    public FieldAccess(int line, int column, Expression expression, String field) {
        super(line, column);
        this.expression = expression;
        this.field = field;
    }

    public Expression getExpression() {
        return expression;
    }

    public String getField() {
        return field;
    }

    @Override
    public String toString() {
        return String.format("FieldAccess[expression=%s, right=%s]",expression.toString(), field);
    }
}
