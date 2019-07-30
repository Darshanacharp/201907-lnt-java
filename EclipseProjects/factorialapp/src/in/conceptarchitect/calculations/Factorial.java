package in.conceptarchitect.calculations;



public class Factorial {
	
	public int calculate(int number) {
		if(number<2)
			return 1;
		else
			return number * calculate(number-1);
	}

}
