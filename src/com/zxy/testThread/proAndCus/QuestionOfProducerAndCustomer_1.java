package com.zxy.testThread.proAndCus;


/**
 * 顾客和消费者问题，共享同一个资源而引起资源错误的情况
 * 相对之前的那个文件只是把生产者和消费者里面的两个方法给提取了出来而已
 * 从运行结果可以看出，结果是错误的
 * @author Jasper
 */
public class QuestionOfProducerAndCustomer_1 {
	public static void main(String []args) {
		QuestionOfProducerAndCustomer_1 qopac = new QuestionOfProducerAndCustomer_1();
		Info info = qopac.new Info();
		Prodecer prodecer = qopac.new Prodecer(info);
		Customer customer = qopac.new Customer(info);
		new Thread(customer).start();
		new Thread(prodecer).start();
	}
	
	/**
	 * 资源信息
	 * @author Jasper
	 */
	class Info {
		private String name;
		private int age;
		
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
		
		public void set(String name, int age) {
			this.name = name;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.age = age;
		}
		
		public void get() {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this);
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
			for(int i=0; i<25; i++) {
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
			for(int i=0; i<25; i++) {
				info.get();
			}
		}
	}

}










