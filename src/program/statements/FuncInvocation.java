package program.statements;

import program.AbstractASTNode;
import program.expression.Expression;
import program.expression.Variable;

import java.util.ArrayList;
import java.util.List;

public class FuncInvocation extends AbstractASTNode implements Statement, Expression {

    private Variable var;
    private List<Expression> params;

    public FuncInvocation(int line, int column, Variable var, List<Expression> params) {
        super(line, column);
        this.var = var;
        this.params = new ArrayList<Expression>(params);
    }

    public List<Expression> getParams() {
        return params;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(String.format("WhileStatement[variable=%s, params=[", var.toString()));
        for (Expression e : params) {
            res.append(String.format("\n%s", e.toString()));
        }
        return res.append("]]").toString();
    }
}
