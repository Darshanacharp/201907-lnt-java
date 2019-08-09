package demo.threading05.countdownthread;

import in.conceptarchitect.threading.ThreadUtils;

//TODO: Convert This class To a Thread Class
public class CountDownThread 
extends Thread {

	int max;
	public CountDownThread(int max) {
		this.max=max;
	}
	
	
	@Override
	public void run() {
		// TODO Parameterize and remove Next Line of Code from here after
		//int max=10;
		
		Thread me=Thread.currentThread();
		//System.out.println("Thread #"+me.getId()+" starts...");
		ThreadUtils.print("starts");
		
		
		
		
		
		while(max>=0){
			
			ThreadUtils.print("counts %d", max);
			max--;
			
		}
		
		ThreadUtils.print("finishes...");
		
		

	}

}
