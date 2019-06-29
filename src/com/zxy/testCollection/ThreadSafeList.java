package com.zxy.testCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 多次运行，CopyOnWriteArrayList不会报错。
 * Vector跟Collections.synchronizedList会报错
 * java.util.ConcurrentModificationException
 */
public class ThreadSafeList extends  Thread {

    //static List<String> list = new Vector<>();
    //static List<String> list = Collections.synchronizedList(new ArrayList<>());
    static List<String> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {

        ThreadSafeList thread = new ThreadSafeList();
        thread.start();
        for (int i = 0 ; i < 1000 ;i++){
            list.add(i + " ");
        }
        for (String data: list){
            System.out.print(data);
        }

    }

    @Override
    public void run() {
        super.run();
        System.out.println("执行线程.......");

        for (int i = 0 ; i < 100 ;i++){
            list.add("a");
        }

    }
}