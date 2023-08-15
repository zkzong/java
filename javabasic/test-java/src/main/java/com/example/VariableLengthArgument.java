package com.example;

public class VariableLengthArgument {

    public static void main(String[] args) {
        printVariable("a", "b", "c");
    }

    public static void printVariable(String... args) {
        String[] var1 = args;
        int var2 = args.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            String s = var1[var3];
            System.out.println(s);
        }

    }

}
