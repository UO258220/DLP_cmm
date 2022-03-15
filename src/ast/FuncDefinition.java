package ast;

import ast.statements.Statement;
import ast.types.Type;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FuncDefinition extends AbstractASTNode implements Definition {

    private String name;
    private Type type;
    private List<Statement> statements;

    public FuncDefinition(int line, int column, String name, Type type, List<Statement> statements) {
        super(line, column);
        this.name = name;
        this.type = type;
        this.statements = new ArrayList<Statement>(statements);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Type getType() {
        return type;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(String.format("FuncDefinition[name=%s, type=%s, body=[", name, type.toString()));
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
