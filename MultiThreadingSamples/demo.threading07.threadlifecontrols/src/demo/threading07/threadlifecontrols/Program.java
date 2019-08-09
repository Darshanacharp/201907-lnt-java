package demo.threading07.threadlifecontrols;

import in.conceptarchitect.threading.ThreadUtils;

public class Program {


	public static void main(String[] args) {
		
		CountDownTask c1=new CountDownTask(200);	
		
		CountDownTask c2=new CountDownTask(150);
		
		CountDownTask c3=new CountDownTask(300);
		

		c1.start();
		c2.start();
		c3.start();
		waitForThreadsToJoin(c1.getThread(),c2.getThread(),c3.getThread());
		//GOAL: This should be the last output message
		System.out.println("end of main program");
	
	
	}
	
	private static void waitForThreadsToJoin(Thread t1, Thread t2, Thread t3) {
		// TODO-4B Auto-generated method stub
		
//		try {
//			t1.join();
//			t2.join();
//			t3.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} //current Thread will sleep till t1 finishes (and joins)
		
		
		ThreadUtils.waitFor(t1,t2,t3);
		
		
		
	}

	private static void waitLoop() {
		// TODO-1B :   loop long enough for others tasks to end
		long count=100000l; //adjust value
		
		for(long i=0;i<count;i++)
			System.out.print(".");
		
	}

	private static void waitTillTasksAreAlive(Thread t1, Thread t2, Thread t3) {
		// TODO-2B check the is alive condition
		while(t1.isAlive() || t2.isAlive() || t3.isAlive()) {
			System.out.print(".");
		}
	}
	
	private static void sleepForSometime() {
		// TODO-3B - Let Main Sleep for 5 seconds
		//Thread.sleep(5000);
		
		ThreadUtils.sleep(5000);
		
		
	}

	


	

	

}
