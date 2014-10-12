package com.jasper.testArray;

import java.util.Arrays;

public class ArrayCopy {
	public static void main(String[] args) {
		int []a = {1, 2, 3};
		m(a);
		int []b = a.clone();
		m(b);
		int []c = Arrays.copyOf(a, 7);
		m(c);
	}
	
	public static void m(int []a) {
		for(int i=0;i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

}
