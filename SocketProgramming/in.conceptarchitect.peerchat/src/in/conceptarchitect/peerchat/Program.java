package in.conceptarchitect.peerchat;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String role="client";
		String server="localhost";
		int port=7502;
		String name=null;
		
		switch(args.length) {
			default: //ignore the other arguments
			case 4:
				try{port=Integer.parseInt(args[1]);}catch(Exception ex) {}
			
			
			case 3:
				server=args[2];
			
			case 2:
				name=args[1];
			case 1:
				role=args[0];
				break;
			case 0:
				System.out.println("help on peer-chat\n <client|server> <user-name> [<server>] [<port>]  ");
				return;
		}
		
		PeerChat chat=new PeerChat(role,name, server, port);
		
		chat.start();

	}

}
