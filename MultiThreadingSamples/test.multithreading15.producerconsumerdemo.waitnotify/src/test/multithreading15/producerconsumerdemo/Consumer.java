package test.multithreading15.producerconsumerdemo;

import in.conceptarchitect.threading.ThreadUtils;

public class Consumer implements Runnable {

	Thread thread;
	volatile boolean canRun;
	private Stock stock;
	
	public Consumer(Stock stock, int priority) {
		// 
		this.stock=stock;
		thread=new Thread(this);
		thread.setPriority(priority);
		
	}

	@Override
	public void run() {
		
		canRun=true;
		
		try{
			while(canRun){
				synchronized(stock){
					if(!stock.isProduced() ) //not yet produced
						stock.wait();	//wait for notification
					
					stock.consume();
					stock.setProduced(false);
					stock.notify(); //inform  waiting producer to produce more
				}
			}
		}
		catch(InterruptedException ex){
			
		}
	}

	public void start(){thread.start();}
	public void stop(){canRun=false;}
	public void waitFor(){ThreadUtils.waitFor(thread);}
	
}
