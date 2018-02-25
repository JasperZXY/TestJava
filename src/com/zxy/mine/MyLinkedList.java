package com.zxy.mine;

import java.util.Iterator;

/**
 * 自己实现一个链表，下面我实现了Iterable接口，只是为了让其可以进行foreach循环
 * @author Jasper
 * @param <T>
 */
public class MyLinkedList<T> implements Iterable<T> {
	public static void main(String[] args) {
		MyLinkedList<String> list = new MyLinkedList<String>();
		list.add("1");
		list.add("5");
		list.add("7");
		list.delete("123");
		list.print();
		System.out.println("======================");
		for(String string : list) {
			System.out.println(string);
		}
	}
	
	private ListNode<T> head;
	private ListNode<T> tail;
	private ListNode<T> lastReturnedNode;
	
	public MyLinkedList() {
		head = new ListNode<T>();
		tail = head;
	}
	
	public void add(T t) {
		ListNode<T> node = new ListNode<T>(t);
		tail.next = node;
		tail = node;
	}
	
	public void delete(T t) {
		for(ListNode<T> node=head; node!=null&&node.next!=null; node=node.next) {
			ListNode<T> nextNode = node.next;
			if(nextNode.value.equals(t)) {
				if(nextNode == tail) {
					tail = node;
					tail.next = null;
				} else {
					node.next = node.next.next;
				}
			}
		}
	}
	
//	public T next() {
//		if(lastReturnedNode == null) {
//			lastReturnedNode = head.next;
//		} else {
//			lastReturnedNode = lastReturnedNode.next;
//		}
//		if(lastReturnedNode != null) {
//			return lastReturnedNode.value;
//		}
//		return null;
//	}
//	
//	public boolean hasNext() {
//		if(lastReturnedNode == null) {
//			return head.next != null;
//		}
//		return lastReturnedNode.next != null;
//	}
	
	public void print() {
		for(ListNode<T> node=head.next; node!=null; node=node.next) {
			System.out.println(node.value);
		}
	}
	
	private static class ListNode<T> {
		T value;
		ListNode<T> next;
		
		public ListNode() {}
		public ListNode(T t) {
			this.value = t;
		}
		
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			@Override
			public boolean hasNext() {
				if(lastReturnedNode == null) {
					return head.next != null;
				}
				return lastReturnedNode.next != null;
			}

			@Override
			public T next() {
				if(lastReturnedNode == null) {
					lastReturnedNode = head.next;
				} else {
					lastReturnedNode = lastReturnedNode.next;
				}
				if(lastReturnedNode != null) {
					return lastReturnedNode.value;
				}
				return null;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}
		};
	}

}
