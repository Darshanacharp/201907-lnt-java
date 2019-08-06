package in.conceptarchitect.finance.store;

import java.util.Collection;

import in.conceptarchitect.finance.AccountStore;
import in.conceptarchitect.finance.BankAccount;

public class SqlBankAccountStore implements AccountStore {

	public SqlBankAccountStore() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addAccount(BankAccount account) {
		// TODO Auto-generated method stub
		
		//insert into
		return 0;
	}

	@Override
	public BankAccount findAccount(int accountNumber) {
		// TODO Auto-generated method stub
		
		//select *
		return null;
	}

	@Override
	public Collection<BankAccount> getAccounts() {
		// TODO Auto-generated method stub
		
		//select *
		return null;
	}

	@Override
	public void removeAccount(BankAccount account) {
		// TODO Auto-generated method stub
		
		//remove

	}

	@Override
	public BankAccount findActiveAccount(int accountNumber) {
		// TODO Auto-generated method stub
		//select *
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		
		//selct count(*)
		return 0;
	}

	@Override
	public void update(BankAccount account) {
		// TODO Auto-generated method stub
		//update

	}

}
