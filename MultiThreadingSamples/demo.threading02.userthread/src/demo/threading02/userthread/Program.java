package demo.threading02.userthread;

public class Program {


	public static void main(String[] args) {
		// TODO 1: Create Info Printer Object
		InfoPrinter printer=new InfoPrinter();
		
		// TODO 2: Create Thread with info printer as constructor parameter
		Thread thread=new Thread(printer);
		// TODO 3: Start the Thread
		thread.setName("User Thread");
		thread.start(); //interanlly call printer.run()
		// TODO 4: Run the Info Printer
		printer.run();
		
	}

}
