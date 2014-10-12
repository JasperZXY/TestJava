package com.jasper.mine;

public class JavaParam {
	public static void main(String[] args) {
		JavaParam test = new JavaParam();
		int a = 5;
		test.change(a);
		System.out.println("after change:a=" + a);
		User user1 = new User("user1");
		test.change(user1);
		System.out.println("after change:user.name=" + user1.getName());
		User user2 = new User("user2");
		test.changeReference(user2);
		System.out.println("after changeReference:user.name=" + user2.getName());
	}
	
	public void change(int a) {
		a ++;
		System.out.println("change:a=" + a);
	}
	
	public void change(User user) {
		user.setName("Jasper");
		System.out.println("change:user.name=" + user.getName());
	}
	
	public void changeReference(User user) {
		User tmpUser = new User("tmp");
		user = tmpUser;
		System.out.println("changeReference:user.name=" + user.getName());
	}
}

class User {
	private String name;
	
	public User(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
