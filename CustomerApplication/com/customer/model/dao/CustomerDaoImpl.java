package com.customer.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.customer.model.dao.exception.CustomerNotFoundException;
import com.customer.model.dao.exception.DataAccessException;

public class CustomerDaoImpl implements CustomerDao {

	private Connection connection;

	public CustomerDaoImpl() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void addCustomer(Customer customer) {

		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"insert into customers(name,phone,email,birthDate,address,purchaseCapacity) values (?,?,?,?,?,?)");
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getPhone());
			pstmt.setString(3, customer.getEmail());
			pstmt.setDate(4, new Date(customer.getBirthDate().getTime()));
			pstmt.setString(5, customer.getAddress());
			pstmt.setDouble(6, customer.getPurchaseCapacity());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new DataAccessException("some jdbc problem", e);
		}

	}

	@Override
	public void delCustomer(int id) {
		Customer customer = getCustomerById(id)
				.orElseThrow(() -> new CustomerNotFoundException("Customer with id:" + id + " is not found"));

		try {
			PreparedStatement pstmt = connection.prepareStatement("delete from customers where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new DataAccessException("some jdbc problem", e);
		}

	}

	@Override
	public void updateCustomer(int id, double purchaseCapacity) {
		Customer customer = getCustomerById(id)
				.orElseThrow(() -> new CustomerNotFoundException("Customer with id:" + id + " is not found"));

		try {
			PreparedStatement pstmt = connection.prepareStatement("update customers set purchaseCapacity=? where id=?");
			pstmt.setDouble(1, purchaseCapacity);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new DataAccessException("some jdbc problem", e);
		}
	}

	@Override
	public List<Customer> getAllCustomers() {

		List<Customer> customers = new ArrayList<>();
		Customer customer = null;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customers");

			while (rs.next()) {

				customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("phone"),
						rs.getString("email"), rs.getDate("birthDate"), rs.getString("address"),
						rs.getDouble("purchaseCapacity"));

				customers.add(customer);
			}

		} catch (SQLException e) {
			throw new DataAccessException("some jdbc issue", e);
		}

		return customers;
	}

	@Override
	public Optional<Customer> getCustomerById(int id) {

		Customer customer = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement("select * from customers where id=?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				customer = new Customer(id, rs.getString("name"), rs.getString("phone"), rs.getString("email"),
						rs.getDate("birthDate"), rs.getString("address"), rs.getDouble("purchaseCapacity"));
			}

		} catch (SQLException e) {
			throw new DataAccessException("some jdbc problem", e);
		}
		return Optional.ofNullable(customer);
	}

	@Override
	public Optional<Customer> getCustomerByPurchaseCapacity(double purchaseCapacity) {
		Customer customer = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement("select * from customers where purchaseCapacity=?");
			pstmt.setDouble(1, purchaseCapacity);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				customer = new Customer((rs.getInt("id")), rs.getString("name"), rs.getString("phone"),
						rs.getString("email"), rs.getDate("birthDate"), rs.getString("address"),
						purchaseCapacity);
			}

		} catch (SQLException e) {
			throw new DataAccessException("some jdbc problem", e);
		}
		return Optional.ofNullable(customer);
	}

}