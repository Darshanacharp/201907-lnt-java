package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.finance.BankAccount;
import in.conceptarchitect.finance.InsufficientBalanceException;
import in.conceptarchitect.finance.InvalidCredentialsException;
import in.conceptarchitect.finance.InvalidDenominationException;
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
	public void withdraw_throwsInvalidCredentialException_forInvalidPassword() {
		try {
			account.withdraw(1, "wrong-password");	
			//Something went wrong!
			//I was exception an exception
			//An If I am here that means exception was not thrown
			fail("Excpected Exception Never Thrown");
		}catch(InvalidCredentialsException ex) {
			//ALL IS WELL: TEST PASSED
			//I MAY RUN ADDITIONAL ASSERT HERE
			assertBalanceUnchanged();
		}
		
		
	}
	
	@Test(expected = InvalidDenominationException.class)
	public void withdraw_throwsInvalidDenominationException_forNegativeAmount() {
	
		//This step throws exception
		account.withdraw(-1, password);
		
		//This code is never executed
		assertBalance(0); //this is wrong assertion. but will not be called
	}
	@Test
	public void getMinBalance_shouldReturn5000() {
		assertEquals(5000, account.getMinBalance());
	}
	
	@Test(expected = InsufficientBalanceException.class)
	public void withdraw_failsIfMinimumBalanceIsNotMaintained() {
		int minBalance=account.getMinBalance();
		account.withdraw(amount-minBalance+1, password);
	}
	
	@Test
	public void withdraw_succeedsWithProperInput() {
		int minBalance=account.getMinBalance();
		account.withdraw(100, password);
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
