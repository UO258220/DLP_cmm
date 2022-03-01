package program.expression;

public class FieldAccess extends AbstractExpression {

    private Expression expression;
    private String name;

    public FieldAccess(int line, int column, Expression expression, String name) {
        super(line, column);
        this.expression = expression;
        this.name = name;
    }

    public Expression getExpression() {
        return expression;
    }

    public String getName() {
        return name;
    }
}
