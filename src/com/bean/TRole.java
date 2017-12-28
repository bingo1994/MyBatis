package com.bean;

import java.util.List;

public class TRole {
private int rid;
private String rname;
private String rdesp;
private List<UserTest> users;
public int getRid() {
	return rid;
}
public void setRid(int rid) {
	this.rid = rid;
}
public String getRname() {
	return rname;
}
public void setRname(String rname) {
	this.rname = rname;
}
public String getRdesp() {
	return rdesp;
}
public void setRdesp(String rdesp) {
	this.rdesp = rdesp;
}
public List<UserTest> getUsers() {
	return users;
}
public void setUsers(List<UserTest> users) {
	this.users = users;
}
}
