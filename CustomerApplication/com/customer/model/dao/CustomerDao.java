package com.customer.model.dao;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
	public void addCustomer(Customer customer);

	public void delCustomer(int id);

	public void updateCustomer(int id, double purchaseCapacity);

	public List<Customer> getAllCustomers();

	public Optional<Customer> getCustomerById(int id);

	public Optional<Customer> getCustomerByPurchaseCapacity(double purchaseCapacity);
}