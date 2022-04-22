package codegeneration;

import ast.FuncDefinition;
import ast.VarDefinition;
import ast.statements.Statement;
import ast.types.FunctionType;
import ast.types.RecordField;
import ast.types.RecordType;
import semantic.AbstractVisitor;

public class OffsetVisitor extends AbstractVisitor<Boolean, Void> {

    /**
     * Rules for offset computation
     *
     *
     * Global variables
     * P:   varDefinition -> type variable
     * R:   // globalsBytesSum
     *      varDefinition.offset = globalsBytesSum;
     *      globalsBytesSum += type.numberOfBytes;
     *
     *
     * Local variables
     * P:   funcDefinition -> type varDefinition*
     * R:   int localsBytesSum = 0;
     *      for (VarDefinition vd : varDefinition*) {
     *          localBytesSum += vd.type.numberOfBytes();
     *          vd.offset = -localsBytesSum;
     *      }
     *
     * Parameters
     * P:   funcType -> type varDefinition*
     * R:   int paramsBytesSum = 4;
     *      for (int i = varDefinition*.size() -1 ; i >= 0, i--) {
     *          varDefinition vd = varDefinition*.get(i);
     *          vd.offset = paramsBytesSum;
     *          paramsBytesSum += vd.type.numberOfBytes();
     *      }
     *
     * Record fields
     * P:   recordType -> recordField*
     * R:   int fieldsBytesSum = 0;
     *      for (RecordField rf : recordField*) {
     *          rf.offset = fieldsBytesSum;
     *          fieldsBytesSum += rf.type.numberOfBytes();
     *      }
     */

    private int globalBytesSum = 0;
    private int localsBytesSum = 0;
    private int paramsBytesSum = 0;

    @Override
    public Void visit(VarDefinition varDefinition, Boolean isParam) {
        varDefinition.getType().accept(this, isParam);

        // GLOBAL VARIABLE
        if (varDefinition.getScope() == 0) {
            varDefinition.setOffset(globalBytesSum);
            globalBytesSum += varDefinition.getType().numberOfBytes();
        }
        // LOCAL VARIABLE
        else if (isParam == null || !isParam) {
            localsBytesSum += varDefinition.getType().numberOfBytes();
            varDefinition.setOffset(-localsBytesSum);
        }
        // PARAMETER
        else {
            varDefinition.setOffset(4 + paramsBytesSum);
            paramsBytesSum += varDefinition.getType().numberOfBytes();
        }
        return null;
    }

    @Override
    public Void visit(FuncDefinition funcDefinition, Boolean isParam) {
        localsBytesSum = 0;
        funcDefinition.getType().accept(this, isParam);
        funcDefinition.getStatements().forEach(st -> st.accept(this, isParam));
        return null;
    }

    @Override
    public Void visit(FunctionType functionType, Boolean isParam) {
        paramsBytesSum = 0;
        for (int i = functionType.getParams().size() - 1 ; i >= 0 ; i--) {
            functionType.getParams().get(i).accept(this, true);
        }
        return null;
    }

    @Override
    public Void visit(RecordType recordType, Boolean isParam) {
        int fieldsBytesSum = 0;
        for (RecordField rf : recordType.getFields()) {
            rf.accept(this, isParam);
            rf.setOffset(fieldsBytesSum);
            fieldsBytesSum += rf.getType().numberOfBytes();
        }
        return null;
    }

}
