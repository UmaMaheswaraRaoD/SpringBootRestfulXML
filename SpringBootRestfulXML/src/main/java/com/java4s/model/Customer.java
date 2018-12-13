package com.java4s.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Customer")
public class Customer {
	 int custNo;
	 String name;
	 String country;
	public int getCustNo() {
		return custNo;
	}

	public void setCustNo(int custNo) {
		this.custNo = custNo;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
