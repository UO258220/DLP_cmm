package ast.types;

import semantic.Visitor;

public class VoidType extends AbstractType {

    private static final int VOID_BYTES = 0;

    public VoidType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "VoidType";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public int numberOfBytes() {
        return VOID_BYTES;
    }
}
