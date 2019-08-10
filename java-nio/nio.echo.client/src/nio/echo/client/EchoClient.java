package nio.echo.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import javax.swing.plaf.synth.SynthSeparatorUI;

import test.io.Input;

public class EchoClient {

	
	
	public EchoClient() {
		// TODO Auto-generated constructor stub
	}

	ServerSocketChannel server;
	
	public void start(String server, int port) {
		// TODO Auto-generated method stub
		
		try {
	
			System.out.println("connecting to "+ server+" on port "+port);
			
			SocketChannel client=SocketChannel.open();
			client.connect(new InetSocketAddress(server, port));
			System.out.println("connected...");
			
			
			
			String msg="";
			
			while(!msg.equals("bye")) {
				
				msg= Input.readString("? ");
				
				send(client,msg);
				String serverMessage=receive(client);
				
				System.out.println("server:"+serverMessage);
					
				
				
			}
			
			
			
			
		}
		catch(Exception ex) {
			System.out.println("Error starting server:"+ex.getMessage());
		}
	}


	private void send(SocketChannel client, String str) throws IOException {
		// TODO Auto-generated method stub
		byte [] data= new String(str).getBytes();//convert string to byte []
		ByteBuffer buffer=ByteBuffer.wrap(data); //wrap byte array in a byte buffer
		client.write(buffer);
	}









	private String receive(SocketChannel client) throws IOException {
		ByteBuffer buffer=ByteBuffer.allocate(256);
		buffer.clear();
		client.read(buffer);
		buffer.flip();
		String str="";
		while(buffer.remaining()>0)
			str+=(char)buffer.get();
		return str;
	}
	
	
	
	
	
	
	
	
	
	public void stop() {
		// TODO Auto-generated method stub
		
	}

}
