package in.conceptarchitect.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public String readString(String prompt) {
		System.out.print(prompt+" ");
		try {
			return reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}	
	public double readDouble(String prompt) {
		return Double
				.parseDouble(readString(prompt));
	}
	
	public int readInt(String prompt) {
		return Integer
				.parseInt(readString(prompt));
		
	}
	

}
