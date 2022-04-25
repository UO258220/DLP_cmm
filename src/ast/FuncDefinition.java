package ast;

import ast.statements.Statement;
import ast.types.Type;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FuncDefinition extends AbstractDefinition {

    private int localsBytesSum;

    private List<Statement> statements;

    public FuncDefinition(int line, int column, String name, Type type, List<Statement> statements) {
        super(line, column, name, type);
        this.statements = new ArrayList<Statement>(statements);
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setLocalsBytesSum(int localsBytesSum) {
        this.localsBytesSum = localsBytesSum;
    }

    public int getLocalsBytesSum() {
        return localsBytesSum;
    }

    @Override
    public String toString() {
        return String.format("FuncDefinition[name=%s]", getName());
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
