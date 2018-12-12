
package com.java4s.app.controller;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.java4s.app.xmltoObj.xmlToJavaObject;
import com.java4s.model.Customer;

@RestController
public class SpringJava4sController {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	xmlToJavaObject obj;

	@Value("${restURI}")
	private String uri;

	@GetMapping(path = "/get-cust-info")
	public Customer customerInformation() {
		Customer cust = new Customer();
		cust.setCustNo(100);
		cust.setName("Bank of America");
		cust.setCountry("United States");

		return cust;
	}

	@GetMapping(path = "/callService")
	public void getCustomers() throws JAXBException {
		//final String uri = "http://localhost:8080/springbootrestxml/get-cust-info.xml";
		System.out.println(uri);
		String customerXml = restTemplate.getForObject(uri, String.class);
		System.out.println(customerXml);
		// Customer cust=obj.xmlToObject(customerXml);

	}
	// to read xmlString data

}

// URL: http://localhost:8080/springbootrestxml/get-cust-info
// URL: http://localhost:8080/springbootrestxml/get-cust-info.json
// URL: http://localhost:8080/springbootrestxml/callService