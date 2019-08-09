package demo.threading04.parameterizedcountdown;

import in.conceptarchitect.threading.ThreadUtils;

public class Program {


	public static void main(String[] args) {
		
		// TODO: Modify The CountDownTask to take max parameter
		CountDownTask c1=new CountDownTask(200);  //max=200
		CountDownTask c2=new CountDownTask(100); //max=100
		
		Thread t1=new Thread(c1);
		Thread t2=new Thread(c2);
		
		t1.start();
		t2.start();
		
		//System.out.println("end of main program");
		ThreadUtils.print("Program Ends");
	
	
	}

}
