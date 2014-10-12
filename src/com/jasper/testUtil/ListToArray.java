package com.jasper.testUtil;

import java.util.List;
import java.util.ArrayList;

public class ListToArray {
	public static void main(String[] args) {
//		List<String> list = Arrays.asList("1", "2");
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		System.out.println(list);
		//下面这样写会抛 java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
//		String[] strings = (String[]) list.toArray();
//		System.out.println(strings[0] + " " + strings[1]);
		Object[] objects = list.toArray();
		System.out.println((String)objects[0] + " " + (String)objects[1]);
		String[] strings = new String[list.size()];
		list.toArray(strings);
		System.out.println(strings[0] + " " + strings[1]);
	}

}
