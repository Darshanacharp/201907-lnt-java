package demo.exceptions;

public class RiskyObject {

	boolean tryEndReached;
	boolean functionEndReached;
	boolean catchExecuted;
	private boolean finallyExcecuted;
	
	public boolean isFinallyExcecuted() {
		return finallyExcecuted;
	}

	public boolean isTryEndReached() {
		return tryEndReached;
	}

	public boolean isFunctionEndReached() {
		return functionEndReached;
	}

	public boolean isCatchExecuted() {
		return catchExecuted;
	}



	public int execute(int index) {
		
		int []dr= {2,3,0,5};
		int value=10;
		int result=0;
		tryEndReached=false;
		catchExecuted=false;
		functionEndReached=false;
		finallyExcecuted=false;
		//index>3 will throw IndexOutOfBoundsException
		//index==2 will throw ArithemeticException

		try {
			result=value/dr[index];
			tryEndReached=true;
			System.out.println("try executed to the end");
		}
		catch(IndexOutOfBoundsException ex) {
			result=-1;
			catchExecuted=true;
			System.out.println("catch executed");
		}//ArithmeticException never caught in our code
		finally {
			System.out.println("finally executed");
			finallyExcecuted=true;
		}
		
		System.out.println("rest of the function executed");
		functionEndReached=true;
		return result;
	}
	
}
