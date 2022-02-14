package program.expression;

import program.statements.AbstractStatement;

public class Negation extends AbstractStatement {

    private Expression expression;

    public Negation(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }
}
