package demo.threading09.workerdemo2;

public class Basket {
	long items;

	//TODO-1: Add Lock Code	
	public synchronized void addItem(){
			//synchronized(this) {
				long item=this.items;
				item++;
				this.items=item;
			//}
	}

	public long getItems() {
		return items;
	}

}
