package in.conceptarchitect.finance;

public class BankAccount {

	int accountNumber;
	String name;
	double balance;
	String password;
	double interestRate;
	
	public void openAccount(int accNo, String name, String pass, double amount, double rate) {
		// TODO Auto-generated method stub
		accountNumber=accNo;
		this.name=name;
		this.password=pass; //this optional but allowed
		this.balance=amount;
		this.interestRate=rate;
	}
	
	
	public String getName() { return name;}
	
	public void setName(String value) {
	
		if(lastName(name) == lastName(value))
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

	public double getInterestRate() {return interestRate;}
	
	
	public void setInterestRate(double value) {
		double min= interestRate*.9;
		double max= interestRate*1.1;
		if(value<min || value>max)
			return ; //don't change the value
		//change the value only when valid
		interestRate=value;
	}
	
	public int getAccountNumber() { return accountNumber;} 
	
	//since accountNumber can't be changed after accountOpening there will be no setter
	
	public double getBalance() {return balance;}
	
	//balance can be changed by deposit/withdraw and not directly
	
	//password should have regular get/set
	
	public boolean authenticate(String password) {
		return this.password==password;
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		if(authenticate(oldPassword))
			password=newPassword;
	}
	
	
	
	
	
	public void show() {
		System.out.println("Account Number "+accountNumber);
		System.out.println("Name           "+name);
		System.out.println("Balance        "+balance);
		System.out.println("Inerest Rate   "+interestRate);
		System.out.println();
	}

	public void deposit(double amount) {
		// TODO Auto-generated method stub
		if(amount>0) {
			balance+=amount; //depsoit only when it is grater than 0
			System.out.println("Amount Deposited");
		}
		else
			System.out.println("Negative Amount Not allowed");
	}
	
	public void withdraw(double amount, String password) {
		
		//first check the conditions
		if(amount<0)
			System.out.println("Negative Amount Not Allowed");
		else if(amount>balance)
			System.out.println("Insufficient Balance");
		else if (! authenticate(password))
			System.out.println("Invalid Credentials");
		else {
			//eventually
			balance-=amount;
			System.out.println("Please Collect your cash");
		}
	}
	
	public void creditInterest()
	{
		balance+=balance*interestRate/1200;
	}
	
	
	
}

