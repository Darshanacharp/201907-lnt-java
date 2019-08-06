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
	public void withdraw(double amount, String password) {
		// TODO Auto-generated method stub
		validateAmount(amount);

		if(amount>balance+odLimit)
			throw new InsufficientBalanceException(getAccountNumber(), amount-balance+odLimit);

		authenticate(password);


		balance-=amount;
		if(balance<0) {
			double odCharge= -balance/10;
			balance-=odCharge;

		}
	}
	
	@Override
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		super.deposit(amount);
		adjustOdLimit();
	}
	
	@Override
	public void creditInterest(double interestRate) {
		// TODO Auto-generated method stub
		super.creditInterest(interestRate);
		adjustOdLimit();
	}
	
	@Override
	public String toCsvString() {
		// TODO Auto-generated method stub
		return super.toCsvString()+","+odLimit;
	}
	
	
	
	
	
	
}
