package ast;

import ast.statements.Statement;
import ast.types.Type;

public class VarDefinition extends AbstractASTNode implements Definition, Statement {

    private String name;
    private Type type;

    public VarDefinition(int line, int column, String name, Type type) {
        super(line, column);
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("VarDefinition[name=%s, type=%s]", name, type.toString());
    }
}