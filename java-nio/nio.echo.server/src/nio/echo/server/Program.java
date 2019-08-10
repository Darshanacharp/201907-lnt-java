package nio.echo.server;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EchoServer server=new EchoServer(2822);
		
		server.start();
		
		//Input.readString("Hit Enter to Exit");
		
		//server.stop();
		
		
	}

}
