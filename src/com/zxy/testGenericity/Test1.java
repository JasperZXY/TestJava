package com.zxy.testGenericity;

import java.util.List;

public class Test1 {
	public static void main(String[] args) {
//		List<String>[] lists = (List<String>[]) new Object[2]; //这样会抛异常
		List<String>[] lists = new List[2];
		System.out.println(lists);
	}
}
