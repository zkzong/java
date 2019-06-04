package com.zkzong.test;

public class TryCatch {

    public static void main(String[] args) {
        String s = new TryCatch().s();
        System.out.println(s);
    }

    private String s() {
        try {
            throw new Exception();
        } catch(Exception e) {

        }
        return "a";
    }
}
