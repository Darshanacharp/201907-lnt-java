class Permutation{

	static int calculate(int n,int r){
		System.out.println("Permutation V3");
		return 	Math.factorial(n)/
		 	Math.factorial(n-r);
	}

}