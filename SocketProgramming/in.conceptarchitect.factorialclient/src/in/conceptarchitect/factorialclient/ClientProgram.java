package in.conceptarchitect.factorialclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import in.conceptarchitect.consoleutils.Input;

public class ClientProgram {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String server="localhost";
		int port=9211;

		switch(args.length) {
		default:
		case 2:
			port=Integer.parseInt(args[1]);
		case 1:
			server=args[0];
		case 0:

		}
		Socket socket=null;
		
		try {
			System.out.printf("connecting to %s on %d...",server,port);
			socket=new Socket(server,port);
			System.out.println("connected");
		} catch(Exception ex) {
			System.err.println("failed\n"+ex.getMessage());
			System.exit(1);
		}

		//time to start talking
		
		BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out= new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		Input kb=new Input();
		
		String resp="";
		do {
			
			String req= kb.readString("? ");
			
			out.println(req); //send to server
			
			//server will send you a response back
			
			resp= in.readLine(); //whaterver server says
			
			System.out.println("> "+resp);
			
		}while(!resp.equals("bye"));
		
		socket.close();
		
		System.out.println("Program Ends...");
		
		

	}

}
