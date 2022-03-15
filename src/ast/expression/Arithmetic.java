package ast.expression;

import semantic.Visitor;

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

    @Override
    public String toString() {
        return String.format("Arithmetic[operator=%s, left=%s, right=%s]", operator, left.toString(), right.toString());
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
