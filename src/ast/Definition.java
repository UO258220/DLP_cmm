package ast;

import ast.types.Type;
import semantic.AbstractVisitor;

public interface Definition extends ASTNode {
    String getName();
    Type getType();
    int getScope();
    void setScope(int scope);
}
