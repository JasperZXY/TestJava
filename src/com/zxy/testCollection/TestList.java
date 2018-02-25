package com.zxy.testCollection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Test;

public class TestList {
	public static void main(String []args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("1");
		System.out.println(list.size());
		List<String> list2 = (List<String>) list.clone();
		System.out.println(list);
		System.out.println(list2);
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
		
		addNull();
	}
	
	public static void addNull() {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add(null);
		list.add(null);
		list.add("2");
		System.out.println(list.size());
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
	
	@Test
	public void testRemove() {
		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		List<String> list2 = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5"));
		for (int i=0; i<list1.size(); i++) {
			System.out.println("size:" + list1.size() + " " + i + "->" + list1.get(i));
			if (list1.get(i) == 2 || list1.get(i) == 5) {
				list1.remove(i);
				list2.remove(i);
			}
		}
		System.out.println(list1);
		System.out.println(list2);
		
		list2 = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5"));
		list2 = new CopyOnWriteArrayList<>(list2);
		for (String string : list2) {
			if ("2".equals(string)) {
				list2.remove(string);
			}
		}
		System.out.println(list2);
	}

	// 删除用用迭代器或者index从后往前遍历
	@Test
	public void testRemove2() {
		List<Integer> list;

		list = new ArrayList<>();
		System.out.println("start");
		for (int i=0; i<list.size(); i++) {
			System.out.println("x:" + i);
		}
		System.out.println("end");

		// 测试，不能满足需求，理论[2]，结果[2, 4]
		list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println("start " + list);
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
			if (!list.get(i).equals(Integer.valueOf(2))) {
				list.remove(i);
			}
		}
		System.out.println("end  " + list);

		// 测试，满足需求
		list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println("start " + list);
		for (int i=list.size() - 1; i>=0; i--) {
			System.out.println(list.get(i));
			if (!list.get(i).equals(2)) {
				list.remove(i);
			}
		}
		System.out.println("end  " + list);

		list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println("start " + list);
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			Integer a = iterator.next();
			System.out.println(a);
			if (!a.equals(2)) {
				iterator.remove();
			}
		}
		System.out.println("end  " + list);
	}

	@Test
	public void testSet() {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println(list);
		for (int i=0; i<list.size(); i++) {
			if (list.get(i) == 3) {
				list.set(i, 111);
			}
		}
		System.out.println(list);
	}
	
	@Test
	public void testFind() {
		List<Integer> list = new ArrayList<>();
		Random random = new Random();
		for (int i=0; i<1000_000; i++) {
			list.add(random.nextInt(10_000));
		}
		
		long curTime = 0;
		curTime = System.currentTimeMillis();
		int max1 = Integer.MIN_VALUE;
		for (int i=0; i<100_000; i++) {
			int cur = list.get(i);
			if (cur > max1) {
				max1 = cur;
			}
		}
		System.out.println("max:" + max1 + " time:" + (System.currentTimeMillis() - curTime));
		
		curTime = System.currentTimeMillis();
		int max2 = Integer.MIN_VALUE;
		for (int cur : list) {
			if (cur > max2) {
				max2 = cur;
			}
		}
		System.out.println("max:" + max2 + " time:" + (System.currentTimeMillis() - curTime));
	}
}
