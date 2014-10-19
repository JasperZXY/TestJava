package com.jasper.testUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestMathSet {
	public static void main(String[] args) {
//		Set<Integer> a = new HashSet<Integer>(Arrays.asList(1, 2));
//		Set<Integer> b = new HashSet<Integer>(Arrays.asList(2, 3, 4));
//		System.out.println(a);
//		a.retainAll(b);
//		System.out.println(a);
		
//		Set<Integer> a = new HashSet<Integer>(Arrays.asList(1, 2));
//		Set<Integer> b = new HashSet<Integer>(Arrays.asList(2, 3, 4));
//		System.out.println(a);
//		a.addAll(b);
//		System.out.println(a);
		
		Set<Integer> a = new HashSet<Integer>(Arrays.asList(1, 2));
		Set<Integer> b = new HashSet<Integer>(Arrays.asList(2, 3, 4));
		System.out.println(a);
		a.removeAll(b);
		System.out.println(a);
		
	}

}
