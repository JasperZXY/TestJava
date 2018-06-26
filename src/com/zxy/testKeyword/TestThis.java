package com.zxy.testKeyword;

/**
 * 从运行的结果来看，虽然B继承了A，但在调用m() 方法时，是B去调用的，所以this指代的是B这个实例化对象
 * @author Jasper
 */
public class TestThis {
	public static void main(String[] args) {
		new B().m();
	}
}

class A {
	public void m() {
		System.out.println(this);
	}
}

class B extends A {
	
}
