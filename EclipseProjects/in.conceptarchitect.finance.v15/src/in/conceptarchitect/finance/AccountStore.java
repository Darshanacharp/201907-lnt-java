package in.conceptarchitect.finance;

import java.util.Collection;

public interface AccountStore {

	int addAccount(BankAccount account);

	BankAccount findAccount(int accountNumber);

	Collection<BankAccount> getAccounts();

	void removeAccount(BankAccount account);

	BankAccount findActiveAccount(int accountNumber);

	int getCount();

	void update(BankAccount account);

}