package com.jasper.testThread;


/**
 * 一个简单的实现Runnable接口的用来实现多线程
 * @author Jasper
 */
public class SimpleRunnable implements Runnable {
	private String name;
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(this.getName() + " " + i);
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public SimpleRunnable(String name) {
		this.name = name;
	}
	
	public static void main(String []args) {
		SimpleRunnable s1 = new SimpleRunnable("A");
		SimpleRunnable s2 = new SimpleRunnable("B");
		new Thread(s1).start();    //记得这里要new一个Thread出来，再传入一个Runnable实现的对象
		new Thread(s2).start();		
	}

}
