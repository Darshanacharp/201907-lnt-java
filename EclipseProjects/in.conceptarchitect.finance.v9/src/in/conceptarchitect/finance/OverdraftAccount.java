package in.conceptarchitect.finance;

public class OverdraftAccount extends BankAccount {

	double odLimit;
	
	public double getOdLimit() {
		return odLimit;
	}

	public OverdraftAccount(int accountNumber, String name, String pass, double amount) {
		super(accountNumber, name, pass, amount);
		
		adjustOdLimit();
	}

	private void adjustOdLimit() {
		// TODO Auto-generated method stub
		double newOdLimit= this.getBalance()/10;
		if(newOdLimit>odLimit)
			this.odLimit=newOdLimit;
	}

	@Override
	public boolean withdraw(double amount, String password) {
		// TODO Auto-generated method stub
		if(amount<0)
			return false;
		else if(amount>balance+odLimit)
			return false;
		else if (! authenticate(password))
			return false;
		else {
			//eventually
			balance-=amount;
			if(balance<0) {
				double odCharge= -balance/10;
				balance-=odCharge;
			}
			return true;
		}
	}
	
	@Override
	public boolean deposit(double amount) {
		// TODO Auto-generated method stub
		boolean result=super.deposit(amount);
		
		adjustOdLimit();
		
		return result;
	}
	
	@Override
	public void creditInterest(double interestRate) {
		// TODO Auto-generated method stub
		super.creditInterest(interestRate);
		adjustOdLimit();
	}
	
	
	
	
	
	
	
}
