package program.expression;

public class Remainder extends AbstractExpression {

    private Expression left;
    private Expression right;

    public Remainder(int line, int column, Expression left, Expression right) {
        super(line, column);
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }
}
