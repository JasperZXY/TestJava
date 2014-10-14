package com.jasper.testThread.proAndCus;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 顾客和消费者问题，共享同一个资源而引起资源错误的情况
 * 所以在这个类中加入了对资源的同步，用lock代替synchronized关键字
 * 从结果输出来看，有一些数据是重复了的
 * @author Jasper
 */
public class QuestionOfProducerAndCustomer_2_lock {
	public static void main(String []args) throws InterruptedException {
		QuestionOfProducerAndCustomer_2_lock qopac = new QuestionOfProducerAndCustomer_2_lock();
		Info info = qopac.new Info();
		Prodecer prodecer = qopac.new Prodecer(info);
		Customer customer = qopac.new Customer(info);
		new Thread(prodecer).start();
		new Thread(customer).start();
	}
	
	/**
	 * 资源信息
	 * @author Jasper
	 */
	class Info {
		private String name;
		private int age;
		private Lock lock = new ReentrantLock();
		
		public void setName(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public int getAge() {
			return age;
		}
		
		public void set(String name, int age) {   //这个方法加了synchronized关键字
			lock.lock();
			this.name = name;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				this.age = age;
				lock.unlock();
			}
		}
		
		public void get() {  //这个方法加了synchronized关键字
			lock.lock();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				System.out.println(this);
				lock.unlock();
			}
		}
		
		@Override
		public String toString() {
			return "name->" + this.getName() + "  age->" + this.getAge();
		}
		
	}

	/**
	 * 生产者
	 * @author Jasper
	 */
	class Prodecer implements Runnable {
		private Info info;
		
		public Prodecer(Info info) {
			this.setInfo(info);
		}

		public void setInfo(Info info) {
			this.info = info;
		}

		public Info getInfo() {
			return info;
		}

		@Override
		public void run() {
			boolean flag = false;
			for(int i=0; i<10; i++) {
				if(flag) {
					info.set("xixi_10", 10);
					flag = false;
				} else {
					info.set("hehe_20", 20);
					flag = true;
				}
			}
		}
	}

	/**
	 * 消费者
	 * @author Jasper
	 */
	class Customer implements Runnable {
		private Info info = null;
		public Customer(Info info) {
			this.info = info;
		}
		public void setInfo(Info info) {
			this.info = info;
		}
		public Info getInfo() {
			return info;
		}
		@Override
		public void run() {
			for(int i=0; i<10; i++) {
				info.get();
			}
		}
	}

}










