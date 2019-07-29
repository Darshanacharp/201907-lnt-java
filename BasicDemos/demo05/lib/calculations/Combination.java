class Combination{

	static int calculate(int n,int r){
		return 	Math.factorial(n)/
		 	Math.factorial(n-r)/
			Math.factorial(r);
	}

}