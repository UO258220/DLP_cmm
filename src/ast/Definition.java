package ast;

import ast.types.Type;

public interface Definition {
    String getName();
    Type getType();
}
