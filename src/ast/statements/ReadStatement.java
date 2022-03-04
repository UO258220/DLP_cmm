package ast.statements;

import ast.expression.Expression;

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
}