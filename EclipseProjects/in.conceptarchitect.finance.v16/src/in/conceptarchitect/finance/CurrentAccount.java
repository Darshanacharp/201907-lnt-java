package in.conceptarchitect.finance;

public class CurrentAccount extends BankAccount {

	public CurrentAccount(int accountNumber, String name, String pass, double amount) {
		super(accountNumber, name, pass, amount);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void creditInterest(double interestRate) {
		
	}

}
