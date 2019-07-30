package in.conceptarchitect.app;

import in.conceptarchitect.finance.BankAccount;

public class Program {

	public static void main(String[] args) {
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
