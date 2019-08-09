package test.multithreading12.prioritydemo;

import in.conceptarchitect.threading.ThreadUtils;

public class Counter implements Runnable {

	Thread thread;
	long count;
	volatile boolean canRun;

		
	@Override
	public void run() {
	
		canRun=true;
		ThreadUtils.println("starts...");
		
		while(canRun)
			count++;
		
		ThreadUtils.println("stops...");
		
	}
	
	public long getCount() {		return count; 	}

	public void setCount(long count) {
		this.count = count;
	}
	
	public Counter(int priority) {
		// 
		thread=new Thread(this);
		//TODO-1: Set the Priority
		thread.setPriority(priority);
		thread.setDaemon(true);
	}
	
	public void start()
	{
		//ThreadUtils.println("starting thread");
		thread.start();
	}
	
	public void waitFor(){ ThreadUtils.waitFor(thread);}
	public void stop(){ canRun=false;thread.stop();}


}
