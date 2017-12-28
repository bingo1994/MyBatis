package com.bean;

public class PhoneNumber {
private String countryCode;
private String stateCode;
private String number;

public PhoneNumber(){
	
}


public PhoneNumber(String string){
	if(string!=null){
		String[] parts=string.split("-");
		if(parts.length>0){
			this.countryCode=parts[0];
		}
		if(parts.length>1){
			this.stateCode=parts[1];
		}
		if(parts.length>2){
			this.number=parts[2];
		}
	}
}

public String getAsString(){
	return (this.countryCode+"-"+this.stateCode+"-"+this.number);
}








public String getCountryCode() {
	return countryCode;
}
public void setCountryCode(String countryCode) {
	this.countryCode = countryCode;
}
public String getStateCode() {
	return stateCode;
}
public void setStateCode(String stateCode) {
	this.stateCode = stateCode;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
}
