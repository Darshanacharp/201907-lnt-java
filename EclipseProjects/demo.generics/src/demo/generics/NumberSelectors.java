package demo.generics;

public class NumberSelectors {

	public static boolean isEven(int number) {return number%2==0;}
	
	public static boolean isOdd(int number) {return number%2!=0;}
	
	public static boolean isDivisible(int number, int dr) {return number%dr==0;}
	
	public static boolean hasPerfectSquareRoot( int number) {
		
		double root= Math.sqrt(number);
		
		int iRoot=(int) root;
		
		return iRoot*iRoot==number;
		
	}
	
	
	
}
