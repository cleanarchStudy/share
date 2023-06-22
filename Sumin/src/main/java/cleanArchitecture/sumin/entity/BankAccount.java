package cleanArchitecture.sumin.entity;

import cleanArchitecture.sumin.error.InsufficientFundsException;
public class BankAccount {

	private String accountId;
	private double balance;

	public BankAccount(String accountId) {
		this.accountId = accountId;
		this.balance = 0.0;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {
		if (amount <= balance) {
			balance -= amount;
		} else {
			throw new InsufficientFundsException("Insufficient funds in the account.");
		}
	}

	public double getBalance() {
		return balance;
	}
}
