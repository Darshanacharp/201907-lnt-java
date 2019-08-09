package in.conceptarchitect.peerchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import in.conceptarchitect.consoleutils.Input;

public class PeerChat {

	private String role;
	private String name;
	private ServerSocket server;
	private int port;
	private Socket partner;
	private BufferedReader in;
	private PrintStream out;
	private String serverName;
	private String partnerName="partner";
	Input input=new Input();
	ExecutorService executor;

	public PeerChat(String role, String name, String server, int port) {
		// TODO Auto-generated constructor stub
		this.role=role;
		this.name=name;
		this.serverName=server;
		this.port=port;
		executor=Executors.newSingleThreadExecutor();
	}

	public void start() {
		// TODO Auto-generated method stub

		if(role.toLowerCase().charAt(0)=='c')
			clientRole();
		else
			serverRole();
		
		
	}

	private void serverRole() {
		// TODO Auto-generated method stub
		try {
		
			System.out.println("Initalizing...");
			server=new ServerSocket(port);
			System.out.println("waiting for the partner");
			partner=server.accept();
			
			initStreams();			
			
			System.out.println("connected");
			chat();
			
		} catch(Exception ex) {
			System.out.println("Failed. "+ex.getMessage());
		}
		
		
		
	}
	
	private void clientRole() {
		// TODO Auto-generated method stub
		try {
			System.out.println("connecting to "+serverName+" on "+port +"...");
			partner= new Socket(serverName, port);
			initStreams();
			System.out.println("connected");
			chat();
			
		}catch(Exception ex) {
			System.out.println("Failed.\t"+ex.getMessage());
		}
		
	}
	
	private void initStreams() throws IOException {
		// TODO Auto-generated method stub
		in= new BufferedReader(new InputStreamReader(partner.getInputStream()));
		//out=new PrintWriter(new OutputStreamWriter(partner.getOutputStream()),true);
		
		out=new PrintStream(partner.getOutputStream(),true);
		
		executor.execute(this::receiveMessages);
	}

	

	
	
	private void receiveMessages() {
		System.out.println("waiting for client messages...");
		while(true) {
			try {
				
				String inMessage=in.readLine();
				System.out.println("\n"+inMessage);
				System.out.println(name+" > ");
				
			}
			catch(Exception ex) {
				System.out.println("error receiving message");
				break;
			}
		}
	}
	
	
	private void chat() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				String message=input.readLine(name+" > ");
				out.println(name+" > "+message);
				out.flush();
				
			}catch(Exception ex) {
				System.out.println("communication error");
				break;
			}
		}
	}

	

	

}






