package com.zxy.testGenericity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericityTest {
	public static void main(String[] args) {
		Object object = "abc";
		String string= convert(object);
		System.out.println(string);
		List<String> list = list();
		list.add("1");
		System.out.println(list);
		System.out.println(Arrays.asList(list.getClass().getTypeParameters()));
	}
	
	public static<T> T convert(Object o) {
		return (T)o;
	}
	public static <T> List list() {
		return new ArrayList<T>();
	}

}
