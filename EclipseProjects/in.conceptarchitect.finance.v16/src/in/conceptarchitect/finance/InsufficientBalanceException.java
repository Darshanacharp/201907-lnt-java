package in.conceptarchitect.finance;

public class InsufficientBalanceException extends BankingException {
	
	double deficit;

	public InsufficientBalanceException(int accountNumber,double deficit, String message) {
		super(accountNumber, message);
		// TODO Auto-generated constructor stub
		this.deficit=deficit;
	}

	public InsufficientBalanceException(int accountNumber,double deficit) {
		this(accountNumber,deficit,"Insufficient Balance : Deficit="+deficit);
		// TODO Auto-generated constructor stub
	}

	public double getDeficit() {
		return deficit;
	}

	public void setDeficit(double deficit) {
		this.deficit = deficit;
	}

}
