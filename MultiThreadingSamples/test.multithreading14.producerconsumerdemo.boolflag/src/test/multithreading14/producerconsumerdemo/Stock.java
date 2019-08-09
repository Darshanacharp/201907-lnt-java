package test.multithreading14.producerconsumerdemo;

public class Stock {

	long qtyProduced;
	long qtyConsumed;
	
	boolean produced;
	
	
	public boolean isProduced() {
		return produced;
	}

	public void setProduced(boolean produced) {
		this.produced = produced;
	}

	
	public Stock() {
		
	}
	
	public void produce(){
		qtyProduced++;
	}
	
	public void consume(){
		qtyConsumed++;
	}

	public long getQtyProduced() {
		return qtyProduced;
	}

	public long getQtyConsumed() {
		return qtyConsumed;
	}

	public long getStockSurplus(){
		return qtyProduced-qtyConsumed;
	}
}
