package com.jasper.testException;

/**
 * 测试在抛出异常后返回数据
 */
public class ExceptionReturnData {
    public static void main(String[] args) {
        System.out.println(test(10));
        System.out.println(test(-2));
        System.out.println(test(0));
    }

    public static Boolean test(int a) {
        try {
            int ret = 10 / a;
            return ret > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
