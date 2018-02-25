package com.zxy.testCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collection中的一些泛型。
 * 通配符的一些总结：producer-extends，consumer-super。我的总结：read-extends，write-super。
 */
public class GenericCollection {
    public static void main(String[] args) {
        System.out.println(Collections.<String>emptyList());   // 这里可以指定List存放的元素为String

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        readList(integerList);
        System.out.println("=========");

        List<? super Number> numberList = writeList();
        System.out.println(numberList);
        System.out.println("=========");
    }

    private static void readList(List<? extends Number> list) {
        for (Number number : list) {
            System.out.println(number);
        }
    }

    private static List<? super Number> writeList() {
        List<? super Number> list = new ArrayList<>();
        for (int i=0; i<3; i++) {
            list.add(i);
        }
        return list;
    }

}
