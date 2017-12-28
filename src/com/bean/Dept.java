package com.bean;

import java.util.List;

public class Dept {
private int did;
private String deptname;
private String deptdesp;
private  List<Employee>employee;
public int getDid() {
	return did;
}
public void setDid(int did) {
	this.did = did;
}
public String getDeptname() {
	return deptname;
}
public void setDeptname(String deptname) {
	this.deptname = deptname;
}
public String getDeptdesp() {
	return deptdesp;
}
public void setDeptdesp(String deptdesp) {
	this.deptdesp = deptdesp;
}
public List<Employee> getEmployee() {
	return employee;
}
public void setEmployee(List<Employee> employee) {
	this.employee = employee;
}
}
