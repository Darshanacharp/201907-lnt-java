package in.conceptarchitect.app;

import in.conceptarchitect.finance.BankAccount;

public class Program {

	public static void main(String[] args) {
		//basicTests();
		
		
		
		//Constructor apart form in-memory creation can also
		//Apply in-domain creation of the object
		
		
		BankAccount a1=new BankAccount("Vivek Mishra","p@ss",50000);
		BankAccount a2=new BankAccount("Sanjay Mall","word",10000);
		BankAccount a3=new BankAccount("Amit Singh","word",10000);
		BankAccount a4=new BankAccount("Shivanshi Mishra","word",10000);
		
		
		a1.show();
		a2.show();
		a3.show();
		a4.show();
		
		//a1.setInterestRate(13);
		
		BankAccount.setInterestRate(13);
		
		a1.show();
		a2.show();
		a3.show();
		a4.show();
		
		
	

				
		
		
		
		
		
		

	}

	
}
