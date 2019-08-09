package demo.threading03.countdown;

public class CountDownTask implements Runnable {

	@Override
	public void run() {
		
		Thread me=Thread.currentThread();
		System.out.println("Thread #"+me.getId()+" starts...");
		
		int max=20;
		
		while(max>=0){
			
			System.out.println("Thread #"+me.getId()+" counts "+max);
			max--;
			
		}
		
		System.out.println("Thread #"+me.getId()+" finishes...");

	}

}
