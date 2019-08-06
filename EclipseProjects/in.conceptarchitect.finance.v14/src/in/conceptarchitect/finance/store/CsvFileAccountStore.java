package in.conceptarchitect.finance.store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;

import in.conceptarchitect.finance.AccountStatus;
import in.conceptarchitect.finance.AccountStore;
import in.conceptarchitect.finance.BankAccount;
import in.conceptarchitect.finance.BankAccountParser;
import in.conceptarchitect.finance.InvalidAccountException;

public class CsvFileAccountStore implements AccountStore {

	int lastId=0;
	private HashMap<Integer, BankAccount> accounts=new HashMap<>();
	String path;
	BankAccountParser parser;
	
	
	public CsvFileAccountStore(String path, BankAccountParser parser) {
		
		this.path = path;
		this.parser=parser;
		loadAccounts();
		
	}
	
	private void  loadAccounts() {
		
		BufferedReader reader=null;
		try {
			reader=new BufferedReader(new FileReader(path));
			lastId= Integer.parseInt(reader.readLine());
			while(true) {
				String line=reader.readLine();
				if(line==null)
					break;
				
				BankAccount account= parser.parse(line);
				accounts.put(account.getAccountNumber(), account);
			}
		} catch (IOException e) {
			// ITS OK. File may not be present			
		}finally {
			
			try{reader.close();}
			catch(IOException ex) {}
		}
		
	}

	@Override
	public int addAccount(BankAccount account) {
		int accountNumber=++lastId;
		account.setAccountNumber(accountNumber);
		//accounts.add(account);				//accounts[accountNumber]=account;
		accounts.put(accountNumber, account);
		update(account);
		return accountNumber;
	}
	
	@Override
	public BankAccount findAccount(int accountNumber) {
		
		if(accounts.containsKey(accountNumber))
			return accounts.get(accountNumber);
		
		throw new InvalidAccountException(accountNumber,"Invalid Account");
	}
	@Override
	public Collection<BankAccount> getAccounts() {
		// TODO Auto-generated method stub
//		ArrayList<BankAccount> temp=new ArrayList<>();
//		for(int i=1;i<accounts.size();i++)
//			temp.add(accounts.get(i));
//		
//		return temp;
		return accounts.values();
			
	}
	@Override
	public void removeAccount(BankAccount account) {
		//accounts.remove(account);
		accounts.remove(account.getAccountNumber());
		update(null);
	}
	@Override
	public BankAccount findActiveAccount(int accountNumber) {

		BankAccount a = findAccount(accountNumber);

		if(a.getStatus()!=AccountStatus.ACTIVE)
			throw new InvalidAccountException(accountNumber,"Account Has Been Closed");

		return a;
	}
	@Override
	public int getCount() {
		return accounts.size();
	}

	@Override
	public void update(BankAccount account) {
		//same all the accounts. Not just one
		PrintWriter writer=null;
		try {
			//Create a PrintWriter with FileWriter
			writer=new PrintWriter(path);
			writer.println(lastId);
			for(BankAccount a : accounts.values()) {				
//				String str=String.format("%d,%s,%s,%f", a.getAccountNumber(), a.getName(),"1234", a.getBalance());
//				writer.println(str);	
				writer.println(a.toCsvString());
				
			}
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		finally {
			writer.close();
		}
		
		
	}
	
}
