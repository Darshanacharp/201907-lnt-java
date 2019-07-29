class PerComApp{
	public static void main(String[]args){
		int n=Input.readInt("n?");
		int r=Input.readInt("r?");
		int p=Permutation.calculate(n,r);
		int c=Combination.calculate(n,r);

		PrintWriter.write("permutation is "+p);
		PrintWriter.write("combination is "+c);
	}
}