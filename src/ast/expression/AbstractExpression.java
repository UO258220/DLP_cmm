package ast.expression;

import ast.AbstractASTNode;
import ast.types.Type;
import semantic.Visitor;

public abstract class AbstractExpression extends AbstractASTNode implements Expression {

    private boolean lValue;
    private Type type;

    public AbstractExpression(int line, int column) {
        super(line, column);
    }

    public boolean getLvalue() {
        return lValue;
    }

    public void setLvalue(boolean lValue) {
        this.lValue = lValue;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
