package com.jasper.testUtil1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.sun.tools.apt.resources.apt;
import com.sun.tools.javac.resources.legacy;

public class TestList {
	public static void main(String []args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("1");
		System.out.println(list.size());
		/*ArrayList<String> list = new ArrayList<String>();
		list.add("aa");
		System.out.println(list);
		String a = "aa";
//		list.add(a);
//		System.out.println(list);
		System.out.println(list.contains(a));
		System.out.println(list.contains("aa"));*/
//		List<String> list = null;
//		m(list);
//		System.out.println(list);
//		List<String> list = new ArrayList<String>();
//		list.add(0, "111");
//		System.out.println(list.size());
//		list.add(3, "333");
//		System.out.println(list.size());
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(i + "->" + list.get(i));
//		}
		
		/*Set<User> list = new HashSet<User>();
		User user1 = new User();
		user1.setId(1);
		user1.setName("11");
		list.add(user1);
		User user2 = new User();
		user2.setId(1);
		user2.setName("22");
		list.add(user2);
		User user3 = new User();
		user3.setId(2);
		user3.setName("22");
		list.add(user3);
		User user4 = new User();
		user4.setId(1);
		user4.setName("22");
		list.remove(user4);
		for(User user : list) {
			System.out.println(user.getId() + " " + user.getName());
		}*/
//		m(null);
//		m2();
		//1794515827
		User user1 = new User();
		user1.setId(0);
		user1.setName("1");
		user1.hashCode();
		User user2 = new User();
		user2.setId(0);
		user2.setName("1");
		user2.hashCode();
	}
	
	public static void m(List<String> list) {
		list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		Collections.reverse(list);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static void m2(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
//		Object[] integers = (Object[]) list.toArray();
		Integer[] integers = new Integer[0];
		System.out.println(integers.length);
		System.out.println(list.size());
		integers = list.toArray(integers);
		System.out.println(integers.length);
		for(int i=0; i<integers.length; i++) {
			System.out.println(integers[i]);
		}
		LinkedList<Integer> aIntegers= new LinkedList<Integer>();
//		aIntegers.poll();
		aIntegers.remove();
	}
}
