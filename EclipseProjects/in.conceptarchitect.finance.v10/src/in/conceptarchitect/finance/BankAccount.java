package in.conceptarchitect.finance;

public abstract class BankAccount {
	
	int accountNumber; //package scope
	private String name;
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
	public double getBalance() {return balance;}
	
	public void changePassword(String oldPassword, String newPassword) {
		authenticate(oldPassword); //authenticate
		password=newPassword; //change
	}
//	public void show() {
//		System.out.println("Account Number "+accountNumber);
//		System.out.println("Name           "+name);
//		System.out.println("Balance        "+balance);
//		//System.out.println("Inerest Rate   "+interestRate);
//		System.out.println();
//	}
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		validateAmount(amount);
		balance+=amount;
	}
	
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
	
	protected double balance;
	private String password;
	
	
	public void authenticate(String password) {
		if(! this.password.equals(password))
			throw new InvalidCredentialsException(accountNumber);
		//else
			//no news is a good news
	}
	
	protected void validateAmount(double amount) {
		if(amount<0)
			throw new InvalidDenominationException();
	}
	
	public void withdraw(double amount, String password) {
		
		
		authenticate(password);
		//if you are here. that means authentication was a success
		validateAmount(amount);

		if(amount>balance) 
			throw new InsufficientBalanceException(accountNumber, amount-balance);
		
		balance-=amount;
	}
	
	@Override
	public String toString() {
		return String.format("%s %d\t%f\t%s",
				this.getAccountType(),
				this.accountNumber,
				this.balance,
				this.name
				);
	}
	
	public String getAccountType() {
		return getClass().getSimpleName();
	}
	
	
	
	
}

