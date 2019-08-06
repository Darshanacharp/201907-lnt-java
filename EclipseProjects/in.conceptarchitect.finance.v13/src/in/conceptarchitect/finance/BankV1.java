package in.conceptarchitect.finance;

import java.util.ArrayList;

public class BankV1 {


	int lastId=0;
	double interestRate=12;
	private String name;

//	private static final int MAX_ACCOUNTS=100;
//	private BankAccount [] accounts=new BankAccount[MAX_ACCOUNTS];
	private ArrayList<BankAccount> accounts=new ArrayList<BankAccount>();

	private ArrayList<BankAccount> closedAccounts=new ArrayList<BankAccount>();
	
	private int addAccount(BankAccount account) {
		int accountNumber=++lastId;
		account.accountNumber=accountNumber;
		accounts.add(account);				//accounts[accountNumber]=account;
		
		return accountNumber;
	}
	
	private BankAccount findAccount(int accountNumber) {
		if(accountNumber<1 || accountNumber> lastId)
			throw new InvalidAccountException(accountNumber,"No Such Account ");

		
		//BankAccount a=accounts.get(accountNumber-1);		//accounts[accountNumber];
		
		for(int i=0;i<accountNumber;i++)
			if(accounts.get(i).accountNumber==accountNumber)
				return accounts.get(i);
		
		throw new InvalidAccountException(accountNumber,"Account Has been Closed ");
	}
	
	private ArrayList<BankAccount> getAccounts() {
		// TODO Auto-generated method stub
//		ArrayList<BankAccount> temp=new ArrayList<>();
//		for(int i=1;i<accounts.size();i++)
//			temp.add(accounts.get(i));
//		
//		return temp;
		return accounts;
			
	}
	
	private void removeAccount(BankAccount account) {
		accounts.remove(account);
	}

	
	private BankAccount findActiveAccount(int accountNumber) {

		BankAccount a = findAccount(accountNumber);

		if(a.getStatus()!=AccountStatus.ACTIVE)
			throw new InvalidAccountException(accountNumber,"Account Has Been Closed");

		return a;
	}
	
	private int getCount() {
		return accounts.size();
	}

		
	
	
	
	public BankV1(String name, double rate) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.interestRate=rate;
	//	accounts.add(null); //index 0 is now used
	}

	public int getAccountCount() { return getCount();}

	


	public int openAccount(String accountName, String password, double amount) {
		// TODO Auto-generated method stub
		return openSavingsAccount(accountName, password, amount);
	}
	
	public int openSavingsAccount(String accountName, String password, double amount) {
		// TODO Auto-generated method stub
		
		BankAccount account=new SavingsAccount(0,accountName,password, amount);
		return addAccount(account);
	}

	
	
	public int openCurrentAccount(String accountName, String password, double amount) {
		// TODO Auto-generated method stub
		return addAccount(new CurrentAccount(0,accountName,password, amount));
	}
	
	public int openOverdraftAccount(String accountName, String password, double amount) {
		// TODO Auto-generated method stub
		return addAccount(new OverdraftAccount(0,accountName,password, amount));
		
	}
	
	

	public void showInfo(int accountNumber, String password) {
		BankAccount a = findActiveAccount(accountNumber);
		a.authenticate(password);
		System.out.println(a);
	}


	public void deposit(int accountNumber, double amount) {
		// TODO Auto-generated method stub
		BankAccount a = findActiveAccount(accountNumber);
		a.deposit(amount);

	}

	



	public void withdraw(int accountNumber, double amount, String password) {
		// TODO Auto-generated method stub
		BankAccount a=findActiveAccount(accountNumber);
		
		a.withdraw(amount, password);
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
		for(BankAccount account: getAccounts()) {

			if(account.getStatus()!=AccountStatus.ACTIVE)
				continue;
			System.out.printf("%d\t%f\t%s\n", account.getAccountNumber(),account.getBalance(),account.getName());
		}

	}
	
	public void creditInterest() {
		// TODO Auto-generated method stub
		for(BankAccount account: getAccounts()) {
			
			if(account.getStatus()!=AccountStatus.ACTIVE)
				continue;
			account.creditInterest(interestRate);
		}
	}

	
	public void transfer(int sourceAccount, double amount, String password, int targetAccount) {
		// TODO Auto-generated method stub

		BankAccount from=findActiveAccount(sourceAccount);
		BankAccount to=findActiveAccount(targetAccount);

		from.withdraw(amount,password);
		to.deposit(amount);
		
	}

	public void closeAccount(int accountNumber, String password) {
		// TODO Auto-generated method stub
		BankAccount account=findActiveAccount(accountNumber);
		
		account.authenticate(password);
		if(account.getBalance()<0)
				throw new InsufficientBalanceException(accountNumber, - account.getBalance()," You need to clear your dues before closing");

		account.setStatus(AccountStatus.CLOSED);
		
		removeAccount(account); //remove from active accounts
		closedAccounts.add(account); //add to closed accounts
		
	}

	

	public BankAccount getAccount(int a1, String password) {
		// TODO Auto-generated method stub
		BankAccount a= findActiveAccount(a1);
		a.authenticate(password);	
		return a;
		
	}

	


}



















