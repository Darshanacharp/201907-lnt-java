package in.conceptarchitect.app;

import in.conceptarchitect.finance.BankAccount;

public class Program {

	public static void main(String[] args) {
		//basicTests();
		
		//When is BankAccount object created?
		
		//Option 1 <---- here?
		BankAccount a1=new BankAccount();  //in-memory creation. 
		
		//object not ready as per business requirement
		//trying to use this object before second phase would be a problem
		
		
		//Option 2 <---- here?
		a1.openAccount(1,"Vivek Mishra","p@ss",50000,12); //domain object creation
		
		//An object is usuable only after phase 1 and phase 2 are complete...
		
		//We need to bridge this gap
		
		
		
		
		//testBankAccount1(a1);
		
		

	}

	private static void testBankAccount1(BankAccount a1) {
		a1.show();
		
		System.out.println(a1.getAccountNumber());
		System.out.println(a1.getName());
		System.out.println(a1.getBalance());
		System.out.println(a1.getInterestRate());
		
		a1.setInterestRate(15); //allowed range is 10.8 to 13.2
		System.out.println(a1.getInterestRate());
		
		a1.setInterestRate(13);
		System.out.println(a1.getInterestRate());
		
		a1.changePassword("hello", "hi"); //shouldn't change
		
		System.out.println(a1.authenticate("hi")); //false
		
		a1.changePassword("p@ss", "hi"); //should change
		
		System.out.println(a1.authenticate("hi")); //true
		System.out.println(a1.authenticate("p@ss")); //false --> old password is not working
	}

	private static void basicTests() {
		BankAccount a1=new BankAccount();
		
		a1.openAccount(1,"Vivek","p@ss",20000,12);
		
		BankAccount a2=new BankAccount();
		a2.openAccount(2,"Sanjay", "pass", 20000, 12);

		
		a1.show();
		a2.show();
		
		a1.deposit(1000);
		a2.deposit(-1000);
		
		a1.show();
		a2.show();
		
		a1.withdraw(50000, "p@ss");
		a1.withdraw(1000, "wrong-password");
		a1.withdraw(5000, "p@ss");
		
		a1.show();
	}

}
