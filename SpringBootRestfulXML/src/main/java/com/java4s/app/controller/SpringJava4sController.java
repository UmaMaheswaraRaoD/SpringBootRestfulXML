

package com.java4s.app.controller;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.java4s.model.Customer;

@RestController
public class SpringJava4sController {
	JAXBContext jaxbContext;

	@GetMapping(path="/get-cust-info")
	public Customer customerInformation() 
	{
		Customer cust = new Customer();
		
		cust.setCustNo(100);
		cust.setName("Bank of America");
		cust.setCountry("United States");
		
		return cust;
	}
	
	@GetMapping(path="/callService")
	public  void getCustomers() throws JAXBException
	{
	    final String uri = "http://localhost:8080/springbootrestxml/get-cust-info.xml";

	    RestTemplate restTemplate = new RestTemplate();
	    String customerXml = restTemplate.getForObject(uri, String.class);

	    System.out.println(customerXml);
	    //reading xml data
	    jaxbContext = JAXBContext.newInstance(Customer.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    Customer Customer = (Customer) jaxbUnmarshaller.unmarshal(new StringReader(customerXml));
	    System.out.println("cutstomer NO"+Customer.getCustNo());
	  //  return customerXml;
	    
	}
	// to read xmlString data
	
}

// URL: http://localhost:8080/springbootrestxml/get-cust-info
// URL: http://localhost:8080/springbootrestxml/get-cust-info.json
//URL: http://localhost:8080/springbootrestxml/callService