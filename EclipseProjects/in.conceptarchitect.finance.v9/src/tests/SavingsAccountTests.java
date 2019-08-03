package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.finance.AccountStatus;
import in.conceptarchitect.finance.BankAccount;
import in.conceptarchitect.finance.SavingsAccount;

public class SavingsAccountTests {
	static final String correctPassword="p@ss";
	static final int initialBalance=10000;
	static final String firstName="Vivek", lastName="Mishra";
	static final String name=firstName+" "+lastName;
	
	
	BankAccount account;
	
	
	void assertBalanceShouldBe(double expected) {
		assertEquals(expected, account.getBalance(),0.02);
	}
	
	void assertBalanceShouldRemainUnchanged() {
		assertBalanceShouldBe(initialBalance);
	}
	
	@Before
	public void setup() {
		account=new SavingsAccount(0, name,correctPassword,initialBalance);
	}
	
	@Test
	public void deposit_shouldAcceptPostiveNumber() {
		
		int amount=100;		
		//ACT
		account.deposit(amount);		

		//ASSERT
		assertBalanceShouldBe(initialBalance+amount);
		
		
		//assertEquals(true, result);
		//assertTrue(result);
		//assertEquals(initialBalance+amount, account.getBalance(),0);
		
	}
	
	@Test
	public void deposit_shouldFailForNegativeAmount() {
		
		boolean result=account.deposit(-100);
		
		//balance shouldn't change
		assertBalanceShouldRemainUnchanged();
	}

	
	@Test
	public void withdraw_shouldFailForNegativeAmount() {
		
		account.withdraw(-1, correctPassword);
		
		assertBalanceShouldRemainUnchanged();
	}
	
	@Test
	public void withdraw_shouldFailForAmountGreterThanBalance() {
		
		account.withdraw(initialBalance+ 1 , correctPassword );
		
		assertBalanceShouldRemainUnchanged();
		
	}
	
	@Test
	public void withdraw_shouldFailForInvalidPassword() {
		account.withdraw(1, "wrong-password");
		
		assertBalanceShouldRemainUnchanged();
	}
	
	@Test
	public void withdraw_shouldSucceedForValidPasswordAndAmount() {
		
		int amount=1;
		account.withdraw(amount, correctPassword);
		
		assertBalanceShouldBe(initialBalance-amount);
	}
	
//	@Test
//	public void withdraw_canWithdrawEntireAmount() {
//		account.withdraw(initialBalance, correctPassword);
//		
//		assertBalanceShouldBe(0);
//		
//	}
	
	@Test
	public void withdraw_failsOnClosedAccount() {
		account.setStatus(AccountStatus.CLOSED);
		
		boolean result= account.withdraw(1, correctPassword);
		
		assertFalse(result);
		assertBalanceShouldRemainUnchanged();
	}
	
	
	@Test
	public void creditInterest_shouldCredit1MonthInterest() {
		double rate=12;
		double expected= 1.01 * initialBalance;
		
		account.creditInterest(rate);
		
		assertBalanceShouldBe(expected);
		
	}
	
	
	@Test
	public void authenticate_shouldReturnFalseForWrongPassword() {
		assertFalse(account.authenticate("wrong-password"));
	}
	
	@Test
	public void authenticate_shouldReturnTrueForRightPassword() {
		assertTrue(account.authenticate(correctPassword));
	}
	
	@Test
	public void changePassword_shouldFailIfWrongPasswordIsUsedAsFirstParameter() {
		String newPassword="new-password";
		
		account.changePassword("wrong-password", newPassword);
		
		assertFalse(account.authenticate(newPassword));
		
	}
	
	@Test
	public void changePassword_shouldSucceedWithCorrectPasswordAsFirstParameter() {
		String newPassword="new-password";
		account.changePassword(correctPassword, newPassword);
		
		assertTrue(account.authenticate(newPassword));
	}
	
	
	@Test
	public void setName_rejectsNewNameIfLastNameDoesntMatch() {
		String newName="Vivek WrongLastName";
		
		account.setName(newName);
		
		assertEquals(name, account.getName());
	}
	
	@Test
	public void setName_acceptsNewNameWithSameLastName() {
		String newName="Someone "+lastName;
		
		account.setName(newName);
		
		assertEquals(newName, account.getName());
	}
	
	
	
	// test withdraw use cases
	// test credit interest use cases
	// test setName use cases --> while changing the name last name should be same
	// test authenticate use cases
	// test changePassword use cases
	
	
	
	
	
	
	
	
}
