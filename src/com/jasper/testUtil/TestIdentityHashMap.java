package com.jasper.testUtil;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class TestIdentityHashMap {
	public static void main(String[] args) {
		Integer i1 = new Integer(1);
		Integer i2 = new Integer(1);
		System.out.println(i1 == i2);
		
		IdentityHashMap<Integer, Object> identityHashMap = new IdentityHashMap<Integer, Object>();
		identityHashMap.put(i1, null);
		identityHashMap.put(i2, null);  //添加数据比较相等用的是==
		System.out.println(identityHashMap);
		
		HashMap<Integer, Object> hashMap = new HashMap<Integer, Object>();
		hashMap.put(i1, null);
		hashMap.put(i2, null);  //添加数据比较相等用的是equals方法
		System.out.println(hashMap);
	}

}
