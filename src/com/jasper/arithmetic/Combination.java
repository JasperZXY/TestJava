package com.jasper.arithmetic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Combination {
	public static void main(String[] args) {
		String []array = {"1", "2", "3", "4"};
		listAll(Arrays.asList(array), "");
	}
	public static void listAll(List list, String prefix) {
		System.out.println(prefix);
		for(int i=0; i<list.size(); i++) {
			List tmp = new LinkedList(list);
			listAll(tmp, prefix + tmp.remove(i));
		}
	}
}
