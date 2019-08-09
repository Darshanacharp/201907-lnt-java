package in.conceptarchitect.factorialserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import in.conceptarchitect.consoleutils.Input;

public class ServerProgram {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int port=9211;
		Input kb=new Input();
		
		if(args.length>0) {
			port=Integer.parseInt(args[0]);
		}
		
		//Step 1
		ServerSocket server=null;
		try {
				System.out.print("Starting server on port "+port+"...");
				server= new ServerSocket(port);
				System.out.println("success");
			
		}catch(BindException ex) {
			System.out.println("failed\t"+ex.getMessage());
			System.exit(1);
		}
		
		ExecutorService executor=Executors.newCachedThreadPool();
		int clientCount=0;
		while(true) {
			//server is connected. lets move to the step 2
			System.out.print("waiting for the client...");
			Socket client=server.accept();
			System.out.println("connected");			
			
			final int id= ++clientCount;
			executor.execute(()->talkToClient(client,id));
		}
		
		
		
	}

	
	private static void talkToClient(Socket client,int id) {
		try {
			_talkToClient(client, id);
			System.out.println("client #"+id+"  disconnected");
		}catch(Throwable ex) {
			System.out.println("client #"+id+" aborted");
			
			System.out.println(ex.getMessage());
		}
	}
	
	private static void _talkToClient(Socket client,int id) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
		PrintWriter out= new PrintWriter(new OutputStreamWriter(client.getOutputStream()),true);
		
		
		String resp="";
		do {
			
			//wait for client to send a request
			String req= in.readLine();  //whatever client sends
			System.out.println("client#"+id+" <<< "+req);
			
			if(req.equalsIgnoreCase("bye")) {
				resp="bye";
			}
			else {
				
				try {
					int n= Integer.parseInt(req);
					long fn=factorial(n);
					resp=""+fn;  //convert int to string
				}catch(NumberFormatException ex) {
					resp="Invalid Input";
				}
			}
			
			out.println(resp);
			System.out.println("#"+id+" >>> "+resp);
			
		}while(!resp.equals("bye"));		
		client.close(); //disconnect the client socket
	}

	private static long factorial(int n) {
		// TODO Auto-generated method stub
		long f=1;
		while(n>1)
			f*=n--;
		return f;
	}

}
