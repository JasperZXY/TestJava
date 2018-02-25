package com.zxy.testCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 测试结果
 * 针对for(int i=0; i<list.size(); i++)跟foreach进行说明，
 * ArrayList跟Collections.unmodifiableList的结果是一致的，
 * 当list在for循环的过程中，另一个线程对list进行修改后，list会发生改变，等同于与输出的list信息错乱，
 * 但对于foreach不会，完整输出了修改的前的数据。
 */
public class UnmodifiableCollection {
    private static List<Integer> list;
    private static List<Integer> list2;

    public static void main(String[] args) {
        list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        list2 = Collections.unmodifiableList(list);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<list.size(); i++) {
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(" 1 print:" + list.get(i));
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int a : list) {
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("  2 print:" + a);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<list2.size(); i++) {
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("   3 print:" + list.get(i));
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int a : list2) {
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("    4 print:" + a);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                list = new ArrayList<>(Arrays.asList(7, 8, 9, 10));
                list2 = new ArrayList<>(list);
                System.out.println(list);
                System.out.println(list2);
            }
        }).start();
    }
}
