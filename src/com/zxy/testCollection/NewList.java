package com.zxy.testCollection;

import java.util.Arrays;

public class NewList<T> {
	private Object [] arr = null;
	private int cursor = 0;
	private int length = 2;
	
	public NewList() {
		arr = new Object[length];
	}
	
	public void add(T t) {
		if(cursor >= length) {
			length = length * 2 + 1;
			arr = Arrays.copyOf(arr, length);
		}
		arr[cursor ++] = t;
	}
	
	public int size() {
		return cursor;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int index) {
		return (T) arr[index];
	}
	
	public void remove(int index) {
		if(index < 0) {
			throw new IndexOutOfBoundsException("�±겻��С��0");
		}
		if(index > cursor) {
			throw new IndexOutOfBoundsException("�±�̫��");
		}
	}
	
	public static void main(String[] args) {
		NewList<String> list = new NewList<String>();
		list.add("111");
		list.add("22");
		list.add("3333");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
}
