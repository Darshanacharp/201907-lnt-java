package app.fileread;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length==0) {
			System.err.println("Usage: java -jar fc <source-file> [<target-file>]");
			System.exit(1) ; //error status code
		}
		
		
		
		String source= args[0];
		
		try {
			
			String target= args.length>=2 ? args[1] : null;
			
			FileInputStream fis=new FileInputStream(source);
			OutputStream fos=target!=null ? new FileOutputStream(target) : System.out;
			
			
			
			while(true) {
				int ch= fis.read();
				if(ch==-1) //end of file
					break;
				
				//System.out.print((char)ch);
				fos.write((char)ch);
				
			}
			
			fis.close();
			if(!fos.equals(System.out)) {
				fos.close();
				System.out.println("File copied to "+target);
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		

	}

}
