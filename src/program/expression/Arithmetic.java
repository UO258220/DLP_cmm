package program.expression;

public class Arithmetic extends AbstractExpression {

    private String operator;
    private Expression left;
    private Expression right;

    public Arithmetic(int line, int column, String operator, Expression left, Expression right) {
        super(line, column);
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public String getOperator() {
        return operator;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }
}
