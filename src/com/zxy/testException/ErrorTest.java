package com.zxy.testException;

public class ErrorTest {

    public void m() {
        throw new Error("哈哈哈");
    }

    public static void main(String[] args) {
        try {
            new ErrorTest().m();
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }

        new ErrorTest().m();
        System.out.println("main end");
    }
}
