package com.bean;

import java.util.Date;

public class Course {
private int cid;
private String cname;
private String desp;
private Date start_date;
private Date end_date;
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}

public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getDesp() {
	return desp;
}
public void setDesp(String desp) {
	this.desp = desp;
}
public Date getStart_date() {
	return start_date;
}
public void setStart_date(Date start_date) {
	this.start_date = start_date;
}
public Date getEnd_date() {
	return end_date;
}
public void setEnd_date(Date end_date) {
	this.end_date = end_date;
}
}
