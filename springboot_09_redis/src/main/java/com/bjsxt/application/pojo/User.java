package com.bjsxt.application.pojo;

import java.io.Serializable;

public class User implements Serializable{

	private Integer id;
	private String uname;
	private String address;
	private Integer age;
	
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUname() {
		System.out.println("===============getUname");
		return uname;
	}
	public void setUname(String uname) {
		System.out.println("===============setUname");
		this.uname = uname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
