package demo.testing;


import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.Before;

import jdk.jfr.SettingDefinition;

public class SimpleMathTests {
	
	SimpleMath m;
	int x,y;
	
	@Before
	public void arrange() {
		m=new SimpleMath();
		x=50;
		y=15;
		System.out.println("before called");
	}
	

	@Test
	public void testPlus() {

		
		int result=m.plus(x, y);
		
		System.out.println("plus "+result);
		assertEquals(x+y, result);
	}
	
	@Test
	public void testMinus() {
		int result=m.minus(x, y);		
		System.out.println("minus "+result);
		assertEquals(x-y, result);
	}
	
	@Test
	public void testMultiply() {
		
		int result=m.multiply(x, y);
		System.out.println("multiply "+result);
		assertEquals(x*y, result);
	}
	
	@Test
	public void testDivide() {
		int result=m.divide(x, y);
		System.out.println("divide "+result);
		assertEquals(x/y, result);
	}
}
