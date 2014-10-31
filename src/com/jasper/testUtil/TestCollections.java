package com.jasper.testUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCollections {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3);
		list.set(1, 11);
		List<Integer> list2 = Collections.checkedList(list, Integer.class);
		list2.set(0, 10);
		System.out.println(list);
		System.out.println(list2);
	}

}
