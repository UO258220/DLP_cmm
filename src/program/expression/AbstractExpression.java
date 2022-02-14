package program.expression;

import program.AbstractASTNode;

public abstract class AbstractExpression extends AbstractASTNode implements Expression {
    public AbstractExpression(int line, int column) {
        super(line, column);
    }
}
