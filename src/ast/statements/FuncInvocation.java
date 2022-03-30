package ast.statements;

import ast.AbstractASTNode;
import ast.expression.AbstractExpression;
import ast.expression.Expression;
import ast.expression.Variable;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FuncInvocation extends AbstractExpression implements Statement, Expression {

    private Variable var;
    private List<Expression> params;

    public FuncInvocation(int line, int column, Variable var, List<Expression> params) {
        super(line, column);
        this.var = var;
        this.params = new ArrayList<Expression>(params);
    }

    public Variable getVariable() {
        return var;
    }

    public List<Expression> getParams() {
        return params;
    }

    @Override
    public String toString() {
        return "FuncInvocation";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
