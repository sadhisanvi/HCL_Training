package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.entity.User;

public interface UserService {

	public User getUserById(int id);

	public List<User> getAllUser();
	
	public User updateUser(int id,User user);

	public User deleteUser(int id);

	public User getUser(String username, String password);

	public void addUser(User user);

	public boolean verifyDetails(String username, String password);
}
