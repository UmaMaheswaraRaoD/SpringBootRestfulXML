package com.java4s.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
	 @XmlElement(name="Cust-no")
	 int custNo;
	 @XmlElement(name="name1")
	 String name;
	 @XmlElement(name="country1")
	 String country;
	
	public Customer() {
		
	}
	
	public Customer(int custNumber, String name, String country) {
		this.custNo = custNumber;
		this.name = name;
		this.country = country;
	}

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
