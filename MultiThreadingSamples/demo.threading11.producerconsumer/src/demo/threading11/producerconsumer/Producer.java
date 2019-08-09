package demo.threading11.producerconsumer;

public class Producer  {

	Stock stock;
	
	volatile boolean run;
	
	public void stop() { run=false; }
	
	public Producer(Stock stock) {
		// 
		this.stock=stock;
		
	}
	
	public void work() {
		run=true;
		
		while(run) {
		
			stock.produce();
			
		}
		System.out.println("producer stops...");
	}

}
