package com.jasper.JDK8;

/**
 * Java 8允许我们给接口添加一个非抽象的方法实现，只需要使用 default关键字即可，这个特征又叫做扩展方法
 * @author Jasper
 *
 */
public class NewInterface {
	public static void main(String[] args) {

		Formula formula = new Formula() {
			@Override
			public double calculate(int a) {
				return sqrt(a * 100);
			}
		};

		System.out.println(formula.calculate(100));
		System.out.println(formula.calculate(16));

	}

}

interface Formula {
	double calculate(int a);

	default double sqrt(int a) {
		return Math.sqrt(a);
	}
}
