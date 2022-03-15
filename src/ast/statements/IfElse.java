package ast.statements;

import ast.expression.Expression;
import semantic.Visitor;

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

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(String.format("IfElseStatement[condition=%s, body=[", condition.toString()));
        for (Statement s : body) {
            res.append(String.format("\n%s", s.toString()));
        }
        if (elseBody != null) {
            res.append("\n], elseBody=[");
            for (Statement s : elseBody) {
                res.append(String.format("\n%s", s.toString()));
            }
        }
        return res.append("]]").toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
