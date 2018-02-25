package com.zxy.testClass;

import java.util.StringTokenizer;

public class TestStringTokenizer {
    public static void main(String[] args) {
        String str = "123,456;78        9； abc";
        String delimiters = ",; ；";

        StringTokenizer st = new StringTokenizer(str, delimiters);
        while (st.hasMoreElements()) {
            System.out.println(st.nextElement());
        }
    }
}
