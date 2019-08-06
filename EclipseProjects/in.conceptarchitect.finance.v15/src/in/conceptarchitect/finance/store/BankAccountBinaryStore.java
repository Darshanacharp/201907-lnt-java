package in.conceptarchitect.finance.store;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

import in.conceptarchitect.finance.AccountStatus;
import in.conceptarchitect.finance.AccountStore;
import in.conceptarchitect.finance.BankAccount;
import in.conceptarchitect.finance.InvalidAccountException;

public class BankAccountBinaryStore implements AccountStore,Serializable {

	int lastId=0;
	private HashMap<Integer, BankAccount> accounts=new HashMap<>();
	String path;
	
	public BankAccountBinaryStore(String path) {
		// TODO Auto-generated constructor stub
		this.path=path;
	}
	
	public static BankAccountBinaryStore load(String path) {
		
		FileInputStream file=null;
		ObjectInputStream o=null;
		try {
			file=new FileInputStream(path);
			o=new ObjectInputStream(file);
			BankAccountBinaryStore store=(BankAccountBinaryStore) o.readObject();
			store.path=path;
			return store;
		}catch(Exception ex) {
			//ex.printStackTrace();
			//dont worry
			System.out.println("creating a new store ...");
			return new BankAccountBinaryStore(path); //create an empty store
		}
		
		
	}

	@Override
	public int addAccount(BankAccount account) {
		int accountNumber=++lastId;
		account.setAccountNumber(accountNumber);
		//accounts.add(account);				//accounts[accountNumber]=account;
		accounts.put(accountNumber, account);
		update(null);
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
		//do nothing
		FileOutputStream file=null;
		ObjectOutputStream oos=null;
		
		try {
			file=new FileOutputStream(path);
			oos=new ObjectOutputStream(file);
			oos.writeObject(this);
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try{
				file.close();
				oos.close();
			}catch(Exception ex) {}
			
		}
		
	}
	
}
