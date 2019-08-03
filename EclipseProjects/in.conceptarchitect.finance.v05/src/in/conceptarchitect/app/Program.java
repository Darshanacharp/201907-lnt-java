package in.conceptarchitect.app;

import in.conceptarchitect.finance.Bank;

public class Program {

	public static void main(String[] args) {
	
		Bank icici=new Bank("ICICI", 12);
		
		
		int a1=icici.openAccount("Vivek Mishra","p@ss",10000);
		int a2=icici.openAccount("Sanjay Mall","p@ss",10000);
		int a3=icici.openAccount("Amit Singh","p@ss",10000);
		int a4=icici.openAccount("Shivanshi Mishra","p@ss",10000);
		
		
		icici.showInfo(a1);
		icici.showInfo(a2);
		icici.showInfo(a3);
		icici.showInfo(a4);
		
		System.out.println("deposit status: "+icici.deposit(a4,1000));
		
		System.out.println("withdraw status:"+icici.withdraw(a3,2000,"p@ss"));
		
		icici.setInterestRate(13);
		
		icici.creditInterest(); //credit interest to all accounts
		
		icici.printAccountList();
		
		boolean status=icici.transfer(a1, 1000,"p@ss", a3); //transfer Rs 1000 from a1 to a3 using given password (for a1)
		
		System.out.println("transfer 1 status :"+status);

		icici.closeAccount(a2,"p@ss"); //close this account
		
		status=icici.transfer(a1, 1000, "p@ss", a2); //transferring to closed account
		
		System.out.println("transfer 2 status:"+status);
		
		icici.printAccountList(); //now should print a1,a3,a4 not a2
		
		
		
		
		System.out.println("Total Accounts: "+ icici.getAccountCount() );
		
	

				
		
		
		
		
		
		

	}

	
}
