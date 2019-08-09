package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import demo.generics.EvenNumberSelector;
import demo.generics.ListUtils;
import demo.generics.NumberSelectors;
import demo.generics.Selector;

public class ListUtilsTest{

	ListUtils utils=new ListUtils();
	List<Integer> numbers;
	List<String> names;

		
	
	
	@Before
	public void setup(){
		numbers=Arrays.asList( new Integer[] {2,3,1,35,9,4,5,7,49,8,2,17,61,15,52,25,44,33,37} );
		
		names=Arrays.asList(new String [] {"India","USA","UK","UAE","Japan","France","China","Norway"});
	}

	
	@Test
	public void copyToArray_copiesAnyListToArray()
	{
		String [] sArray= {"one","two","three"};
		
		List<String> sList= new ArrayList<>();
		
		sList.add("one");
		sList.add("two");
		sList.add("three");
		
		
		String [] csArray= new String[3];
		utils.copyToArray(sList, csArray);
		
		assertArrayEquals(sArray, csArray);
	
		
		Integer [] iArray= {1,2,3};
		
		List<Integer> iList=new ArrayList<>();
		iList.add(1);
		iList.add(2);
		iList.add(3);
		
		Integer [] ciArray=new Integer[3];
		
		utils.copyToArray(iList, ciArray);
		
		assertArrayEquals(iArray, ciArray);
		
		
		
		
	}
	
	
	
	@Test
	public void search_canCreateAListOfEvenNumbers(){
		//act use utils class search to search it
		List<Integer> evens=
			utils.search(numbers, 
			new EvenNumberSelector());

		assertEquals(6, evens.size());
	}

	class MinStringLengthSelector implements Selector<String>{
		int min;
		public  MinStringLengthSelector(int min) {
			// TODO Auto-generated constructor stub
			this.min=min;
		}

		@Override
		public boolean selects(String value) {
			// TODO Auto-generated method stub
			return value.length()>= min;
		}
		
	}
	
	@Test
	public void search_canSearchAllNamesWhoseLengthIsGreaterThan3(){
		//List<String> result= utils.searchMinStringLength(names,4);
		
		List<String> result= utils.search(names, new MinStringLengthSelector(4));
		
		assertEquals(5, result.size());
	}
	
	@Test
	public void search_canFindNamesWhichAreAllUpperCaps(){
		
		Selector<String> upperCaseSelector = new Selector<String>() {
			
			public boolean selects(String value) {
				// TODO Auto-generated method stub
				return value.toUpperCase().equals(value);
			}			
		};
		
		
		//List<String> result=utils.searchForUpperCaseWords(names);
		
		List<String> result= utils.search(names, upperCaseSelector);
		

		//compare result with exact values
		String expected[]= {"USA","UK","UAE"};
		
		String actual [] = result.toArray( new String[0]);
		
		
		assertArrayEquals(expected, actual);
		
		//assertEquals(3, result.size());
	}
	
	
	@Test
	public void search_canSearchEvenNumbersGreaterThan10() {
		
		Selector<Integer> s= new Selector<Integer>() {
			
			public boolean selects(Integer number) {
				return number>10 && number%2==0;
			}
			
		};
		
		
		Selector<Integer> s2 = number -> {
			return number>10 && number%2==0;
		};
		
		Selector<Integer> s3 =  number -> number>10 &&number%2==0;
		
		
		
		List<Integer> result= utils.search(numbers,s3);
		
		assertEquals(2, result.size());
		assertEquals(52, (int)result.get(0));
		assertEquals(44, (int)result.get(1));
		
	}
	
	
	@Test
	public void search_canSearchPrimes() {
		Selector<Integer> primes =  number ->{
			if(number<2) return false;
			for(int i=2;i<number;i++)
				if (number%i==0) return false;
			
			return true;
		};
		
		List<Integer> result= utils.search(numbers, primes);
		
		assertEquals(8, result.size());
	}
	
	@Test
	public void search_canSearchMulitplesOf5() {
		
		List<Integer> result= utils.search(numbers, number-> number%5==0);
		
		assertEquals(4, result.size());
	}
	
	
	@Test
	public void search_canSearchNumbersWithPerfectSquareRoot() {
		
		//List<Integer> result= utils.search(numbers, n-> NumberSelectors.hasPerfectSquareRoot(n));
		
		List<Integer> result = utils.search(numbers, NumberSelectors::hasPerfectSquareRoot);
		
		
		
		assertEquals(5, result.size());
		assertEquals(1, (int) result.get(0));
		assertEquals(4, (int) result.get(2));
		assertEquals(9, (int) result.get(1));
		assertEquals(49, (int) result.get(3));
		assertEquals(25, (int) result.get(4));
		
	}
	

	@Test
	public void search_canSearchDivibleBy3Numbers() {
		
		List<Integer> result=utils.search(numbers, n->NumberSelectors.isDivisible(n, 3) );
		
		assertEquals(4, result.size());
		
	}
	
	
	
	
	@Test
	public void convert_canConvertListOfStringToListOfIntegerContainingItsLength(){

		List<String> inputValues=Arrays.asList("India","USA","France");
		
		List<Integer> result= utils.convert(inputValues, s->s.length()); 
		
		Integer [] expectedArray= {5,3,6};
		
		Integer [] actualArray= result.toArray(new Integer[0]);
		
		assertArrayEquals(expectedArray, actualArray);
		
		

		//do necessary asserts
	}	
	@Ignore @Test	
	public void convert_canReturnAListOfNumbersContainingUnitPlaceDigitOfEachNumber(){

		//test data
		List<Integer> values= Arrays.asList(29,43,86,19,25 );
		
		Integer [] expected= {9,3,6,9,5};
		
		List<Integer> output= utils.convert(values, value->value%10);

		Integer [] actual= output.toArray(new Integer[0]);
		 
		assertArrayEquals(expected, actual);
	}	
	 @Test
	public void process_canSumAllTheNumbersOfAList() {
		
		List<Integer> list= Arrays.asList(1,2,3,4);
		
		final int []sum= {0}; 
	
		utils.process(list, value ->{
			sum[0]+=value;
		});
		
		
		assertEquals(10, sum[0]);
		
	}
	 
	 
	@Test
	public void convert_canConvertAListOfNumberToItsSquareRoot() {
		
		List<Double> values=Arrays.asList(1.0,4.0,16.0,25.0);
		
		List<Double> result= utils.convert(values, Math::sqrt);
		
		utils.process(result, System.out::println);
		
		
		
		
		
	}



	







}