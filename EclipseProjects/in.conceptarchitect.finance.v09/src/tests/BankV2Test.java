package tests;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.finance.Bank;

public class BankV2Test {

	Bank bank;
	String password="p@ss";
	double amount=10000;
	int minBalance=5000;
	
	@Before
	public void setup() {
		bank=new Bank("ICICI",12);
	}
	
	@Test
	public void openSavingsAccount_opensASavingAccount() {
		int a1= bank.openSavingsAccount("Vivek",password,amount);
		
		assertEquals("SavingsAccount", bank.getAccount(a1, password).getAccountType());
	}
	
	@Test
	public void openCurrentAccount_opensACurrentAccount() {
		int a1= bank.openCurrentAccount("Vivek",password,amount);
		
		assertEquals("CurrentAccount", bank.getAccount(a1, password).getAccountType());
	}
	
	@Test
	public void openOverdraftAccount_opensAnOverdraftAccount() {
		int a1= bank.openOverdraftAccount("Vivek",password,amount);
		assertEquals("OverdraftAccount", bank.getAccount(a1, password).getAccountType());
	}
	
	void assertBalance(int accountNumber, double expectedBalance ) {
		assertEquals(expectedBalance, bank.getAccount(accountNumber, password).getBalance(), 0.01);
	}
	
	void assertBalanceUnchanged(int accountNumber) {
		assertBalance(accountNumber,amount);
	}
	
	@Test
	public void withdraw_failsForSavingsAccountIfMinBalanceIsNotMaintainted() {
		//ARRANGE
		int a1= bank.openSavingsAccount("some name", password, amount);
		
		assumeTrue(bank.getAccount(a1, password).getAccountType().equals("SavingsAccount"));
		
		
		assertFalse(bank.withdraw(a1, amount - minBalance + 1, password));
		
		assertBalanceUnchanged(a1);
		
		
	}
	
	@Test
	public void creditInterest_SavingsAccountGetInterest() {
		int a1=bank.openSavingsAccount("some name", password, amount);
		
		bank.creditInterest();
		
		double expectedBalance = amount*1.01;
		
		assertBalance(a1, expectedBalance);
		
	}
	
	
	@Test
	public void withdraw_canWithdrawEntireAmountFromCurrentAccount() {
		//ARRANGE
		int a1= bank.openCurrentAccount("some name", password, amount);
		
		assumeTrue(bank.getAccount(a1, password).getAccountType().equals("SavingsAccount"));
		
		
		assertTrue(bank.withdraw(a1, amount, password));
		
		assertBalanceUnchanged(0);
		
		
	}
	
	@Test
	public void creditInterest_doesntCreditInterestToCurrentAccount() {
		int a1=bank.openCurrentAccount("some name", password, amount);
		
		bank.creditInterest();
		
		
		
		assertBalanceUnchanged(a1);
		
	}
	
	@Test
	public void withdraw_canWithdrawMoreThanBalanceFromOverdraftAccount() {
		//ARRANGE
		int a1= bank.openOverdraftAccount("some name", password, amount);
		
		double od= 1000;
		
		double withdrawAmount= amount+od;
		
		double odCharge= od/10;
		
		double expectedBalance= -od-odCharge;
		
		 	
		
		
		assertTrue(bank.withdraw(a1, withdrawAmount, password));
		
		assertBalance(a1, expectedBalance);
		
		
	}
	
	@Test
	public void creditInterest_addsInterestToOverdraftAccount() {
		int a1=bank.openOverdraftAccount("some name", password, amount);
		
		bank.creditInterest();
		
		double expectedBalance = amount*1.01;
		
		assertBalance(a1, expectedBalance);
		
	}
	
	@Test
	public void odLimit_shouldBe10PercentOfHistoricMaxBalance() {
		//ARRANGE
		int a1= bank.openOverdraftAccount("some name", password, amount);
		
		//od is now 10% of amount
		
		bank.deposit(a1, amount); //now the balance is 2*amount odLimit is 20% of amount
		
		
		
		bank.withdraw( a1, amount,password); //balance= amount. but od Limit is still 20% of amount

		
		
		//I should be able to withdraw 15% of amount as od
		double od= amount*0.15;
		
		double withdrawAmount= amount+od;
		
		double odCharge= od/10;
		
		double finalBalance= -od -odCharge;
		
		//assertTrue(bank.withdraw(a1, withdrawAmount, password));
		
		assertBalance(a1, finalBalance);
		
	}
	
	

}
