package com.zxy.testArray;

import java.util.Arrays;
import java.util.Comparator;

public class TestArray {
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 0};
		Integer[] b = {1, 2, 3};
		Arrays.sort(a);
		System.out.println(Arrays.asList(a));
//		System.out.println(b[3]);   //抛异常java.lang.ArrayIndexOutOfBoundsException
		
		int[][] arr = new int[3][];
		for(int i=0; i<arr.length; i++) {
			arr[i] = new int[i*2+1];
		}
		
		m(b);
		
		User user1 = new User(2, "Ken");
		User user2 = new User(1, "Jack");
		User[] users = {user1, user2};
		System.out.println(Arrays.asList(users));
//		Arrays.sort(users);
		Arrays.sort(users, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				return o1.getId() - o2.getId();
			}
		});
		System.out.println(Arrays.asList(users));
		System.out.println(add(1, 3, 5));
		
		int[]c = Arrays.copyOf(a, a.length);
		int [] d = new int[a.length];
		System.arraycopy(a, 0, d, 0, a.length);
		System.out.println(Arrays.asList(c));
		System.out.println(Arrays.asList(d));
		System.out.println(Arrays.copyOf(users, 2));
	}
	
	public static <T>void m(T ...a) {
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static int add(int ...a) {
		int sum = 0;
		for(int i=0; i<a.length; i++) {
			sum += a[i];
		}
		return sum;
	}

}
