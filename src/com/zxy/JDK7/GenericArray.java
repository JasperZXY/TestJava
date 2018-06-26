package com.zxy.JDK7;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GenericArray {
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		System.out.println(doSomething(a, b));
		
		Map<String, Integer> map1 = new HashMap<>();
		map1.put("1", 111);
		map1.put("2", 22);
		
		Map<String, Integer> map2 = new HashMap<>();
		map2.put("3", 3);
		map2.put("4", 4444);
		
		//泛型内部实现是一个数组，所以两个map对象传进去是警告的，要在doSomething方法上加注解@SafeVarargs
		System.out.println(doSomething(map1, map2));
		
//		Map<String, Integer>[] maps = new HashMap<>[2];  //语法有误
//		Map<String, Integer>[] maps = new HashMap[2];    //这样定义才对
	}
	
	@SafeVarargs
	static <T> Collection<T> doSomething(T... ts) {
		Set<T> set = new HashSet<>();
		for (T t : ts) {
			set.add(t);
		}
		return set;
	}

}
