package demo.threading08.dameonthread;

import java.lang.Thread.State;

import in.conceptarchitect.threading.ThreadUtils;

public class CountDownTask implements Runnable {

	int max;
	
	public CountDownTask(int max) {
		this.max=max;
	}
	
	@Override
	public void run() {
		
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
