package in.conceptarchitect.calculations;

public class Permutation {

	public int calculate(int n,int r) {
		Factorial f=new Factorial();
		
		return f.calculate(n)/f.calculate(n-r);
	}
}