package test.multithreading10.workerdemo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import in.conceptarchitect.threading.ThreadUtils;

public class Basket {

	long items;
	//TODO-1 Add a Field of type 'Lock'
	private boolean lockRequired;
	
	public Basket(boolean lockRequired){
		this.lockRequired=lockRequired;

		//if(lockRequired)
			//TODO-2 Create a RenterentLock Object
	}
	
	

	public void addItem(){
	
		
		
		int attempt=0;
		try{
				
			
				if(lockRequired){
					
					while(attempt<3){
						//TODO-3 Try to Take a Lock 3 times at an interval of 3 seconds
						
						attempt++;
						ThreadUtils.sleep(10);
					}
					//If you fail to take the lock. Print and X and quit
					if(attempt==3){
						
						System.out.print("X");
						return ;
					}
				}
				
				
				//Do the Actual job it lock is successfull
				long x=items;
				x=x+1;
				items=x;
		}
		finally{
			//TODO-4: Uncomment and complete the if below
			//if(lockRequired && attempt<3)
				//TODO-4: Release the lock
		}
	}
	
	public long getItems() {
		return items;
	}

}
