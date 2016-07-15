package com.jasper.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String args[]) throws Exception {
        Class<AAA> c = AAA.class;
        //返回所有的方法
        Method[] ms = c.getDeclaredMethods();
        AAA a = c.newInstance();
        for (Method method : ms) {
            //这里遍历一下 可有可以无 实验而已
            System.out.println(method);
        }
//        Method m = c.getDeclaredMethod("setTmp", int.class, String.class);
//        m.setAccessible(true);//因为写成private 所以这里必须设置
//        m.invoke(a, 5, "你好");

        System.out.println("xxxxx");
        for (Field field : c.getFields()) {
            System.out.println("field:" + field.getName());
        }
        System.out.println("xxxxx");
        for (Field field : c.getDeclaredFields()) {
            System.out.println("field:" + field.getName());
        }
        System.out.println("xxxxx");
        Field field = c.getDeclaredField("tmp");
        field.setAccessible(true);
        field.set(a, "xxxxx");
        System.out.println(a.getTmp());

    }

    public static class AAA {
        private String tmp;
        public int x;

        public void setTmp(String tmp) {
            System.out.println("1111111111111111111111");
            this.tmp = tmp;
        }

        private void setTmp(int i, String s) {
            System.out.println("222222222222222222222");
            System.out.println(i + "," + s);
            tmp = i + "," + s;
        }

        public String getTmp() {
            return tmp;
        }

    }
}

