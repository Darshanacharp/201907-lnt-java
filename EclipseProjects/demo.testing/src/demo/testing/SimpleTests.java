package demo.testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleTests {

	@Test
	public void test1() {
		System.out.println("I am test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("I am test 2");
	}
	
	public void test3() {
		System.out.println("I am Test 3");
	}
	
	@Test
	public void notATest() {
		System.out.println("I am Not a Test");
	}

}
