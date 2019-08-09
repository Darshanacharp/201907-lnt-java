package test.multithreading18a.futureandcallable;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import in.conceptarchitect.threading.ThreadUtils;

public class Program {

	public static void main(String []args) throws InterruptedException, ExecutionException {
		
		//getAnswerFromThread();
		
		ExecutorService executor=Executors.newFixedThreadPool(1);
		
		
		Callable<Integer> c=null;
		
		Future<Integer> futureResult=executor.submit(   ()->factorial(5)   );
		
		executor.shutdown();
		
		System.out.print("Please wait till you get the result");
		
		while(!futureResult.isDone()) { //result is pending
			System.out.print("+ ");
			ThreadUtils.sleep(200);
		}
		
		int result= futureResult.get(); //you will get the result only after completion.
		
		
		
		System.out.println();
		System.out.println("Answer is "+result);
		
		
		
	}

	private static void getAnswerFromThread() {
		final int result[]=new int[1];
		Thread thread=new Thread(()->result[0]=factorial(5));
		
		thread.start();
		System.out.println("wait for the answer...");
		ThreadUtils.waitFor(thread);
		
		//how do I get the result?
		System.out.println(result[0]);
	}
	
	static int factorial( int n) {
		
		int fn=1;
		while (n>=1) {
			fn*=n--;
			
			ThreadUtils.sleep(1000);
		}
		
		return fn;
		
		
	}
	
}
