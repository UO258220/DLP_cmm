package parser;

import ast.types.ArrayType;
import ast.types.Type;

public class ParserHelper {

    /**
     * Factory of ArrayTypes employing recursion to "fix" the ordering of sizes
     * @param size Size to be placed in the most internal ArrayType
     * @param type Inner Type of the outer ArrayType (ALREADY ORDERED)
     * @return The provided type, containing an ArrayType of the provided size on its deepest layer
     */
    public static ArrayType createArrayType(int size, Type type) {
        if (type instanceof ArrayType) {
            ArrayType aType = (ArrayType) type;
            return new ArrayType(aType.getLine(), aType.getColumn(), aType.getSize(),
                    createArrayType(size, aType.getInnerType()));
        }
        return new ArrayType(type.getLine(), type.getColumn(), size, type);
    }

}
