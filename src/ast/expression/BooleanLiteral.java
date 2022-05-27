package ast.expression;

import semantic.Visitor;

public class BooleanLiteral extends AbstractExpression {

    private int value;

    public BooleanLiteral(int line, int column, int value) {
        super(line, column);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("BooleanLiteral[value=%s]", value == 0 ? "false" : "true");
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
