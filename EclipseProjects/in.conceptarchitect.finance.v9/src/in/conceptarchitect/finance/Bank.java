package in.conceptarchitect.finance;

public class Bank {

	static final int MAX_ACCOUNTS=100;
	int lastId=0;
	double interestRate=12;
	private String name;
	BankAccount [] accounts=new BankAccount[MAX_ACCOUNTS];

	public Bank(String name, double rate) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.interestRate=rate;
	}

	public int getAccountCount() { return lastId;}


	public int openAccount(String accountName, String password, double amount) {
		// TODO Auto-generated method stub
		return openSavingsAccount(accountName, password, amount);
	}
	
	public int openSavingsAccount(String accountName, String password, double amount) {
		// TODO Auto-generated method stub
		
		BankAccount account=new SavingsAccount(0,accountName,password, amount);
		return addAccount(account);
	}

	private int addAccount(BankAccount account) {
		int accountNumber=++lastId;
		account.accountNumber=accountNumber;
		accounts[accountNumber]=account;
		return accountNumber;
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

		if(a==null)
			return;

		if(!a.authenticate(password))
			return ;

		//a.show();
		System.out.println(a);
	}


	public boolean deposit(int accountNumber, double amount) {
		// TODO Auto-generated method stub
		BankAccount a = findActiveAccount(accountNumber);

		if(a==null)
			return false;
		return a.deposit(amount);

	}

	private BankAccount findActiveAccount(int accountNumber) {

		if(accountNumber<1 || accountNumber> lastId)
			return null; //no such account
		BankAccount a=accounts[accountNumber];

		if(a.getStatus()!=AccountStatus.ACTIVE)
			return null;

		return a;
	}



	public boolean withdraw(int accountNumber, double amount, String password) {
		// TODO Auto-generated method stub
		BankAccount a=findActiveAccount(accountNumber);
		if(a==null)
			return false;
		return a.withdraw(amount, password);
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

		for(int i=1;i<=lastId; i++){
			BankAccount a=findActiveAccount(i);
			if(a==null)
				continue;
			System.out.printf("%d\t%f\t%s\n", a.getAccountNumber(),a.getBalance(),a.getName());
		}

	}
	
	
	
	public void creditInterest() {
		// TODO Auto-generated method stub
		for(int i=1;i<=lastId;i++)
		{
			BankAccount a=findActiveAccount(i);
			if(a==null)
				continue;

			a.creditInterest(interestRate);
		}
	}

	public boolean transfer(int sourceAccount, double amount, String password, int targetAccount) {
		// TODO Auto-generated method stub

		BankAccount from=findActiveAccount(sourceAccount);
		BankAccount to=findActiveAccount(targetAccount);

		if(from==null)
			return false;

		if(to==null)
			return false;

		if(from.withdraw(amount,password))
			return to.deposit(amount);
		else
			return false;


	}

	public boolean closeAccount(int accountNumber, String password) {
		// TODO Auto-generated method stub
		BankAccount account=findActiveAccount(accountNumber);
		if(account==null)
			return false;

		if(account.authenticate(password))
		{
			if(account.getBalance()<0)
				return false;

			account.setStatus(AccountStatus.CLOSED);
			return true;
		}

		return false;

	}

	public BankAccount getAccount(int a1, String password) {
		// TODO Auto-generated method stub
		BankAccount a= findActiveAccount(a1);
		if(a!=null && a.authenticate(password))	
			return a;
		else
			return null;
	}

	


}



















