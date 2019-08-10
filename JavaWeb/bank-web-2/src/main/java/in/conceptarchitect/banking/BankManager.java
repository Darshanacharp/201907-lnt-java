package in.conceptarchitect.banking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import in.conceptarchitect.finance.AccountStatus;
import in.conceptarchitect.finance.AccountStore;
import in.conceptarchitect.finance.Bank;
import in.conceptarchitect.finance.BankAccount;
import in.conceptarchitect.finance.store.BankAccountBinaryStore;

public class BankManager {
	final Bank bank;
	public Bank getBank() {
		return bank;
	}

	public static final BankManager instance=new BankManager();
	private AccountStore store;
	private BankManager() {
		String path= "C:\\MyWorks\\Corporate\\201907-lnt-java\\accounts.db";
		store=BankAccountBinaryStore.load(path);
		bank=new Bank("ICICI",12,store);
	}
	
	public List<BankAccount> getAllAccounts(){
		final ArrayList<BankAccount> accounts=new ArrayList<>();
		bank.processAccounts(accounts::add);
		return accounts;
	}
	
	public List<String> getAccountTypes(){
		return Arrays.asList("Savings Account","Current Account","Overdraft Account");
	}
	
	public void changeAccountStatus(final int accountNumber, final AccountStatus status) {
		bank.processAccounts(a-> {
			if (a.getAccountNumber()==accountNumber)
				a.setStatus(status);
		});
		
		store.update( null);
		
	}
	
	
	
}
