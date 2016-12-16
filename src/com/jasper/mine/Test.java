package com.jasper.mine;

import java.util.LinkedList;
import java.util.List;

public class Test {
	public static void main(String[] args) throws Exception {
		List<Object> list = new LinkedList<>();
		for (int i=0; i<1000000; i++) {
			Object object = new Object[1024];
			list.add(object);
			Thread.sleep(100);
		}
		System.gc();
	}

}

