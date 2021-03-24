package com.cg.creditcardbillpaymen.services;

import java.util.List;

import com.cg.creditcardbillpaymen.entities.Customer;

public interface CustomerService {
	public Customer addCustomer(Customer customer);

	public Customer removeCustomer(long custId);

	public Customer updateCustomer(long custId, Customer customer);

	public Customer getCustomer(long custId);

	public List<Customer> getAllCustomers();
}
