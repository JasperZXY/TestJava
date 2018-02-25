package com.zxy.testArray;

import java.util.Arrays;
import java.util.List;

public class List2Array {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2);
		System.out.println(list);
		
		Integer[] array = new Integer[list.size()];
		Integer[] array2 = list.toArray(array);
		System.out.println(Arrays.asList(array));
		System.out.println(Arrays.asList(array2));
	}

}
