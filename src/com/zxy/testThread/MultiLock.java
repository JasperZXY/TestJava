package com.zxy.testThread;

public class MultiLock {
	public void f1(int count) {
		if(count-- > 0) {
			System.out.println("calling f2() with count->" + count);
			f2(count);
		}
	}
	
	public void f2(int count) {
		if(count-- > 0) {
			System.out.println("calling f1() with count->" + count);
			f1(count);
		}
	}
	
	public static void main(String []args) {
		final MultiLock multiLock = new MultiLock();
		new Thread() {
			@Override
			public void run() {
				multiLock.f1(10);
			}
		}.start();
	}

}
