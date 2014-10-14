package com.jasper.testThread.proAndCus;


/**
 * 顾客和消费者问题，共享同一个资源而引起资源错误的情况
 * @author Jasper
 */
public class QuestionOfProducerAndCustomer {
	public static void main(String []args) {
		Info info = new Info();
		Prodecer prodecer = new Prodecer(info);
		Customer customer = new Customer(info);
		new Thread(customer).start();
		new Thread(prodecer).start();
	}

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
				info.setName("xixi_10");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				info.setAge(10);
				flag = false;
			} else {
				info.setName("hehe_20");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				info.setAge(20);
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
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("name->" + info.getName() + "  age->" + info.getAge());
		}
	}
}








