package com.customer.web.controller;

import java.sql.Connection;
import java.util.*;
import com.customer.model.dao.Customer;
import com.customer.model.dao.CustomerDao;
import com.customer.model.dao.CustomerDaoImpl;
import com.customer.model.dao.ConnectionFactory;
import com.customer.model.dao.exception.CustomerNotFoundException;

public class CustomerController {
	public static void main(String[] args) {

		Connection connection = ConnectionFactory.getConnection();
		if (connection != null)
			System.out.println("sucess");

		CustomerDao dao = new CustomerDaoImpl();

		System.out.println("......Adding Customer Record.....");

		Customer customer = new Customer("thanu", "9988443322", "thanu@gmail.com", new Date(), "vizag", 1000000);
		dao.addCustomer(customer);
		System.out.println("Record added");

		System.out.println(".....Deleting customer record.....");
		dao.delCustomer(3);
		System.out.println("Record deleted");

		System.out.println(".....Print all the customer records....");

		List<Customer> customers = dao.getAllCustomers();
		customers.forEach(b -> System.out.println(b));

		System.out.println("........Update the customer record......");
		dao.updateCustomer(2, 1200000);
		System.out.println("Record updated");

		// get customer record by id

		Customer customer1 = dao.getCustomerById(2)
				.orElseThrow(() -> new CustomerNotFoundException("customer not found"));
		System.out.println(customer1);

		// get customer record by purchaseCapacity

		Customer customer2 = dao.getCustomerByPurchaseCapacity(1000000)
				.orElseThrow(() -> new CustomerNotFoundException("customer not found"));
		System.out.println(customer2);

	}

}