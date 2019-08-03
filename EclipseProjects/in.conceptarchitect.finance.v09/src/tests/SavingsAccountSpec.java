package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.finance.BankAccount;
import in.conceptarchitect.finance.SavingsAccount;

public class SavingsAccountSpec {
	
	SavingsAccount account;
	String name="Some Name";
	String password="pass";
	int amount=10000;

	@Before
	public void setup() {
		account=new SavingsAccount(1,name,password,amount);
	}
	
	void assertBalance(double expectedBalance) {
		assertEquals(expectedBalance, account.getBalance(),0.01);
	}
	
	void assertBalanceUnchanged() {
		assertBalance(amount);
	}

	
	@Test
	public void new_canCreateSavingsAccount() {
		
		assertNotNull(account);
	}
	
	@Test
	public void withdraw_failsForInvalidPassword() {
		boolean result=account.withdraw(1, "wrong-password");
		
		assertFalse(result);
		assertBalanceUnchanged();
	}
	
	@Test
	public void withdraw_failsForNegativeAmount() {
	
		boolean result=account.withdraw(-1, password);
		
		assertFalse(result);
		assertBalanceUnchanged();
	}
	@Test
	public void getMinBalance_shouldReturn5000() {
		assertEquals(5000, account.getMinBalance());
	}
	
	@Test
	public void withdraw_failsIfMinimumBalanceIsNotMaintained() {
		int minBalance=account.getMinBalance();
		boolean result=account.withdraw(amount-minBalance+1, password);
		
		assertFalse(result);
		assertBalanceUnchanged();
		
	}
	
	@Test
	public void withdraw_succeedsWithProperInput() {
		int minBalance=account.getMinBalance();
		boolean result=account.withdraw(100, password);
		
		assertTrue(result);
		assertBalance(amount-100);
	}
	
	@Test
	public void creditInterest_creditsInterest() {
		double rate=12;
		account.creditInterest(rate);
		double expectedBalance= amount*1.01;
		
		assertBalance(expectedBalance);
	}
	
	@Test
	public void object_isATypeOfBankAccount() {
	
		assertTrue(account instanceof BankAccount);
	}
	
	
	
}
