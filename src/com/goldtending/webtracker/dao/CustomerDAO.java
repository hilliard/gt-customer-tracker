package com.goldtending.webtracker.dao;

import java.util.List;

import com.goldtending.webtracker.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	// added by eclipse
	public Customer getCustomers(int theId);

	public void deleteCustomer(int theId);


}
