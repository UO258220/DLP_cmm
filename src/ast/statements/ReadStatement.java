package ast.statements;

import ast.expression.Expression;
import semantic.Visitor;

public class ReadStatement extends AbstractStatement {

    private Expression expression;

    public ReadStatement(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return String.format("ReadStatement[expression=%s]", expression.toString());
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
