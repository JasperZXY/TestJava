package com.zxy.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class TestMethod {

    public static void main(String[] args) throws Exception {
        List<String> obj = new ArrayList<>();
        Class clazz = obj.getClass();

        /*
        子类实例 instanceof 父类类型
        父类.class.isAssignableFrom(子类.class)
         */
        System.out.println(obj instanceof Collection);                  // true
        System.out.println(Collection.class.isAssignableFrom(clazz));   // true
        System.out.println(clazz.isAssignableFrom(Collection.class));   // false

        System.out.println("===================");

        System.out.println(getField("a").getName());        // a
        System.out.println(getField("a").getType());        // int
        System.out.println(getField("a").getType());        // int
        System.out.println(getField("b").getType());        // class java.lang.Integer
        System.out.println(getField("c").getType());        // class java.lang.String
        System.out.println(getField("d").getGenericType()); // java.util.List<java.lang.String>
        System.out.println(((ParameterizedType)(getField("d").getGenericType())).getActualTypeArguments()[0]);  // class java.lang.String
        System.out.println(getField("e").getType());        // class com.zxy.reflect.TestMethod$MyObject

    }

    private static Field getField(String fieldName) {
        for (Field field : MyObject.class.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }
        return null;
    }

    private static class MyObject {
        int a;
        Integer b;
        String c;
        List<String> d;
        MyObject e;
    }

}
