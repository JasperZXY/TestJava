package com.zxy.testClass;

public class TestEnum {
	public static void main(String[] args) {
		Gender.Female.say();
		Gender2.Female.say();
		Gender.valueOf("").say();
	}

}
