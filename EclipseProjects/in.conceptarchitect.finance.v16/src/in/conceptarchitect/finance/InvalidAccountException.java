package in.conceptarchitect.finance;

public class InvalidAccountException extends BankingException {

	public InvalidAccountException(int accountNumber, String message) {
		super(accountNumber, message);
		// TODO Auto-generated constructor stub
	}

	public InvalidAccountException(int accountNumber) {
		super(accountNumber,"Invalid Account Number "+accountNumber);
		// TODO Auto-generated constructor stub
	}

}
