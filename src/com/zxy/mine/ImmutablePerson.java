package com.zxy.mine;

import java.util.Date;

/**
 * 不可变类
 * @author Jasper
 */
public class ImmutablePerson {
	private String name;
	private Date birthday;
	
	public ImmutablePerson(String name, Date birthday) {
		this.name = name;
		this.birthday = new Date(birthday.getTime());
//		this.birthday = birthday;    //error
	}
	
	public String getName() {
		return name;
	}
	public Date getBirthday() {
//		return birthday;    //error
		return new Date(birthday.getTime());
	}
}
