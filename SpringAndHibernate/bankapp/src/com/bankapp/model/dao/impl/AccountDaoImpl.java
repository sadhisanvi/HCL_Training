package com.bankapp.model.dao.impl;

import java.util.List;
import com.bankapp.model.dao.exceptions.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.model.dao.AccountDao;
import com.bankapp.model.entity.Account;
import com.bankapp.model.entity.User;


@Repository
public class AccountDaoImpl implements AccountDao {
		
	private SessionFactory factory;
	@Autowired
	public AccountDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public List<Account> getAllAccounts() {
		return  getSession().createQuery("select a from Account a").list();
	}

	@Override
	public Account updateAccount(Account account) {	 	
		getSession().update(account);
		return account;
	}
	
	public Account updateAccount(int id,Account account) {	 	
		Account accountToUpdate = getAccountById(id);
		accountToUpdate.setAddress(account.getAddress());
		accountToUpdate.setPhone(account.getPhone());
		accountToUpdate.setEmail(account.getEmail());
		getSession().update(accountToUpdate);
		return accountToUpdate;
	}

	@Override
	public Account delAccount(int accountId) {
		Account accountToDelete = getAccountById(accountId);
		getSession().delete(accountToDelete);
		return accountToDelete;	
	}
	
	
	@Override
	public Account getAccountById(int accountId) {
		Account account = getSession().find(Account.class, accountId);
		if(account==null) {
			throw new AccountNotFoundExceptions("account with id :"+accountId+" is not found");
		}
		return account;
	}

	@Override
	public Account addAccount(Account account) {
		// TODO Auto-generated method stub
		getSession().persist(account);
		return account;
	}

}
