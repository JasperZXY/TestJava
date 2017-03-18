package com.jasper.mine;


public class Test {
    public static void main(String[] args) {
//        System.out.println(test());
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    public static String test() {
        try {
            System.out.println("try block");
            return test1();
        } finally {
            System.out.println("finally block");
        }
    }

    public static String test1() {
        System.out.println("return statement");
        return "after return";
    }
}


