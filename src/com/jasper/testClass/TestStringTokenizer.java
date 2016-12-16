package com.jasper.testClass;

import java.util.StringTokenizer;

public class TestStringTokenizer {
    public static void main(String[] args) {
        String str = "123,456;789";
        String delimiters = ",;";

        StringTokenizer st = new StringTokenizer(str, delimiters);
        while (st.hasMoreElements()) {
            System.out.println(st.nextElement());
        }
    }
}
