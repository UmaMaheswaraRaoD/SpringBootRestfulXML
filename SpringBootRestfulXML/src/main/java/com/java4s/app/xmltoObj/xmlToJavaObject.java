package com.java4s.app.xmltoObj;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

import com.java4s.model.Customer;

@Component
public class xmlToJavaObject {
	
	public Customer xmlToObject(String customerXml) throws JAXBException
	{

		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    Customer Customer = (Customer) jaxbUnmarshaller.unmarshal(new StringReader(customerXml));
	    System.out.println("cutstomer NO"+Customer.getCustNo());
		return Customer;
}
}
