package demo.threading08.dameonthread;

import in.conceptarchitect.threading.ThreadUtils;

public class Program {


	public static void main(String[] args) {
		
		CountDownTask c1=new CountDownTask(200);	
		CountDownTask c2=new CountDownTask(2000);		
		CountDownTask c3=new CountDownTask(300);
		
		
		Thread t1=new Thread(c1);
		Thread t2=new Thread(c2);
		Thread t3=new Thread(c3);
		
		//TODO: set t2 to a daemon thread
		t2.setDaemon(true);
		
		
		//run the threads.
		t1.start();
		t2.start();
		t3.start();

		//GOAL-1: t3 stop midway after t1 and t2 finishes		
		
		ThreadUtils.waitFor(t1,t3);
		
		//GOAL-2: This line should be the last to be printed
		System.out.println("end of main program");
		
		

		
		
	
	}
	
		

}
