
package com.java4s.app.controller;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.java4s.app.repository.customerDAORepository;
import com.java4s.app.xmltoObj.xmlToJavaObject;
import com.java4s.model.Customer;

@RestController
public class SpringJava4sController {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	xmlToJavaObject obj;
	@Autowired
	customerDAORepository repo;

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
	public String getCustomers() throws JAXBException {
		//final String uri = "http://localhost:8080/springbootrestxml/get-cust-info.xml";
		System.out.println(uri);
		String customerXml = restTemplate.getForObject(uri, String.class);
		System.out.println(customerXml);
		Customer cust=obj.xmlToObject(customerXml);
		repo.insertCustomerData(cust);
		return "Customer information saved successfully";
	}
	// to read xmlString data

}

// URL: http://localhost:8080/springbootrestxml/get-cust-info
// URL: http://localhost:8080/springbootrestxml/get-cust-info.json
// URL: http://localhost:8080/springbootrestxml/callService