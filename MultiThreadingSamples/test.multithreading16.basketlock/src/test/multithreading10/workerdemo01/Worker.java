package test.multithreading10.workerdemo01;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import in.conceptarchitect.threading.ThreadUtils;

public class Worker implements Runnable{

	private Basket basket;
	private int itemsToAdd;
	Thread thread;
	private CountDownLatch latch;
	
	
	
	public Basket getBasket() {
		return basket;
	}


	public Worker(Basket basket, int itemsToAdd, CountDownLatch latch) {
		
		this.basket=basket;
		this.itemsToAdd=itemsToAdd;
		thread=new Thread(this);
		this.latch=latch;
	}
	

	@Override
	public void run() {
		
		for(int i=1;i<=itemsToAdd;i++){
		
			
				basket.addItem();
			
			
		
		}
		
		latch.countDown();
	}
	
	public void start(){thread.start();}
	
	public void waitFor(){
		try{
			thread.join();
			
		}catch(Exception ex){
			
		}
	}
	
	

}
