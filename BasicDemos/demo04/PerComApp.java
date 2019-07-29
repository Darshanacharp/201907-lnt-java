class PerComApp{
	public static void main(String[]args){
		int n=5;
		int r=3;
		int p=Permutation.calculate(n,r);
		int c=Combination.calculate(n,r);
		System.out.println(n+"P"+r+"="+p);
		System.out.printf("%dC%d=%d\n",n,r,c);
	}
}