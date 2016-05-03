package com.jasper.JDK8;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Function<T, R> -T作为输入，返回的R作为输出<br/>
 * Predicate<T> -T作为输入，返回的boolean值作为输出<br/>
 * Consumer<T> - T作为输入，执行某种动作但没有返回值<br/>
 * Supplier<T> - 没有任何输入，返回T<br/>
 * BinaryOperator<T> -两个T作为输入，返回一个T作为输出，对于“reduce”操作很有用
 * @author Jasper
 *
 */
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

		/**
		 * Optional 不是函数是接口，这是个用来防止NullPointerException异常的辅助类型，
		 * 这是下一届中将要用到的重要概念，现在先简单的看看这个接口能干什么：
		 * Optional 被定义为一个简单的容器，其值可能是null或者不是null。
		 * 在Java 8之前一般某个函数应该返回非空对象但是偶尔却可能返回了null，
		 * 而在Java 8中，不推荐你返回null而是返回Optional。
		 */
		System.out.println("Optional 接口");
		Optional<String> optional = Optional.of("bam");
		System.out.println(optional.isPresent());;           // true
		System.out.println(optional.get());;                 // "bam"
		System.out.println(optional.orElse("fallback"));;    // "bam"
		optional.ifPresent((s) -> System.out.println(s.charAt(0)));    // "b"
		
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
