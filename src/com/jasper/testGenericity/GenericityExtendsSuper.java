package com.jasper.testGenericity;

import java.util.ArrayList;
import java.util.List;

import com.jasper.testGenericity.domain.Apple;
import com.jasper.testGenericity.domain.Fruit;
import com.jasper.testGenericity.domain.RedApple;

public class GenericityExtendsSuper {
	public static void main(String[] args) {
		List<Apple> apples = new ArrayList<Apple>();
		apples.add(new Apple());
		apples.add(new RedApple());
		List<? extends Fruit> fruits = apples;
		System.out.println(fruits);
		System.out.println(fruits.get(0));

		List<? super RedApple> redApples = apples;
		System.out.println(redApples);
		
		List<Apple> apples2 = new ArrayList<Apple>();
		writeTo(apples2);
		System.out.println(apples2);
	}
	
	public static void writeTo(List<? super Apple> apples) {
		apples.add(new Apple());
		apples.add(new RedApple());
//		apples.add(new Fruit());
	}
	
}
