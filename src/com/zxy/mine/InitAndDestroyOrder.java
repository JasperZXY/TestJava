package com.zxy.mine;

/**
 * 类初始化顺序及破坏顺序
 * @author Jasper
 */
public class InitAndDestroyOrder {
	public static void main(String[] args) {
		new C(3);
		System.out.println("bye!");
		System.runFinalizersOnExit(true);
	}

}
class A {
	public A() {
		System.out.println("MyBean");
		m();
	}
	public void m() {
		System.out.println("m in MyBean");
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("MyBean finalize");
		super.finalize();
	}
}
class B {
	public B() {
		System.out.println("B");
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("B finalize");
		super.finalize();
	}
}
class C extends A {
	int c = 1;
	B b = new B();
	public C(int c) {
		System.out.println("C");
		this.c = c;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("C finalize");
		super.finalize();
	}
	@Override
	public void m() {
		System.out.println("m in C:" + c);
	}
}
