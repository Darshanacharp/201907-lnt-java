package demo.threading11.producerconsumer;

public class Stock {
	long producedCount;
	long consumedCount;
	boolean produced;
	
	
	

	public  void produce(){
		
		
		producedCount++;
		produced=true;
	
		
	
	}
	
	
	public void consume() {
		
		consumedCount++;
		produced=false;
	
	}


	public boolean isProduced() {return produced; }

	public long getProducedCount() {
		return producedCount;
	}



	public long getConsumedCount() {
		return consumedCount;
	}
	
	

}
