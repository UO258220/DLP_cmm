package ast.statements;

import ast.expression.Expression;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class While extends AbstractStatement {

    private Expression condition;
    private List<Statement> body;

    public While(int line, int column, Expression condition, List<Statement> body) {
        super(line, column);
        this.condition = condition;
        this.body = new ArrayList<Statement>(body);
    }

    public Expression getCondition() {
        return condition;
    }

    public List<Statement> getBody() {
        return body;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(String.format("WhileStatement[condition=%s, body=[", condition.toString()));
        for (Statement s : body) {
            res.append(String.format("\n%s", s.toString()));
        }
        return res.append("]]").toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
