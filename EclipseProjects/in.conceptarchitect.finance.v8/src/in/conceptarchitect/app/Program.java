package in.conceptarchitect.app;

import in.conceptarchitect.finance.ATM;
import in.conceptarchitect.finance.Bank;

public class Program {

	public static void main(String[] args) {
	
		//run();
		
		Bank icici=new Bank("ICICI", 12);
		int a1=icici.openAccount("Vivek Mishra","1234",10000);
		int a2=icici.openAccount("Shweta Mishra","1234",10000);
		
		
		boolean result=icici.closeAccount(a2, "1234");
		System.out.println(result);
		
		System.out.println("\n\n");
		
		result=icici.transfer(1, 5000, "1234", 2);
		System.out.println(result);
		
		System.out.println("\n\n");
		
		result=icici.withdraw(a1,6000, "1234");
		System.out.println(result);
		
		
		
		
		
	}

	private static void run() {
		Bank icici=new Bank("ICICI", 12);
		
		
		int a1=icici.openAccount("Vivek Mishra","1234",10000);
		int a2=icici.openAccount("Sanjay Mall","1234",10000);
		int a3=icici.openAccount("Amit Singh","1234",10000);
		int a4=icici.openAccount("Shivanshi Mishra","1234",10000);
		

		ATM atm=new ATM(icici); //installing ATM in icici bank
		
		atm.start();
		/*
		 * 1. Welcome Menu
		 * account number?
		 * password?
		 * 
		 * 2. Account Menu
		 * 1. deposit  2. witdraw  3. transfer  4. show info 5. close 6. exit
		 * 
		 * 
		 * 2.3 Transfer menu
		 * amount?
		 * to?
		 * 
		 * 2.2 Withdraw Menu
		 * amount?
		 */
		
		System.out.println("ATM Shutdown...");
	}

	
}
