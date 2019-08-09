package demo.threading04.parameterizedcountdown;

import in.conceptarchitect.threading.ThreadUtils;

public class CountDownTask 
implements Runnable {
	private int max;
	public CountDownTask(int max) {
		super();
		this.max = max;
	}

	@Override
	public void run() {
		
		// TODO: How to Parameterize It?
		//int max=20;
		
		//Thread me=Thread.currentThread();
		//System.out.println("Thread #"+me.getId()+" starts...");
		ThreadUtils.print("starts");
		
		
		
		
		
		while(max>=0){
			
			ThreadUtils.print("counts %d", max);
			max--;
			
		}
		
		ThreadUtils.print("finishes...");
		
		

	}

}
