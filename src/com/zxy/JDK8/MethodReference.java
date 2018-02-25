package com.zxy.JDK8;

/**
 * <strong>方法与构造函数引用</strong><br/>
 * Java 8 允许你使用 :: 关键字来传递方法或者构造函数引用
 * 
 * @author Jasper
 *
 */
public class MethodReference {

	public static void main(String[] args) {
		//引用一个静态方法
		Converter<String, Integer> converter = Integer::valueOf;
		Integer converted = converter.convert("123");
		System.out.println(converted);   // 123
		
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("Peter", "Parker");
		System.out.println(person);
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
	
	interface PersonFactory<P extends Person> {
	    P create(String firstName, String lastName);
	}

}

