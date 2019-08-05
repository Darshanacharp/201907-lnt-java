package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import demo.exceptions.RiskyObject;

public class RiskyObjectTest {

	RiskyObject ro;
	
	@Before
	public void setUp() throws Exception {
		ro=new RiskyObject();
	}

	@Test
	public void happyPathTest() {
		int result= ro.execute(0);
		assertEquals(5, result);
		
		assertTrue(ro.isTryEndReached());
		assertFalse(ro.isCatchExecuted());
		assertTrue(ro.isFunctionEndReached());
		assertTrue(ro.isFinallyExcecuted());
	}
	
	@Test
	public void caughtException_IndexOutOfRangeExceptionDoesntPropagate() {
	
		int result=ro.execute(10);
		//we should reach here
		assertEquals(-1,result);
		
		assertFalse(ro.isTryEndReached());
		assertTrue(ro.isCatchExecuted());
		assertTrue(ro.isFunctionEndReached());
		assertTrue(ro.isFinallyExcecuted());
	}
	
	@Test(expected = ArithmeticException.class)
	public void unCaughtException_ArithmeticException_Propagates() {
		ro.execute(2); //should throw Arithemtic Exception
	}

	@Test
	public void unCaughtException_byPass_TryAndFunctionEnd() {
		
		try {
			ro.execute(2);
		}
		catch(ArithmeticException ex) {
			
		}
		
		assertFalse(ro.isTryEndReached());
		assertFalse(ro.isFunctionEndReached());
		assertFalse(ro.isCatchExecuted());
		assertTrue(ro.isFinallyExcecuted());
		
		
	}
	
	
	
	
}
