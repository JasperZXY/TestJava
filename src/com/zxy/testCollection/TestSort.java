package com.zxy.testCollection;

import java.text.Collator;
import java.util.*;

public class TestSort {
	
	public static void main(String[] args) {
		List<Item> list = new ArrayList<Item>();
		list.add(new Item(2));
		list.add(new Item(4));
		list.add(new Item(3));
		list.add(new Item(1));
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		System.out.println(new Item(2).compareTo(new Item(1)) > 0);

		// 中文排序
		List<String> chineseNames = new ArrayList<>(Arrays.asList("张三", "李四", "王五", "赵六"));
		System.out.println(chineseNames);
		Collections.shuffle(chineseNames);
		System.out.println(chineseNames);
		Collections.sort(chineseNames, Collator.getInstance(java.util.Locale.CHINA));
		System.out.println(chineseNames);
	}
	
	public static class Item implements Comparable<Item> {
		int value;
		
		public Item(int value) {
			this.value = value;
		}
		
		@Override
		public int compareTo(Item o) {
			return this.value - o.value;
		}

		@Override
		public String toString() {
			return "Item [value=" + value + "]";
		}
	}

}
