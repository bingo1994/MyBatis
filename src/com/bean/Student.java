package com.bean;

import java.util.Date;

public class Student {
private int id;
private String name;
private String email;
private Date birth;
private PhoneNumber phone;
private Address address;
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public Student(){
	
}
//通过id来构造
public Student(Integer id){
	this.id = id;
}
//与映射器中的类型要一样-->javaType="Integer"
public Student(Integer id, String name, String email, Date birth, PhoneNumber phone) {
	//super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.birth = birth;
	this.phone = phone;
}

public PhoneNumber getPhone() {
	return phone;
}
public void setPhone(PhoneNumber phone) {
	this.phone = phone;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getBirth() {
	return birth;
}
public void setBirth(Date birth) {
	this.birth = birth;
}
}
