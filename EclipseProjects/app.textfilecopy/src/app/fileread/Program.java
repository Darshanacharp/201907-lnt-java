package app.fileread;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

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
			
			//1. create a unbuffered file reader
			FileReader srcFile=new FileReader(source); 
			
			//2.convert it to a buffered reader
			BufferedReader src=new BufferedReader(srcFile);
			
			
			
			//
			Writer trgtFile=null;
			if(target!=null) {
				trgtFile= new FileWriter(target);
			} else {
				//Problem. System.out is not a Writer, its OutputStream
				//Solution: convert a OutputStream to a Writer using an adapter
				
				trgtFile= new OutputStreamWriter(System.out);
			}
			
			PrintWriter trgt= new PrintWriter(trgtFile,true); //autoflush on newline
			
			
			
			while(true) {
				String line= src.readLine();
				if(line==null) //end of file
					break;
				
				trgt.println(line); //write to file
				
			}
			
			src.close();
			if(!trgt.equals(System.out)) {
				trgt.close();
				System.out.println("File copied to "+target);
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		

	}

}
