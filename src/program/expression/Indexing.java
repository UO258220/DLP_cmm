package program.expression;

public class Indexing extends AbstractExpression {

    private Expression left;
    private Expression right;

    public Indexing(int line, int column, Expression left, Expression right) {
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

    @Override
    public String toString() {
        return String.format("Indexing[left=%s, right=%s]", left.toString(), right.toString());
    }
}
