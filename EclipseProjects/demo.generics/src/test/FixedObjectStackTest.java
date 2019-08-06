package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import demo.generics.FixedObjectStack;

public class FixedObjectStackTest {

	final static int STACK_SIZE=3;
	FixedObjectStack stack=new FixedObjectStack(STACK_SIZE);
	
	@Test
	public void pop_popsLIFO() {
		
		stack.push("hello");
		stack.push(29);
		stack.push(new ArrayList<String>());
		
		assertTrue(stack.pop() instanceof ArrayList);
		assertEquals(29, stack.pop());
		assertEquals("hello",stack.pop());
		
	}
	
	@Test
	public void push_canPushAnyType() {
		stack.push("hello");
		stack.push(29);
		assertEquals(2, stack.size());
	}
	
	@Test
	public void pop_problem_doesntKnowDataBeingPopped() {
		stack.push("india");
		stack.push("usa");
		stack.push("france");
		
		int total=0;
		
		while(!stack.isEmpty()) {
			String s=(String) stack.pop(); //2. FORCED TYPECAST
			total+=s.length();
		}
		
		assertEquals(14,total);
	}
	
	@Test
	public void stack_doesntKnowDataBeingPushedOrPopped() {
		stack.push("india");
		//expected to push only strings
		stack.push(new ArrayList<String>()); //not a string but pushed
		stack.push("france");
		
		int total=0;
		
		while(!stack.isEmpty()) {
			//THIS TYPECAST MAY THROW EXCEPTION
			String s=(String) stack.pop(); //2. FORCED TYPECAST
			total+=s.length();
		}
		
		assertEquals(14,total);
	}
	
	
	
}
