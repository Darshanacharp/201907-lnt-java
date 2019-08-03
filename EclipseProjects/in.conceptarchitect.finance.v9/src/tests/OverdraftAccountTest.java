package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.finance.OverdraftAccount;

public class OverdraftAccountTest {

	OverdraftAccount account;
	String password="p@ss";
	double amount=10000;
	
	
	@Before
	public void setUp() throws Exception {
		account=new OverdraftAccount(1, "name", password, amount);
	}

	@Test
	public void odLimit_shouldBe10PercentOfInitialDeposit() {
		assertEquals(amount/10, account.getOdLimit(),0.01);
	}
	
	@Test
	public void deposit_shouldUpdateOdLimitIfWePassHistoricMaxBalance() {
		account.deposit(amount); //now balance is 2*amount, odLimit should be 20% of amount
		
		assertEquals(0.2*amount, account.getOdLimit(),0.01);
		
		account.deposit(amount); //now balance is 3*amount, odLimit should be 30% of amount
		
		assertEquals(0.3* amount, account.getOdLimit(),0.01);
	}
	
	@Test
	public void deposit_shouldNotUpdateOdLimitIfDontPassHistoricMaxBalance() {
		
		account.deposit(amount); //historic max is breached. 
		double newOdLimit = account.getOdLimit();
		assertEquals(0.2*amount, newOdLimit,0.01);
		
		account.withdraw(2*amount,password); //now the balance is 0
		
		account.deposit(amount/2); //histroic balance of 2*amount is reached. odLimit doesn't change
		
		assertEquals(newOdLimit, account.getOdLimit(),0.01);
		
	}
	
	@Test
	public void withdraw_shouldNotUpdateOdLimit() {
		double odLimit=account.getOdLimit();
		
		account.withdraw(1000, password);
		
		assertEquals(odLimit, account.getOdLimit(),0.01);
		
		
	}
	
	@Test
	public void creditInterest_shouldUpdateOdLimitIfWePassHistoricMaxBalance() {
		
	}
	
	@Test
	public void creditInterest_shouldNotUpdateOdLimitIfWeDontPassHistoricMaxBalance() {
		
	}
	
	
	

}
