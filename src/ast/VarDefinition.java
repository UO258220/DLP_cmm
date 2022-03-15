package ast;

import ast.statements.Statement;
import ast.types.Type;
import semantic.Visitor;

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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}