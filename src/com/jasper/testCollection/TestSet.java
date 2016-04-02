package com.jasper.testCollection;

import java.util.HashSet;
import java.util.Set;

public class TestSet {
	public static void main(String []args) {
//		HashSet<String> set = new HashSet<String>();
//		set.add("aaa");
//		set.add("bb");
//		set.add("aaa");
//		System.out.println("set->" + set);
//		String a = "aaa";
//		set.add(a);
//		System.out.println("set->" + set);
//		String bString = "bb";
//		System.out.println(set.contains(bString));
//		TreeSet<String> aa = new TreeSet<String>();
		m1();
	}
	
	public static void m() {
		Set<User> users = new HashSet<User>();
		User user1 = new User();
		user1.setId(1);
		user1.setName("1");
		users.add(user1);
		User user2 = new User();
		user2.setId(1);
		user2.setName("2");
		users.add(user2);
//		users.add(user1);
//		User user3 = new User();
//		user3.setId(3);
//		user3.setName("3");
//		users.remove(user3);
		for(User user : users) {
			System.out.println(user.getId() + " " + user.getName());
		}
	}
	
	public static void m1() {
		Set<String> set = new HashSet<>();
		long curTime = System.currentTimeMillis();
		for (int i=0; i<1000 * 10000; i++) {
			set.add(Integer.toString(i));
		}
		System.out.println(System.currentTimeMillis() - curTime);
		
		curTime = System.currentTimeMillis();
		for (String str : set) {
			dosomething(str);
		}
		System.out.println(System.currentTimeMillis() - curTime);
	}
	
	public static void dosomething(String str) {
		
	}
	
}
