package program.statements;

import program.expression.Expression;

import java.util.ArrayList;
import java.util.List;

public class IfElse extends AbstractStatement {

    private Expression condition;
    private List<Statement> body;
    private List<Statement> elseBody;

    public IfElse(int line, int column, Expression condition, List<Statement> body, List<Statement> elseBody) {
        super(line, column);
        this.condition = condition;
        this.body = new ArrayList<Statement>(body);
        this.elseBody = new ArrayList<Statement>(elseBody);
    }

    public IfElse(int line, int column, Expression condition, List<Statement> body) {
        super(line, column);
        this.condition = condition;
        this.body = new ArrayList<Statement>(body);
        this.elseBody = null;
    }

    public Expression getCondition() {
        return condition;
    }

    public List<Statement> getBody() {
        return body;
    }

    public List<Statement> getElseBody() {
        return elseBody;
    }
}
