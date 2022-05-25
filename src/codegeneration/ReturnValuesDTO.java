package codegeneration;

public class ReturnValuesDTO {

    public int returnBytes;
    public int localsBytes;
    public int paramsBytes;

    public ReturnValuesDTO(int returnBytes, int localsBytes, int paramsBytes) {
        this.returnBytes = returnBytes;
        this.localsBytes = localsBytes;
        this.paramsBytes = paramsBytes;
    }
}
