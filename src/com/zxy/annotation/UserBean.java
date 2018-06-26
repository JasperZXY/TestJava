package com.zxy.annotation;

/**
 * 用户实体bean
 * @author Jasper
 *
 */
@Table(name="user")
public class UserBean {
	@Column(name="uid")
	int id;
	
	@Column(name="user_name", type="varchar(30)")
	String name;
	
	@Column
	String address;
	
}
