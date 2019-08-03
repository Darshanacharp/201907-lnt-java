package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SavingsAccountSpec {
	
	SavingsAccount account;
	String name="Some Name";
	String password="pass";
	int amount=10000;

	@Before
	public void setup() {
		account=new SavingsAccount(1,name,password,amount);
	}
	
	void assertBalance(int amount) {
		assertEquals(amount, account.getBalance(),0.01);
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
	
	}
	
	@Test
	public void withdraw_failsIfMinimumBalanceIsNotMaintained() {
	
	}
	
	@Test
	public void withdraw_succeedsWithProperInput() {
	
	}
	
	@Test
	public void creditInterest_creditsInterest() {
	
	}
	
	@Test
	public void object_isATypeOfBankAccount() {
	
	}
	
	
	
}
