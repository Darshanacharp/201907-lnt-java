package demo.threading05.countdownthread;

public class Program {


	public static void main(String[] args) {
		
		
		// GOAL Create and Start Two Thread with max=200 and 100
		
		Thread t1=new CountDownThread(200); //TODO: Change this to create CountDownThread
		Thread t2=new CountDownThread(100); //TODO: Change this to create CountDownThread
		
		
		t1.start();
		t2.start();
		
		
		System.out.println("end of main program");
	
	
	}

}
