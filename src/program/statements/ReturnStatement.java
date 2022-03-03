package program.statements;

import program.expression.Expression;

import java.util.ArrayList;
import java.util.List;

public class ReturnStatement extends AbstractStatement {

    private Expression expression;

    public ReturnStatement(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return String.format("ReturnStatement[expression=%s]", expression.toString());
    }
}
