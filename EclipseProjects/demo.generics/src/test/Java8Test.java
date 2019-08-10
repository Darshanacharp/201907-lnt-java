package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

import org.junit.Before;
import org.junit.Test;

import demo.generics.FixedStack;
import demo.generics.Stack;

public class Java8Test {

	Stack<Integer> stack;
	
	@Before
	public void setup() {
		stack= Stack.createDynamicStack(2,3,9,11);
		
		stack.pushMany(10,20,30);
	}
	
	@Test
	public void stack_has7Items() {
		assertEquals(7, stack.size());
	}
	
	@Test
	public void clear_emptiesStack() {
		assumeFalse(stack.isEmpty());
		
		stack.clear();
		
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void clear_doesntClearFixedStack() {
		var fs=new FixedStack<Integer>(5);
		
		fs.pushMany(1,2,3,4);
		
		assertEquals(4, fs.size());
		
		fs.clear();
		
		//clear shouldn't clear
		assertEquals(4,fs.size());
		
		
		
	}
	
}
