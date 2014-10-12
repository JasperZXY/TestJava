package com.jasper.innerClass.anon;

/**
 * 匿名内部类
 * @author Jasper
 */
public class Outer {
	public void start(Task task) {
		System.out.println("申请资源");
		task.run();
		System.out.println("释放资源");
	}
	public static void main(String[] args) {
		new Outer().start(new Task() {
			@Override
			public void run() {
				System.out.println("干自己的事");
			}
		});
	}
}
interface Task {
	public void run();
}
