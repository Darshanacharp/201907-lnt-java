package in.conceptarchitect.finance;

import in.conceptarchitect.app.Input;

public class ATM {

	private Bank bank;
	Input keyboard;
	int accountNumber;
	
	public ATM(Bank bank) {
		// TODO Auto-generated constructor stub
		this.bank=bank;
		keyboard=new Input();
		
	}

	public void start() {
		while(true)
			mainMenu();
	}
	
	public void mainMenu() {
		// TODO Auto-generated method stub
		System.out.println("\n\nWelcome");
		accountNumber=keyboard.readInt("account number? ");
		if(accountNumber==-1) {
			String password=keyboard.readString("password?");
			if(password.equals("NIMDA"))
				adminMenu();
		}
		else
			userMenu();
	}
	
	private int adminMenu() {
		String menu="1. Open Account 2. Account List 3. Credit Interest 4. Shutdown 0. Exit ?";
		int choice;
		do {
			choice=keyboard.readInt(menu);
			switch(choice) {
			case 1:  adminOpenAccount(); break;
			case 2:  adminAccountList(); break;
			case 3:  adminCreditInterest(); break;
			case 4:  System.exit(0); break;
			default: System.out.println("Invalid Input. Retry");
			case 0:  break;
			}
		}while(choice!=0);
		
		return choice;
	}
	
	private void adminOpenAccount() {
		
		String name=keyboard.readString("Name?");
		String password=keyboard.readString("password?");
		double amount=keyboard.readDouble("amount?");
		
		bank.openAccount(name, password, amount);
		
	}
	private void adminAccountList() {
		
		bank.printAccountList();
	}
	private void adminCreditInterest() {
		bank.creditInterest();
	}
	
	private int userMenu() {
		
		String menu="1. Deposit 2. Withdraw 3. Transfer 4. Show 5. Close 0. Exit ?";
		int choice=0;
		do {
				try {
					choice=keyboard.readInt(menu);
					switch(choice) {
					case 1:  userDeposit(); break;
					case 2:  userWithdraw(); break;
					case 3:  userTransfer(); break;
					case 4:  userShowBalance(); break;
					case 5:  userClose(); break;
					default: System.out.println("Invalid Input. Retry");
					case 0:  break;
				}
				
			} 
			catch(InsufficientBalanceException ex) {
				
				System.out.println("You have insufficient funds. You need "+ex.getDeficit()+" more for this transaction");
			}
			catch(BankingException ex) {
			printMessage("Error : Account Number: "+ex.getAccountNumber()+"\t: "+ex.getMessage());
		} 
		}while(choice!=0);
		
		return choice;
	}
	
	private void userDeposit() {
		double amount=keyboard.readDouble("amount to deposit?");
		bank.deposit(accountNumber, amount);
		printMessage("Amount Is Deposited");
		
	}
	
	private void printMessage(String message) {
		System.out.println(message);
	}
	private void userWithdraw() {
		
		int amount=keyboard.readInt("amount to withdraw?");
		
		if(! canWithdrawCash(amount)) {
			printMessage("Unable to withdraw "+amount);
			return;
		}
		
		String pin=keyboard.readString("pin?");
		
		bank.withdraw(accountNumber, amount, pin);
		dispenseCash(amount);
		
		
	}
	
	private boolean canWithdrawCash(int amount) {
		return amount%100==0 && amount<=50000;
	}
	
	private void dispenseCash(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Please Collect Your Cash "+amount);
	}

	private void userTransfer() {
		double amount=keyboard.readDouble("amount ?");
		String password=keyboard.readString("password?");
		int to=keyboard.readInt("To Account?");
		
		bank.transfer(accountNumber, amount, password, to);
		printMessage("Transfer was successful");
		
	}
	
	private void userShowBalance() {
		String password=keyboard.readString("pin?");		
		bank.showInfo(accountNumber,password);
	}
	
	private void userClose() {
		String confirmMessage="PLEASE CLOSE MY ACCOUNT";
		String password= keyboard.readString("pin?");
		String confirm=keyboard.readString("type the message: "+confirmMessage+" to close");
		if(!confirm.equals(confirmMessage))
			return;
		
		bank.closeAccount(accountNumber, password);
		printMessage("Your account has been closed");
		
			
	}
	
	
	
	

}
