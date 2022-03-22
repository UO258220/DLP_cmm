package ast;

import ast.statements.Statement;
import ast.types.Type;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FuncDefinition extends AbstractDefinition {

    private List<Statement> statements;

    public FuncDefinition(int line, int column, String name, Type type, List<Statement> statements) {
        super(line, column, name, type);
        this.statements = new ArrayList<Statement>(statements);
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(String.format("FuncDefinition[name=%s, type=%s, body=[", getName(), getType().toString()));
        for (Statement s : statements) {
            res.append(String.format("\n%s", s.toString()));
        }
        return res.append("]]").toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
