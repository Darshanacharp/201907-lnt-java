package in.conceptarchitect.app;

import in.conceptarchitect.finance.BankAccount;

public class Program {

	public static void main(String[] args) {
		//basicTests();
		
		
		
		//Constructor apart form in-memory creation can also
		//Apply in-domain creation of the object
		
		
		BankAccount a1=new BankAccount(1,"Vivek Mishra","p@ss",50000,12);
		BankAccount a2=new BankAccount(1,"Sanjay Mall","word",10000,14);
		
		
		a1.show();
		a2.show();
		
	

				
		
		
		
		
		
		

	}

	
}
