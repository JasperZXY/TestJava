package com.jasper.testCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
