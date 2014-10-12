package com.jasper.testClass;

public class TestMethod {
	public static void main(String[] args) {
		Person person = new Person();
		person.setName("123");
		m(person);
		System.out.println(person.getName());
		int[] a= new int[1];
		a[0] = 12;
		m2(a);
		System.out.println(a[0]);
	}
	
	public static void m(Person p) {
		Person person = new Person();
		person.setName("2");
		p = person;
	}
	
	public static void m2(int []a) {
		int[] b= new int[1];
		b[0] = 1;
		a = b;
	}
	
	

}

class Person implements Comparable<Person> {
	@Override
	public boolean equals(Object obj) {
		Person p = (Person)obj;
		return this.name.equals(p.name) && this.age==p.age;
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	private String name;
	private int age;
	public Person() {
	}
	public Person(String name, int age) {
		this.setName(name);
		this.setAge(age);
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	@Override
	public int compareTo(Person arg0) {
		if(this.age > arg0.age) {
			return 1;
		}
		return 0;
	}

}

