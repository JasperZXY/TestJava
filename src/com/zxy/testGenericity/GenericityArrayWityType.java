package com.zxy.testGenericity;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GenericityArrayWityType<T> {
	private T[] t;
	public GenericityArrayWityType(Class<T> type, int size) {
		t = (T[]) Array.newInstance(type, size);
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
		GenericityArrayWityType<String> test = new GenericityArrayWityType<String>(String.class, 3);
		test.put(0, "00");
		System.out.println(test.get(0));
		String[] strings = test.toArray();  //现在就可以这里了
		System.out.println(Arrays.asList(strings));
	}

}
