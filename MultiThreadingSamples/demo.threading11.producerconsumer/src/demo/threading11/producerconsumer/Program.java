package demo.threading11.producerconsumer;

import in.conceptarchitect.consoleutils.Input;
import in.conceptarchitect.threading.ThreadUtils;

public class Program {


	public static void main(String[] args) {
		
		Stock stock=new Stock();
		
		Producer producer=new Producer(stock);
		Consumer consumer=new Consumer(stock);
		
		Thread producerThread=new Thread(producer::work);
		Thread consumerThread=new Thread(consumer::work);
		
		producerThread.setPriority(4);
		consumerThread.setPriority(6);
		
		System.out.println("starting producer and consumer...");
		consumerThread.start();
		producerThread.start();
		
		System.out.println("sleeping for 5 seconds...");
		ThreadUtils.sleep(5000);
		
		System.out.println("stopping the threads...");
		producer.stop();
		consumer.stop();
		
		System.out.println("waiting for threads to join...");
		ThreadUtils.waitFor(producerThread,consumerThread);
		
		System.out.println("Final Result");
		System.out.println("Total Produced:"+stock.getProducedCount());
		System.out.println("Total Consumed:"+stock.getConsumedCount());
		System.out.println("Stock Surplus:"+(stock.getProducedCount()-stock.getConsumedCount()));
		
		//GOAL: StockSurplus should be 0 or 1
		
		
		
		
		
		
		
		
		
		
		
		
				
		
	
	}

}
