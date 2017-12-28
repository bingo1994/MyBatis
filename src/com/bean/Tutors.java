package com.bean;

import java.util.List;

public class Tutors {
private int tid;
private String name;
private String email;
private String address;

private List<Course> course;//外键的体现  一对多

public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public List<Course> getCourse() {
	return course;
}
public void setCourse(List<Course> course) {
	this.course = course;
}
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
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
}
