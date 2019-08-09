package in.conceptarchitect.threading;

public class ThreadUtils {

	public static void print(String fmt, Object ...params){
		
		String msg=String.format(fmt, params);
		
		System.out.printf("[#%d] %s\n",Thread.currentThread().getId(),msg);
		
	}
	
	
	public static void sleep(long millisecond) {
		
		try {
			Thread.sleep(millisecond);
		} catch (InterruptedException e) {
			
			throw new ThreadInterruptedException(e.getMessage(),e);
		}
	}
	
	public static void waitFor(Thread ... threads ) {
		
		try {
			for(Thread thread: threads) {
				thread.join();
			}
		}
		catch(InterruptedException ex) {
			throw new ThreadInterruptedException(ex.getMessage(), ex.getCause());
		}
	}
	
	
}
