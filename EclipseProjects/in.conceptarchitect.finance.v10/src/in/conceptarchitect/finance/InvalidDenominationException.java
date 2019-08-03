package in.conceptarchitect.finance;

public class InvalidDenominationException extends BankingException {

	public InvalidDenominationException(int accountNumber, String message) {
		super(accountNumber, message);
		// TODO Auto-generated constructor stub
	}

	public InvalidDenominationException(int accountNumber) {
		super(accountNumber);
		// TODO Auto-generated constructor stub
	}
	
	public InvalidDenominationException() {
		this(0,"Invalid Denomination");
	}

}
