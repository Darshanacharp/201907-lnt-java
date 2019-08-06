package in.conceptarchitect.finance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Bank {


	double interestRate=12;
	private String name;
	AccountStore store;
	
	
	public Bank(String name, double rate, AccountStore store) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.interestRate=rate;
	//	accounts.add(null); //index 0 is now used
		//store=new HashmapAccountStore();
		this.store=store;
	}

	public int getAccountCount() { return store.getCount();}

	


	public int openAccount(String accountName, String password, double amount) {
		// TODO Auto-generated method stub
		return openSavingsAccount(accountName, password, amount);
	}
	
	public int openSavingsAccount(String accountName, String password, double amount) {
		// TODO Auto-generated method stub
		
		BankAccount account=new SavingsAccount(0,accountName,password, amount);
		return store.addAccount(account);
	}

	
	
	public int openCurrentAccount(String accountName, String password, double amount) {
		// TODO Auto-generated method stub
		return store.addAccount(new CurrentAccount(0,accountName,password, amount));
	}
	
	public int openOverdraftAccount(String accountName, String password, double amount) {
		// TODO Auto-generated method stub
		return store.addAccount(new OverdraftAccount(0,accountName,password, amount));
		
	}
	
	

	public void showInfo(int accountNumber, String password) {
		BankAccount a = store.findActiveAccount(accountNumber);
		a.authenticate(password);
		System.out.println(a);
	}


	public void deposit(int accountNumber, double amount) {
		// TODO Auto-generated method stub
		BankAccount a = store.findActiveAccount(accountNumber);
		a.deposit(amount);
		store.update(a);

	}

	
	public void withdraw(int accountNumber, double amount, String password) {
		// TODO Auto-generated method stub
		BankAccount a=store.findActiveAccount(accountNumber);
		
		a.withdraw(amount, password);
		store.update(a);
	}


	public double getInterestRate() {return interestRate;}

	public void setInterestRate(double value) {
		double min= interestRate*.9;
		double max= interestRate*1.1;
		if(value<min || value>max)
			return ; //don't change the value
		//change the value only when valid
		interestRate=value;
	}

	public void printAccountList() {
		// TODO Auto-generated method stub
		//for(int i=1;i<=lastId; i++){
		for(BankAccount account: store.getAccounts()) {

			if(account.getStatus()!=AccountStatus.ACTIVE)
				continue;
			System.out.printf("%d\t%f\t%s\n", account.getAccountNumber(),account.getBalance(),account.getName());
		}

	}
	
	public void creditInterest() {
		// TODO Auto-generated method stub
		for(BankAccount account: store.getAccounts()) {
			
			if(account.getStatus()!=AccountStatus.ACTIVE)
				continue;
			account.creditInterest(interestRate);
		}
		
		store.update(null); //null means all update
	}

	
	public void transfer(int sourceAccount, double amount, String password, int targetAccount) {
		// TODO Auto-generated method stub

		BankAccount from=store.findActiveAccount(sourceAccount);
		BankAccount to=store.findActiveAccount(targetAccount);

		from.withdraw(amount,password);
		to.deposit(amount);
		
		store.update(from);
		store.update(to);
		
	}

	public void closeAccount(int accountNumber, String password) {
		// TODO Auto-generated method stub
		BankAccount account=store.findActiveAccount(accountNumber);
		
		account.authenticate(password);
		if(account.getBalance()<0)
				throw new InsufficientBalanceException(accountNumber, - account.getBalance()," You need to clear your dues before closing");

		account.setStatus(AccountStatus.CLOSED);
		
		store.removeAccount(account); //remove from active accounts
		//closedAccounts.add(account); //add to closed accounts
		
	}

	

	public BankAccount getAccount(int a1, String password) {
		// TODO Auto-generated method stub
		BankAccount a= store.findActiveAccount(a1);
		a.authenticate(password);	
		return a;
		
	}

	


}



















