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
		else if (password!=this.password)
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

