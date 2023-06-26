package cleanArchitecture.sumin.service;

import org.springframework.stereotype.Service;

import cleanArchitecture.sumin.entity.BankAccount;
import cleanArchitecture.sumin.repository.BankAccountRepository;

@Service
public class BankAccountService {
	private BankAccountRepository repository;

	public BankAccountService(BankAccountRepository repository) {
		this.repository = repository;
	}

	public void createAccount(String accountId) {
		BankAccount account = new BankAccount(accountId);
		repository.save(account);
	}

	public void deposit(String accountId, double amount) {
		BankAccount account = repository.findById(accountId);
		account.deposit(amount);
		repository.save(account);
	}

	public void withdraw(String accountId, double amount) {
		BankAccount account = repository.findById(accountId);
		account.withdraw(amount);
		repository.save(account);
	}

	public double getBalance(String accountId) {
		BankAccount account = repository.findById(accountId);
		return account.getBalance();
	}
}
