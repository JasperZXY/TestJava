package com.jasper.testThread.threadVolatile;

public class TestVolatile {
	public static void main(String[] args) {
		int value = 1000;
		int loops = 0;
		ThreadGroup tGroup = Thread.currentThread().getThreadGroup();
		while(loops++ < value) {
			UnsafeThread unsafeThread = new UnsafeThread();
			for(int i=0; i<value; i++) {
				new Thread(unsafeThread).start();
			}
			do {
				try {
					Thread.sleep(15);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} while(tGroup.activeCount() != 1);
			if(unsafeThread.getCount() != value) {
				System.out.println("循环到第" + loops + "次出错了,此时，count=" + unsafeThread.getCount());
				System.exit(0);
			} else {
				System.out.println(loops + " " + unsafeThread.getCount());
			}
		}
	}
}

class UnsafeThread implements Runnable {
	private volatile int count = 0;

	@Override
	public void run() {
//		for(int i=0; i<1000; i++) {
//			Math.hypot(Math.pow(13123, i), Math.cos(i));
//		}
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count ++;
	}
	
	public int getCount() {
		return count;
	}
}
