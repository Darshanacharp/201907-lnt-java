package in.conceptarchitect.finance;

public class BankingException extends Exception {
	
	int accountNumber;
	
	public BankingException(int accountNumber, String message) {
		super(message);
		this.accountNumber=accountNumber;
	}
	
	public BankingException(int accountNumber) {
		this(accountNumber,"Banking Exception");
	}

	public int getAccountNumber() {
		return accountNumber;
	}

}
