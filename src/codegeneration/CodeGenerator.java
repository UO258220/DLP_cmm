package codegeneration;

import ast.VarDefinition;
import ast.types.CharType;
import ast.types.DoubleType;
import ast.types.Type;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class CodeGenerator {

    private PrintWriter out;
    private PrintStream err;
    private int labelIndex;

    public CodeGenerator(String inputFilename, String outputFilename) {
        try {
            this.out = new PrintWriter(outputFilename);
            this.err = System.err;
        }
        catch (FileNotFoundException e) {
            err.println(String.format("--- FILE %s NOT FOUND ---", inputFilename));
        }
        this.labelIndex = 0;
        this.out.println(String.format("\n#source \"%s\"\n", inputFilename));
        this.out.flush();
    }

    void genCode(String code) {
        this.out.println(code);
        this.out.flush();
    }

    public String nextLabel() {
        return "label" + labelIndex++;
    }

    public void line(int line) {
        genCode(String.format("\n#line\t%d", line));
    }

    public void comment(String text) {
        genCode(String.format("\t' * %s", text));
    }

    public void mainInvocation() {
        genCode("\n' Invocation to the main function\ncall main\nhalt\n");
    }

    public void label(String name) {
        genCode(String.format("\n %s:", name));
    }

    public void enter(int bytes) {
        genCode(String.format("\tenter\t%s", bytes));
    }

    public void ret(int typeBytes, int localsBytes, int paramsBytes) {
        genCode(String.format("\tret\t%d, %d, %d", typeBytes, localsBytes, paramsBytes));
    }

    public void commentVariable(VarDefinition varDefinition) {
        comment(String.format("%s %s (offset %d)", varDefinition.getType().toString(),
                varDefinition.getName(), varDefinition.getOffset()));
    }

    public void arithmetic(String operator, char suffix) {
        switch(operator) {
            case "+":
                add(suffix);
                break;
            case "-":
                sub(suffix);
                break;
            case "*":
                mul(suffix);
                break;
            case "/":
                div(suffix);
                break;
        }
    }

    public void comparison(String operator, char suffix) {

        switch(operator) {
            case ">":
                gt(suffix);
                break;
            case "<":
                lt(suffix);
                break;
            case ">=":
                ge(suffix);
                break;
            case "<=":
                le(suffix);
                break;
            case "==":
                eq(suffix);
                break;
            case "!=":
                ne(suffix);
                break;
        }
    }

    public void logical(String operator) {
        switch(operator) {
            case "&&":
                and();
                break;
            case "||":
                or();
                break;
        }
    }

    public void in(char suffix) {
        genCode(String.format("\tin%c", suffix));
    }

    public void out(char suffix) {
        genCode(String.format("\tout%c", suffix));
    }

    public void store(char suffix) {
        genCode(String.format("\tstore%c", suffix));
    }

    public void load(char suffix) {
        genCode(String.format("\tload%c", suffix));
    }

    public void pushi(int value) {
        genCode(String.format("\tpushi\t%d", value));
    }

    public void pushb(int value) {
        genCode(String.format("\tpushb\t%d", value));
    }

    public void pushf(double value) {
        genCode("\tpushf\t" + value);
    }

    public void pusha(int offset) {
        genCode(String.format("\tpusha\t%d", offset));
    }

    public void pushBP() {
        genCode("\tpush\tbp");
    }

    public void add(char suffix) {
        genCode(String.format("\tadd%c", suffix));
    }

    public void sub(char suffix) {
        genCode(String.format("\tsub%c", suffix));
    }

    public void mul(char suffix) {
        genCode(String.format("\tmul%c", suffix));
    }

    public void div(char suffix) {
        genCode(String.format("\tdiv%c", suffix));
    }

    public void module(char suffix) {
        genCode(String.format("\tmod%c", suffix));
    }

    public void gt(char suffix) {
        genCode(String.format("\tgt%c", suffix));
    }

    public void lt(char suffix) {
        genCode(String.format("\tlt%c", suffix));
    }

    public void ge(char suffix) {
        genCode(String.format("\tge%c", suffix));
    }

    public void le(char suffix) {
        genCode(String.format("\tle%c", suffix));
    }

    public void eq(char suffix) {
        genCode(String.format("\teq%c", suffix));
    }

    public void ne(char suffix) {
        genCode(String.format("\tne%c", suffix));
    }

    public void and() {
        genCode("\tand");
    }

    public void or() {
        genCode("\tor");
    }

    public void not() {
        genCode("\tnot");
    }

    public void b2i() {
        genCode("\tb2i");
    }

    public void i2f() {
        genCode("\ti2f");
    }

    public void f2i() {
        genCode("\tf2i");
    }

    public void i2b() {
        genCode("\ti2b");
    }

    public void jmp(String label) {
        genCode(String.format("\tjmp\t%s", label));
    }

    public void jz(String label) {
        genCode(String.format("\tjz\t%s", label));
    }
}
