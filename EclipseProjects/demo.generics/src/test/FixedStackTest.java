package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import demo.generics.FixedStack;
import demo.generics.Stack;

public class FixedStackTest {

	final static int STACK_SIZE=3;
	
	
	
	@Test
	public void push_canPushDesiredTypeOnly() {
		Stack<String> stack=new FixedStack<String>(STACK_SIZE);
		stack.push("hello");
		//stack.push(29); //error detected early
		stack.push("hi");
		assertEquals(2, stack.size());
	}
	
	@Test
	public void pop__knowsDataBeingPopped() {
		Stack<String> stack=new FixedStack<>(STACK_SIZE);
		stack.push("india");
		stack.push("usa");
		stack.push("france");
		
		int total=0;
		
		while(!stack.isEmpty()) {
			
			total+=stack.pop().length(); //no typecasting needed
		}
		
		assertEquals(14,total);
	}
	
	@Test
	public void stack_doesntKnowDataBeingPushedOrPopped() {
		Stack<String> stack=new FixedStack<String>(3);
		
		stack.push("india");
		//expected to push only strings
		//stack.push(new ArrayList<String>()); //invalid push not allowed
		stack.push("france");
		
		int total=0;
		
		while(!stack.isEmpty()) {
			//No type casting error will be thrown
			String s= stack.pop(); //2. No need to typecast
			total+=s.length();
		}
		
		assertEquals(11,total);
	}
	
	@Test
	public void new_stackWithoutGenericTypeDefaultsToStackOfObject() {
		Stack stack=new FixedStack(3); //same as new FixedStack<Object>(3)
		
		stack.push("india");
		stack.push(new ArrayList<String>());
		stack.push(44);
		
		assertEquals(3, stack.size());
		
		
	}
	
	@Test
	public void new_stackShoudHaveExplicitTypeSpecialization() {
		Stack<Object> stack=new FixedStack<Object>(3); //same as new FixedStack<Object>(3)
		
		stack.push("india");
		stack.push(new ArrayList<String>());
		stack.push(44);
		
		assertEquals(3, stack.size());
		
		
	}
	
	@Test
	public void new_cantUsePrimitiveTypesAsGenericParameter() {
		//FixedStack<int> stack=new FixedStack<int>(3);
	}
	
	@Test
	public void new_canUseWrapperForPrimitiveTypeAsGenericParameter() {
		Stack<Integer> values=new FixedStack<>(4);
		
		values.push(1); //auto boxed to values.push(new Integer(1))
		values.push(2);
		values.push(3);
		values.push(4);
		
		int sum=0;
		while(!values.isEmpty())
			sum+= values.pop(); //auto-unboxed to values.pop().intValue()
		
		assertEquals(10, sum);
		
	}
	
	
	
}


















