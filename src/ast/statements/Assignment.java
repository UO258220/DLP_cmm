package ast.statements;

import ast.expression.Expression;

public class Assignment extends AbstractStatement {

    private Expression left;
    private Expression right;

    public Assignment(int line, int column, Expression left, Expression right) {
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
        return String.format("Assignment[left=%s, right=%s]", left.toString(), right.toString());
    }
}
