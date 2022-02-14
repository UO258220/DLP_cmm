package program;

import program.statements.Statement;
import program.types.Type;

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
}
