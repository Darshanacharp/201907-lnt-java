package in.conceptarchitect.finance.store;

import java.util.Collection;
import java.util.HashMap;

import in.conceptarchitect.finance.AccountStatus;
import in.conceptarchitect.finance.AccountStore;
import in.conceptarchitect.finance.BankAccount;
import in.conceptarchitect.finance.InvalidAccountException;

public class HashmapAccountStore implements AccountStore {

	int lastId=0;
	private HashMap<Integer, BankAccount> accounts=new HashMap<>();
	
	@Override
	public int addAccount(BankAccount account) {
		int accountNumber=++lastId;
		account.setAccountNumber(accountNumber);
		//accounts.add(account);				//accounts[accountNumber]=account;
		accounts.put(accountNumber, account);
		return accountNumber;
	}
	
	@Override
	public BankAccount findAccount(int accountNumber) {
		
		if(accounts.containsKey(accountNumber))
			return accounts.get(accountNumber);
		
		throw new InvalidAccountException(accountNumber,"Invalid Account");
	}
	@Override
	public Collection<BankAccount> getAccounts() {
		// TODO Auto-generated method stub
//		ArrayList<BankAccount> temp=new ArrayList<>();
//		for(int i=1;i<accounts.size();i++)
//			temp.add(accounts.get(i));
//		
//		return temp;
		return accounts.values();
			
	}
	@Override
	public void removeAccount(BankAccount account) {
		//accounts.remove(account);
		accounts.remove(account.getAccountNumber());
	}
	@Override
	public BankAccount findActiveAccount(int accountNumber) {

		BankAccount a = findAccount(accountNumber);

		if(a.getStatus()!=AccountStatus.ACTIVE)
			throw new InvalidAccountException(accountNumber,"Account Has Been Closed");

		return a;
	}
	@Override
	public int getCount() {
		return accounts.size();
	}

	@Override
	public void update(BankAccount account) {
		//do nothing
	}
	
}
