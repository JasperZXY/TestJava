package com.zxy.testThread.singleton;

public class SingletonTest3 {
    private static class SingletonHolder {
        private static final SingletonTest3 INSTANCE = new SingletonTest3();
    }

    private SingletonTest3() {
    }

    public static final SingletonTest3 getInstance() {
        return SingletonHolder.INSTANCE;
    }


    public static void main(String[] args) {
        System.out.println(SingletonTest3.getInstance());
    }
}