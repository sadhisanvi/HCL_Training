package com.day2.q3;

public class SavingsAccount extends Account {
	private final static double INTEREST = 5;
	private final static double MAX_WITHDRAW_LIMIT = 5000.0;

	public SavingsAccount(String memberName, double accountBalance) {
		super(memberName, accountBalance);
	}

	public double getBalance() {
		double interest;
		if (getAccountBalance() >= 1000) {
			interest = getAccountBalance() * INTEREST;
		} else
			interest = 0.0;
		return interest;
	}

	public void withDraw(double amount) {
		if ((getAccountBalance() - amount) >= 1000) {
			setAccountBalance(getAccountBalance() - amount);
		} else {
			System.out.println("Insufficient funds");
		}
	}
}
