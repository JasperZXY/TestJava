package com.zxy.testClass;

import java.util.Arrays;
import java.util.List;

public class TestArray {
	public static void main(String[] args) {
		define();
		Integer[] a = new Integer[2];
		m(a);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		List<Integer> list = Arrays.asList(a);
		System.out.println(list);
		list.toArray(a);
		System.out.println(list.toArray()[0]);
		System.out.println(a[0]);
		
		m2(new String[]{"1", "22"});
		m2((Object)new String[]{"1", "22"});
	}
	
	/**
	 * 定义
	 */
	public static void define() {
		int[] a = {};
		int []b = {};
		int[] c = null;
		int[] d = {1, 2};
		System.out.println(" " + a + b + c + d);
		System.out.println(Arrays.toString(a) + Arrays.toString(b) + Arrays.toString(c) + Arrays.toString(d));
	}
	
	public static void m(Integer[] a) {
		Integer[] b = new Integer[]{1, 2};
		System.arraycopy(b, 0, a, 0, b.length);
	}
	
	public static void m2(Object ...as) {
		System.out.println("===========m2==============");
		for(Object a : as) {
			System.out.println(a);
		}
		System.out.println("===========m2==============");
	}

}
