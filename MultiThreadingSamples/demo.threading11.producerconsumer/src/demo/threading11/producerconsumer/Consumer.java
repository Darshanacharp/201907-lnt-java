package demo.threading11.producerconsumer;

import in.conceptarchitect.threading.ThreadUtils;

public class Consumer  {

	Stock stock;
	
	volatile boolean run;
	
	public void stop() { run=false; }
	
	public Consumer(Stock stock) {
		// 
		this.stock=stock;
		
	}
	
	public void work() {
		run=true;
		
		while(run) {
		
			stock.consume();
			
		}
		System.out.println("consumer stops...");
	}

}
