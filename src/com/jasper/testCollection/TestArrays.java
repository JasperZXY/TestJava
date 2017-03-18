package com.jasper.testCollection;

import java.util.Arrays;
import java.util.List;

public class TestArrays {
    public static void main(String[] args) {
        //int[]不能通过Arrays.asList()转List，只能用Integer[]
//        int[] a = {1, 2, 3, 4};
        Integer[] a = {1, 2, 3, 4};
        List<Integer> list = Arrays.asList(a);
        System.out.println(list);

        // List<Integer>只能通过toArray()转成Integer[]，不能转成int[]
//        int[] as = list.toArray(new int[list.size()]);
        Integer[] as = list.toArray(new Integer[list.size()]);
        System.out.println(as[0]);
    }
}
