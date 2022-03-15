package ast.expression;

import ast.AbstractASTNode;
import semantic.Visitor;

public abstract class AbstractExpression extends AbstractASTNode implements Expression {

    private boolean lValue;

    public AbstractExpression(int line, int column) {
        super(line, column);
    }

    public boolean getLvalue() {
        return lValue;
    }

    public void setLvalue(boolean lValue) {
        this.lValue = lValue;
    }
}
