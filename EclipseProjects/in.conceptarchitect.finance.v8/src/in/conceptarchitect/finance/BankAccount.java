package in.conceptarchitect.finance;

public class BankAccount {
	
	private int accountNumber;
	private String name;
	private double balance;
	private String password;
	private AccountStatus status;
	
	
	//change log: bank should pass accountNumber
	public  BankAccount(int accountNumber, String name, String pass, double amount) {
		// TODO Auto-generated method stub
		
		this.accountNumber=accountNumber;
		this.name=name;
		this.password=pass; //this optional but allowed
		this.balance=amount;
		this.status=AccountStatus.ACTIVE;
		//this.interestRate=rate;
	}
	
	
	public String getName() { return name;}
	
	public void setName(String value) {
		String ln1=lastName(name);
		String ln2=lastName(value);
		if(lastName(name).equals(lastName(value)))
			this.name=value;
		
	}
	
	private String lastName(String name) {
		// TODO Auto-generated method stub
		int lastSpace= name.lastIndexOf(' ');
		if(lastSpace==-1) //no blank space
			return "";
		else
			return name.substring(lastSpace+1);
	}

	
	public int getAccountNumber() { return accountNumber;} 
	
	//since accountNumber can't be changed after accountOpening there will be no setter
	
	public double getBalance() {return balance;}
	
	//balance can be changed by deposit/withdraw and not directly
	
	//password should have regular get/set
	
	public boolean authenticate(String password) {
		return this.password.equals(password);
		//return true;
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		if(authenticate(oldPassword))
			password=newPassword;
	}
	
	
	public void show() {
		System.out.println("Account Number "+accountNumber);
		System.out.println("Name           "+name);
		System.out.println("Balance        "+balance);
		//System.out.println("Inerest Rate   "+interestRate);
		System.out.println();
	}

	public boolean deposit(double amount) {
		// TODO Auto-generated method stub
		
		
		if(amount>0) {
			balance+=amount;
			return true;
		}
		else
			return false;
	}
	
	public boolean withdraw(double amount, String password) {
		
		//first check the conditions
		if(amount<0)
			return false;
		else if(amount>balance)
			return false;
		else if (! authenticate(password))
			return false;
		else {
			//eventually
			balance-=amount;
			return true;
		}
	}
	
	//change log: bank should pass interestRate here
	public void creditInterest(double interestRate)
	{
		balance+=balance*interestRate/1200;
	}


	public void setStatus(AccountStatus status) {
		// TODO Auto-generated method stub
		this.status=status;
	}
	
	public AccountStatus getStatus() {
		return status;
	}
	
	
	
}

