class Permutation{

	static int calculate(int n,int r){
		System.out.println("Permutation V3");
		return 	Math.factorial(n)/
		 	Math.factorial(n-r);
	}

	public	static void main(String []args){
		System.out.println("help: Permutation.calculate(5,3)=>"+Permutation.calculate(5,3));	
	}

}