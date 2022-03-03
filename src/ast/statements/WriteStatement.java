package ast.statements;

import ast.expression.Expression;

public class WriteStatement extends AbstractStatement {

    private Expression expression;

    public WriteStatement(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return String.format("WriteStatement[expression=%s]", expression.toString());
    }
}
