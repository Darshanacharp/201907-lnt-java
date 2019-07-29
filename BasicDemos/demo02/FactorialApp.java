class App{

	public static void main(String [] args){
		int x=5;
		int fx=factorial(5);

		System.out.println("Factorial of "+x+" is "+fx);
	}

	static int factorial(int n){
		int fn=1;
		while(n>0)
			fn*=n--;

		return fn;
	}
}