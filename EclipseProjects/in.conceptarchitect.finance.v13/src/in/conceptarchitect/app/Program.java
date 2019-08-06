package in.conceptarchitect.app;

import in.conceptarchitect.finance.ATM;
import in.conceptarchitect.finance.AccountStore;
import in.conceptarchitect.finance.ArrayListAccountStore;
import in.conceptarchitect.finance.Bank;

public class Program {

	public static void main(String[] args) {
	
		run();
		
		//test();
		
		
		
		
		
	}

	
	private static void run() {
		AccountStore store=new ArrayListAccountStore();
		Bank icici=new Bank("ICICI", 12,store);
		
		
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
