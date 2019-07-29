
class Math{
	static int factorial(int n){
		int fn=1;
		while(n>0)
			fn*=n--;

		return fn;
	}
}