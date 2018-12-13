package com.java4s.app.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.java4s.model.Customer;

@Repository
public class customerDAORepository {
	@Autowired
	 JdbcTemplate jdbcTemplate;
	
	public void insertCustomerData(Customer customer){
		
		String query="insert into customer values( '"+customer.getCustNo()+"','"+customer.getCountry()+"','"+customer.getName()+"')";
		jdbcTemplate.update(query);    
	}

}
