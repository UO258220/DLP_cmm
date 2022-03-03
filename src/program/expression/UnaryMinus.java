package program.expression;

public class UnaryMinus extends AbstractExpression {

    private Expression expression;

    public UnaryMinus(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return String.format("UnaryMinus[expression=%s]", expression.toString());
    }
}
