package test;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

import org.junit.Before;
import org.junit.Test;

import demo.generics.FixedIntStack;
import demo.generics.StackOverFlowException;
import demo.generics.StackUnderFlowException;

public class StackTest {

	final static int STACK_SIZE=3;
	FixedIntStack stack=new FixedIntStack(STACK_SIZE);
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void new_stackIsEmpty() {
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void push_makesStackNonEmpty() {
		stack.push(1);
		assertFalse(stack.isEmpty());
	}
	
	@Test
	public void push_equalToStackSizeTimesMakesItFull() {
		for(int i=0;i<STACK_SIZE;i++)
			stack.push(i);
		
		assertTrue(stack.isFull());
	}
	
	@Test(expected = StackOverFlowException.class)
	public void push_toAFullStackThrowsStackOverFlowException() {
		for(int i=0;i<STACK_SIZE;i++)
			stack.push(i);
		
		assumeTrue(stack.isFull());
		
		stack.push(1);
	}

	
	@Test(expected = StackUnderFlowException.class)
	public void pop_fromAnEmptyStackThrowsStackUnderFlowException() {
		stack.pop();
	}
	
	@Test
	public void pop_lastItemMakesStackEmpty() {
		stack.push(1);
		assumeFalse(stack.isEmpty());
		
		stack.pop();
		
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void pop_popsInLIFO() {
		int []values= {2,5,9};
		
		for(int value: values) 
			stack.push(value);
		
		for(int i=STACK_SIZE-1; i>=0;i--) 
			assertEquals(values[i], stack.pop());
		
		
	}
	
	
	
	
	
}
