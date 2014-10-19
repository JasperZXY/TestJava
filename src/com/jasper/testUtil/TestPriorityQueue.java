package com.jasper.testUtil;

import java.util.PriorityQueue;

public class TestPriorityQueue {
	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for(int i=0; i<10; i++) {
			int a = (int) (Math.random() * 100);
			System.out.print(a + ",");
			queue.add(a);
		}
		System.out.println();
		System.out.println(queue);
		Integer a = null;
		while((a = queue.poll()) != null) {
			System.out.print(a + ",");
		}
		
	}

}
