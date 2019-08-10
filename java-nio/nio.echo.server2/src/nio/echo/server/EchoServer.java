package nio.echo.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class EchoServer {

	int port;
	Selector selector;

	public EchoServer(int port) {
		// TODO Auto-generated constructor stub
		this.port = port;
	}

	ServerSocketChannel server;

	public void start() {
		// TODO Auto-generated method stub

		try {

			System.out.println("starting server on port " + port);
			server = ServerSocketChannel.open();
			
			server.configureBlocking(false); //non-blocking

			selector = Selector.open(); // agent for mutliple channels

			// see what are the selecable option for current channel
			int ops = server.validOps();

			server.register(selector, ops); // let selector handle the channel events ---> connect, receive etc

			server.bind(new InetSocketAddress("localhost", port));

			System.out.println("server ready");
			Set<SelectionKey> keys=null;
			while (true) {
				try {
					
					int keyCount = selector.select(); // see how many items are ready for processing
					if (keyCount == 0)
						continue; // nothing yet. lets move on
					keys = selector.selectedKeys(); // list of ready events

					for (SelectionKey key : keys) {

						if (key.isAcceptable()) // some client is waiting
							doAccept();
						else if (key.isReadable()) // some message is waiting to be recievreceived
							doReceive(key);

					}
					//keys.clear(); // remove the processed keys

				} catch (DisconnectionException ex) {
					System.out.println("client quit");
				} catch (Exception ex) {
					System.out.println("error:" + ex.getMessage());
					
				}
				finally {
					keys.clear();
				}
			}

		} catch (Exception ex) {
			System.out.println("Error setting up server :" + ex.getMessage());
			ex.printStackTrace();
		}
	}

	private void doReceive(SelectionKey key) throws Exception {
		// TODO Auto-generated method stub
		SocketChannel client = (SocketChannel) key.channel(); // which client has sent the message?
		
		
		String message = receive(client);
		System.out.println(client+":"+message);
		send(client, message);
		if (message.equals("bye"))
			throw new DisconnectionException("disconnect the client");
	}

	private void doAccept() throws Exception {
		// TODO Auto-generated method stub
		SocketChannel client = server.accept(); // not a blocking call. we already know we have a client
		int ops = client.validOps(); // receive
		client.configureBlocking(false);
		System.out.println("client connected");
		client.register(selector, ops); // any message from this channel will be received by same selector
	}

	private void send(SocketChannel client, String str) throws IOException {
		// TODO Auto-generated method stub
		byte[] data = new String(str).getBytes();// convert string to byte []
		ByteBuffer buffer = ByteBuffer.wrap(data); // wrap byte array in a byte buffer
		client.write(buffer);
	}

	private String receive(SocketChannel client) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(256);
		buffer.clear();
		client.read(buffer);
		buffer.flip();
		String str = "";
		while (buffer.remaining() > 0)
			str += (char) buffer.get();
		return str;
	}

	public void stop() {
		// TODO Auto-generated method stub

	}

}
