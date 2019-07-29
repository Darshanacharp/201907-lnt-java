class FactorialApp{
	public static void main(String [] args){
		int x=5;
		int fx=Math.factorial(5);

		System.out.println("Factorial of "+x+" is "+fx);
	}
}
class Math{
	static int factorial(int n){
		int fn=1;
		while(n>0)
			fn*=n--;

		return fn;
	}
}