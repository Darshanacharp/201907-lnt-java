package in.conceptarchitect.finance;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayListAccountStore implements AccountStore{

	int lastId=0;
	private ArrayList<BankAccount> accounts=new ArrayList<>();
	
	public int addAccount(BankAccount account) {
		int accountNumber=++lastId;
		account.setAccountNumber(accountNumber);
		//accounts.add(account);				//accounts[accountNumber]=account;
		accounts.add( account);
		return accountNumber;
	}
	
	public BankAccount findAccount(int accountNumber) {
		
		if(accountNumber<1 || accountNumber>lastId)
			throw new InvalidAccountException(accountNumber,"No Such Account");
		
		for(int i=0;i<accountNumber;i++) {
			BankAccount a=accounts.get(i);
			if(a.getAccountNumber()==accountNumber)
				return a;
			
		}
		
		throw new InvalidAccountException(accountNumber,"Invalid Account");
	}
	public Collection<BankAccount> getAccounts() {
	
		return accounts;
			
	}
	public void removeAccount(BankAccount account) {
		//accounts.remove(account);
		accounts.remove(account);
	}
	public BankAccount findActiveAccount(int accountNumber) {

		BankAccount a = findAccount(accountNumber);

		if(a.getStatus()!=AccountStatus.ACTIVE)
			throw new InvalidAccountException(accountNumber,"Account Has Been Closed");

		return a;
	}
	
	public int getCount() {
		return accounts.size();
	}

	public void update(BankAccount account) {
		//do nothing
	}
	
}
