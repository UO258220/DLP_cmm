package ast;

import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Program extends AbstractASTNode {

    private List<Definition> defs;

    public Program(int line, int column, List<Definition> defs) {
        super(line, column);
        this.defs = new ArrayList<Definition>(defs);
    }

    public List<Definition> getDefs() {
        return defs;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Program[definitions=[");
        for (Definition d : defs) {
            res.append(String.format("\n%s", d.toString()));
        }
        return res.append("]]").toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
