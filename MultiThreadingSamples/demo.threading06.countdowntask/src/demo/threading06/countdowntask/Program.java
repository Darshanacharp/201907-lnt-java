package demo.threading06.countdowntask;

public class Program {


	public static void main(String[] args) {
		
		CountDownTask c1=new CountDownTask(200); //auto start		
		CountDownTask c2=new CountDownTask(100,false); //need manual start
		CountDownTask c3=new CountDownTask(300); //auto start
		
		c2.start();  //manual start
		c1.start();  //already started.can't start again!
		
		System.out.println("end of main program");
	
	
	}

}
