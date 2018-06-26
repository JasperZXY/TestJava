package com.zxy.testThread;

/**
 * 线程同步
 * @author Jasper
 */
public class ThreadSynchronized implements Runnable {
	private int count = 5;

	public void setCount(int count) {
		this.count = count;
	}
	public int getCount() {
		return count;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			sale();
//			synchronized (this) {
//				if(count > 0) {
//					try {
//						Thread.sleep(500);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					System.out.println(count --);
//				}
//			}
		}
	}
	
	/**
	 * 这一段代码是从上面注释的代码那里抽取出来的
	 */
	private synchronized void sale() {
		if(count > 0) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(count --);
		}
	}
	
	public static void main(String []args) {
		ThreadSynchronized ts = new ThreadSynchronized();
		new Thread(ts).start();
		new Thread(ts).start();
		new Thread(ts).start();
	}
	

}
