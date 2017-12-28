package com.bean;

import java.util.List;

public class UserTest {
private int id;
private String uname;
private String uaddress;
private List<TRole> roles;
public List<TRole> getRoles() {
	return roles;
}
public void setRoles(List<TRole> roles) {
	this.roles = roles;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getUaddress() {
	return uaddress;
}
public void setUaddress(String uaddress) {
	this.uaddress = uaddress;
}

}
