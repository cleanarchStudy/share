package cleanArchitecture.sumin.repository;

import org.springframework.stereotype.Repository;

import cleanArchitecture.sumin.entity.BankAccount;

@Repository
public interface BankAccountRepository {
	void save(BankAccount account);
	BankAccount findById(String accountId);
}
