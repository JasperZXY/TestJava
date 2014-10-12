package com.jasper.testKeyword;

/**
 * final 修饰符对方法和域而言，意味着某些完全不同的事情。
 * 对于方法，final 意味着该方法不能被覆写（对实例方法而言）或者隐藏（对静态方法而言）。
 * 对于域，final 意味着该域不能被赋值超过一次
 * @author Jasper
 */
public class TestFinal {
	public static void main(String[] args) {
		B b = new B();
		b.say();
		System.out.println(b.STRING);
	}

	static class A {
		final String STRING = "A";
		public final void say() {
			System.out.println("a");
		}
	}

	static class B extends A {
		//虽然这里是final修饰的，但还是可以和父类有相同的变量名，但不能有相同的方法
		final String STRING = "B";
//		public final void say() {
//		}
	}
}
