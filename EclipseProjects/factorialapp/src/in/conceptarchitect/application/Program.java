package in.conceptarchitect.application;

import in.conceptarchitect.calculations.Factorial;
import in.conceptarchitect.calculations.Permutation;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		Factorial f=new Factorial();
		int fn=f.calculate(n);
		
		
		
 		System.out.printf("%d ! = %d\n",n,fn);
 		
 		int r=3;
 		Permutation per=new Permutation();
 		
 		int p=per.calculate(n, r);
 		
 		System.out.println(p);
 		
	}

}
