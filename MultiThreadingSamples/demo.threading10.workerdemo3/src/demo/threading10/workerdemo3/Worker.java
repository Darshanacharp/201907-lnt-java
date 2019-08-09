package demo.threading10.workerdemo3;

import in.conceptarchitect.threading.ThreadUtils;

public class Worker implements Runnable {

	Thread thread;
	Basket basket;
	long itemsToAdd;
	
	public Worker(Basket basket,long itemsToAdd) {
		// TODO-1 Lock Basket before you use conditionally
		
		this.basket=basket;
		thread=new Thread(this);
		this.itemsToAdd=itemsToAdd;
	}
	
	public void start(){
		thread.start();
	}
	
	public void waitFor(){
		ThreadUtils.waitFor(thread);
	}
	

	@Override
	public void run() {
		// 
		for(int i=0;i<itemsToAdd;i++){
			
			//Add Locks to Basket
			synchronized(basket) {
				basket.addItem();
			}
			
			
			
		}
	}

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

}
