package com.zxy.other;

public class test {

    private String baseName = "base";


    public test() {
        callName();
    }


    public void callName() {
        System.out.println("test=" + baseName);
    }


    static class Sub extends test {

        private String baseName = "sub";


        public void callName() {
            System.out.println("sub=" + baseName);
        }
    }


    public static void main(String[] args) {
        System.out.println(Long.parseLong("55D2C83", 16));
    }
}