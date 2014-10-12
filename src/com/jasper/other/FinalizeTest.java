package com.jasper.other;

public class FinalizeTest {

	public static void main(String[] args) throws InterruptedException {
		Session session = new Session();

		Object[] arr1 = new Object[5];
		Object[] arr2 = new Object[10];

		System.out.println(session.hashCode());
		arr1[3] = session;
		System.out.println(arr1[3].hashCode());
		arr2[7] = session;
		System.out.println(arr2[7].hashCode());

		System.out.println("--------------");

		session = null;
		System.out.println(arr1[3].hashCode());
		System.out.println(arr2[7].hashCode());
		System.gc();
		System.out.println("第一次销毁session");

		System.out.println("--------------");
		arr1[3] = null;
		System.gc();
		System.out.println("第二次销毁session");
		System.out.println(arr2[7].hashCode());
		System.out.println("--------------");
		arr2[7] = null;
		System.gc();
		System.out.println("第三次销毁session.可见,当内存中的对象在Java程序没有任何一个指向的时候,"
				+ "通过垃圾回收机制才能正在销毁对象.请注意,该条打印语句虽然执行顺序在System.gc()之后"
				+ "被执行的,但在打印\"销毁对象\"之前已经被打印出来,表示System.gc()是异步的."
				+ "它的执行不并影响主程序的执行,它将交与JVM虚拟机执行!");
		Thread.sleep(30000);
		System.out.println("总结:Java无法像C或C++那样通过free() delete 销毁对象,但Java可以通过"
				+ "取消对\"对象\"的所有引用并且调用System.gc()的方式来进行销毁.");
		System.out.println("Test Over");
	}
}

class Session {
	int id;
	String name;

	@Override
	protected void finalize() throws Throwable {
		System.out.println("销毁对象");
		super.finalize();
	}
}