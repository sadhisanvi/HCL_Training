package com.bankapp.model.dao;

import java.util.*;

import com.bankapp.model.entity.User;

public interface UserDao {
	
	public User getUserById(int id);

	public List<User> getAllUser();

	public User updateUser(int id,User user);

	public User deleteUser(int id);

	public User addUser(User user);

	public User getUser(String username, String password);
}
