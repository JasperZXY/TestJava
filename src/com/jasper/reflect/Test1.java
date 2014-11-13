package com.jasper.reflect;

import java.lang.reflect.Type;

import com.jasper.reflect.domain.Bird;

public class Test1 extends Bird {
	
	public static void main(String[] args) {
		Bird bird = new Bird();
		Type superType = bird.getClass().getGenericSuperclass();
		System.out.println(superType);
	}
	

}
