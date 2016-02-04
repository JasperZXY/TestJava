package com.jasper.mine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		System.out.println("Hello Word");
		List<Integer> list1 = null;
		List<Integer> list2 = null;
		
		list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 6));
		list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		
		List<Integer> list3 = new ArrayList<>(list1);
		list3.removeAll(list2);
		System.out.println(list3);
		
		System.out.println("=======");
		
		System.out.println(String.format("%.3f", Math.PI));
	}
	
}