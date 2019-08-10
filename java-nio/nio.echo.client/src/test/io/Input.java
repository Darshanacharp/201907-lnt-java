package test.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Input {

	
	public static String readString(String prompt) throws IOException {
		
		Reader console= new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(console);
				
		System.out.print(prompt);
		
		return br.readLine();
	}
}
