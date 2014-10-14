package com.jasper.testThread;

public class MultiThreadWaitAndNotify implements Runnable {

	private String name;
	private Object prev;
	private Object self;

	private MultiThreadWaitAndNotify(String name, Object prev, Object self) {
		this.name = name;
		this.prev = prev;
		this.self = self;
	}

	@Override
	public void run() {
		int count = 10;
		while (count > 0) {
			synchronized (prev) {
				synchronized (self) {
					System.out.print(name);
					// if(name.equals("C")) System.out.println();
					count--;
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					self.notify();
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					prev.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		MultiThreadWaitAndNotify pa = new MultiThreadWaitAndNotify("A", c, a);
		MultiThreadWaitAndNotify pb = new MultiThreadWaitAndNotify("B", a, b);
		MultiThreadWaitAndNotify pc = new MultiThreadWaitAndNotify("C", b, c);

		try {
			new Thread(pa).start();
			Thread.sleep(10);
			new Thread(pb).start();
			Thread.sleep(10);
			new Thread(pc).start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}