package program.statements;

import program.AbstractASTNode;

public abstract class AbstractStatement extends AbstractASTNode implements Statement {

    public AbstractStatement(int line, int column) {
        super(line, column);
    }
}
