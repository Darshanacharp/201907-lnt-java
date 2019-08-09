package test.multithreading15.producerconsumerdemo;

import in.conceptarchitect.consoleapi.ConsoleInput;
import in.conceptarchitect.threading.ThreadUtils;

public class Program {

	

	public static void main(String[] args) {
		
		
		ConsoleInput input=new ConsoleInput();
		int duration=input.readInt("duration of demo? ");
		
		Stock cheeseStock=new Stock();
		
		Producer tom=new Producer(cheeseStock,Thread.NORM_PRIORITY-2);
		Consumer jerry=new Consumer(cheeseStock,Thread.NORM_PRIORITY+2);
		
		jerry.start();
		tom.start();
		ThreadUtils.println("waiting for 5 seconds");
		ThreadUtils.sleep(duration*1000);
		ThreadUtils.println("stopping");
		
		jerry.stop();
		tom.stop();
		
		synchronized (cheeseStock) {
			cheeseStock.notifyAll();
		}
		
		jerry.waitFor();
		tom.waitFor();
		
		System.out.println("total produced:"+cheeseStock.getQtyProduced());
		System.out.println("total consumed :"+cheeseStock.getQtyConsumed());
		System.out.println("surplus:"+cheeseStock.getStockSurplus());
	}

}
