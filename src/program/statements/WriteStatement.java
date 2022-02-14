package program.statements;

import program.expression.Expression;

public class WriteStatement extends AbstractStatement {

    private Expression expression;

    public WriteStatement(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }
}
