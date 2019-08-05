package in.conceptarchitect.finance;

public class SavingsAccount extends BankAccount{

	public SavingsAccount(int accountNumber, String name, String password, double amount) {
		// TODO Auto-generated constructor stub
		super(accountNumber,name,password,amount);
	}

	//inherits without a change
	//deposit()
	//creditInterest()
	//getName()/setName()
	//getBalance()
	//getAccountNumber()
	//authenticate()
	//changePasword()

	//override withdraw
	/**
	 * 
	 * should add additional condition of minBalance
	 */

	//withdraw()

	public int getMinBalance() {
		// TODO Auto-generated method stub
		return 5000;
	}

	public void withdraw(double amount, String password) {
	
		
		if(amount>getBalance()-getMinBalance())
			throw new InsufficientBalanceException(accountNumber, amount-getBalance()-getMinBalance());
			
		super.withdraw(amount, password);
	
	
	}



}
