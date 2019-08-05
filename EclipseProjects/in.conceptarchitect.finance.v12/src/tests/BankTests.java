/*
package tests;

import static org.junit.Assert.*;
import static org.junit.Assume.*;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.finance.Bank;


public class BankTests {

	Bank bank;
	double rate=12;

	int initalAccountCount;
	final String password="pass";
	final int initialAmount=1000;
	int a1,a2;


	@Before
	public void setup() {
		bank=new Bank("ICICI", rate);

		a1=bank.openAccount("A1", password, initialAmount);
		a2=bank.openAccount("A2", password, initialAmount);

		initalAccountCount=bank.getAccountCount(); //what is the total number of accounts present currently
	}

	@Test
	public void openAccount_createsAndAddsAccountToStore() {
		bank.openAccount("someone", "somepassword", 1);

		assertEquals(initalAccountCount+1, bank.getAccountCount());
	}

	@Test
	public void openAccount_returnsSequentialIds() {
		int id= bank.openAccount("someone", "somepassword", 1);
		int id2= bank.openAccount("someone else", "somepassword", 1);		
		//assertNotEquals(id, id2);

		assertEquals(id+1, id2);
	}


	@Test
	public void closeAccount_failsIfPasswordIsIncorrect() {

		//ARRANGED IN SETUP


		//ACT
		boolean result = bank.closeAccount(a1, "wrong-"+password);

		//ASSERT
		assertFalse(result);
	}

	@Test
	public void closeAccount_succeedsForActiveAccountAndCorrectPassword() {
		//ARRANGED IN SETUP


		//ACT
		boolean result=bank.closeAccount(a1, password);

		//ASSERT
		assertTrue(result);
		assertNull(bank.getAccount(a1, password)); //I shouldn't get closed account

	}

	@Test
	public void closeAccount_failsIfAccountIsAlreadyClosed() {
		//ARRANGE
		//int a1=11;

		boolean result=bank.closeAccount(a1, password); //should get closed here
		assumeTrue(result);
		//assertTrue(result);

		//ACT
		result=bank.closeAccount(a1, password); //shouldn't close now

		//ASSERT
		assertFalse(result);

	}

	void assertBalance(int accountNumber, double balance) {
		assertEquals(balance, bank.getAccount(accountNumber, password).getBalance(),0.01);
	}

	void assertBalanceUnchanged(int accountNumber) {
		assertBalance(accountNumber,initialAmount);
	}

	@Test
	public void transfer_failsForInvalidFromAccount() {
		//ACT

		boolean result=bank.transfer(11, 1, password, a1);

		//ASSERT 
		assertFalse(result);
		assertBalanceUnchanged(a1); //no money added to to account


	}
	@Test
	public void transfer_failsForInvalidToAccount() {

		//ACT
		boolean result=bank.transfer(a1, 100, password, 11);

		//ASSERT
		assertFalse(result);
		assertBalanceUnchanged(a1); //no money taken from account
	}
	@Test
	public void transfer_failsForClosedFromAccount() {

		//ARRANGE
		boolean result=bank.closeAccount(a1, password);

		assumeTrue(bank.getAccount(a1, password)==null);


		//ACT
		bank.transfer(a1, 1, password, a2);

		//ASSERT
		assertBalanceUnchanged(a2);

	}
	@Test
	public void transfer_failsForClosedToAccount() {
		//ARRANGE
		boolean result=bank.closeAccount(a2, password);

		assumeTrue(bank.getAccount(a2, password)==null); //a2 is closed
		assumeNotNull(bank.getAccount(a1, password) ); //a1 is active


		//ACT
		bank.transfer(a1, 1, password, a2);

		//ASSERT
		assertBalanceUnchanged(a1); //no money deducted from a1
	}
	@Test
	public void transfer_failsForInsufficientBalanceInFromAccount() {
		
		//ACT
		boolean result=bank.transfer(a1, initialAmount+1, password , a2);
		
		//ASSERT
		assertFalse(result); //transfer reports failure
		assertBalanceUnchanged(a1); //no money dedcuted from source
		assertBalanceUnchanged(a2); // no money added to target
	}
	@Test
	public void transfer_failsForInvalidFromPassword() {
		//ACT
		boolean result=bank.transfer(a1, 1, "wrong-"+password , a2);
		
		//ASSERT
		assertFalse(result); //transfer reports failure
		assertBalanceUnchanged(a1); //no money dedcuted from source
		assertBalanceUnchanged(a2); // no money added to target
	}
	@Test
	public void transfer_succeedsWithRightInput() {
		//ARRANGE
		int amount=100;
		
		//ACT
		boolean result=bank.transfer(a1, amount, password, a2);
		
		//ASSERT
		assertTrue(result);
		assertBalance(a1, initialAmount-amount);
		assertBalance(a2, initialAmount+amount);
		
				
				
	}

	@Test
	public void deposit_failsForClosedAccount() {

	}
	@Test
	public void deposit_failsForNegativeAmount() {

	}

	@Test
	public void deposit_failsForInvalidAccountNumber() {

	}

	@Test
	public void deposit_succeedsForValidAccountAndPassword() {

	}
	@Test
	public void withdraw_failsForInvalidAccountNumber() {

	}

	@Test
	public void withdraw_failsForClosedAccounts() {

	}





}
*/