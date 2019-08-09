package demo.threading01.mainthread;

public class Program {


	public static void main(String[] args) {
		
		
		Thread thread=Thread.currentThread();  //TODO: Get A Reference to The Current Thread
		
		
		System.out.println(thread);
		
		thread.setName("My Only Thread");
		thread.setPriority(Thread.MAX_PRIORITY);
		
		System.out.println(thread);
	}

}
