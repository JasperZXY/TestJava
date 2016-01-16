package com.jasper.JDK8;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Utils {
	public static void main(String[] args) {
		/*
		 * Predicate 接口只有一个参数，返回boolean类型。
		 * 该接口包含多种默认方法来将Predicate组合成其他复杂的逻辑（比如：与，或，非）
		 */
		Predicate<String> predicate = (s) -> s.length() > 0;

		System.out.println(predicate.test("foo"));           // true
		System.out.println(predicate.negate().test("foo"));  // false

		Predicate<Boolean> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;

		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();

		System.out.println(isNotEmpty.test("abc"));

		/**
		 * Function 接口有一个参数并且返回一个结果，
		 * 并附带了一些可以和其他函数组合的默认方法（compose, andThen）：
		 */
		Function<String, Integer> toInteger = Integer::valueOf;
		Function<String, String> backToString = toInteger.andThen(String::valueOf);

		System.out.println(backToString.apply("123"));     // "123"
		
		/**
		 * Supplier 接口返回一个任意范型的值，和Function接口不同的是该接口没有任何参数
		 */
		Supplier<Person> personSupplier = Person::new;
		System.out.println(personSupplier.get());
		
		/**
		 * Consumer 接口表示执行在单个参数上的操作。
		 */
		Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
		greeter.accept(new Person("Luke", "Skywalker"));

		/**
		 * Comparator 接口
		 */
		System.out.println("Comparator 接口");
		Comparator<Integer> comparator = (p1, p2) -> p1.compareTo(p2);

		Integer i1 = 10;
		Integer i2 = 15;
		
		System.out.println(comparator.compare(i1, i2));   // <0
		System.out.println(comparator.reversed().compare(i1, i2));  // >0


	}
	
	static class Person {
	    String firstName;
	    String lastName;
	    Person() {}
	    Person(String firstName, String lastName) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	    }
		@Override
		public String toString() {
			return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
		}
	}

}
