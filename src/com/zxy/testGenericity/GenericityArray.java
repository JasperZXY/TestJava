package com.zxy.testGenericity;

import java.util.Arrays;

public class GenericityArray<T> {
	private T[] t;
	public GenericityArray(int size) {
		t = (T[]) new Object[size];
	}
	public void put(int index, T itme) {
		t[index] = itme;
	}
	public T get(int index) {
		return t[index];
	}
	public T[] toArray() {
		return t;
	}
	public static void main(String[] args) {
		GenericityArray<String> test = new GenericityArray<String>(3);
		test.put(0, "00");
		System.out.println(test.get(0));
//		String[] strings = test.toArray();  //这样会抛错误
		Object[] strings = test.toArray();
		System.out.println(Arrays.asList(strings));
	}

}
