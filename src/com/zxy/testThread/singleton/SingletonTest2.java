package com.zxy.testThread.singleton;

public enum SingletonTest2 {
    INSTANCE;


    public static void main(String[] args) {
        System.out.println(SingletonTest2.INSTANCE);
    }
}