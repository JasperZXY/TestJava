package com.zxy.testThread.singleton;

/**
 * Created by zhongxianyao. Time 2019/4/22 8:30 PM Desc 文件描述
 *
 * https://stackoverflow.com/questions/70689/what-is-an-efficient-way-to-implement-a-singleton-pattern-in-java
 */
public class SingletonTest0 {
    private static volatile SingletonTest0 singleton = new SingletonTest0();


    private SingletonTest0() {}

    public static final SingletonTest0 getInstance() {
        return singleton;
    }


    public static void main(String[] args) {
        System.out.println(SingletonTest0.getInstance());
    }

}
