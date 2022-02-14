package program.expression;

public class FieldAccess extends AbstractExpression {

    private String name;
    private Expression expression;

    public FieldAccess(int line, int column, String name, Expression expression) {
        super(line, column);
        this.name = name;
        this.expression = expression;
    }

    public String getName() {
        return name;
    }

    public Expression getExpression() {
        return expression;
    }
}
