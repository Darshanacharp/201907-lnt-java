package test.multithreading17.executors;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

import in.conceptarchitect.threading.ThreadUtils;

public class Program {

	

	public static void main(String[] args) throws InterruptedException {

		
		// TODO-1 Create the Executors		
		ExecutorService executor=Executors.newFixedThreadPool(3);
		
		for(int i=0;i<10;i++) {
			final int id=i;
			
			executor.execute(()-> task(id));
		}
		
		
		//TODO-2 shutdown executor
		executor.shutdown(); //no furthe jobs will be taken. complete already assigned tasks
		
		//will cause an exception as executor is already shutdown
		try {
			executor.execute(()->System.out.println("Another Task Added After Shutdown"));
		} catch (RejectedExecutionException  e) {
			// TODO Auto-generated catch block
			System.out.println("New Task is not accepted : "+e.getMessage());
		}
		
		//TODO-3 wait for termination of current task
		executor.awaitTermination(12, TimeUnit.SECONDS);
		
		List<Runnable> waitingTasks=executor.shutdownNow(); //shutdown immediately, return incomplete task
		
		executor.awaitTermination(1, TimeUnit.SECONDS);
		
		System.out.println(waitingTasks.size()+" tasks were not executed");
		
		
		System.out.println("End of Program");
		
			
	}
	
	public static void task(int id) {
		
		int max=5;
		ThreadUtils.print("[Task #%d] starts\n",id);
		while(max>=0) {
			ThreadUtils.print("[Task #%d] counts %d\n",id,max);
			max--;
			ThreadUtils.sleep(1000);
		}
		ThreadUtils.print("[Task #%d] ends\n",id);

	}

}
