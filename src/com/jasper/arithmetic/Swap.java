package com.jasper.arithmetic;

/**
 * @author Jasper (zhongxianyao)
 */
public class Swap {
    public static void main(String[] args) {
        swap1();
        swap2();
        swap3();
    }

    private static void swap1() {
        int x = 1;
        int y = 2;
        int temp = x;
        x = y;
        y = temp;
        System.out.println("x=" + x + " y=" + y);
    }

    private static void swap2() {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE - 1;
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("x=" + x + " y=" + y);
    }

    private static void swap3() {
        int x = 1;
        int y = 2;
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("x=" + x + " y=" + y);
    }
}
