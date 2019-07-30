package in.conceptarchitect.console;
import java.util.*;
import java.io.*;
public class Input{

	Scanner scanner=new Scanner(System.in);

	public String readString(String prompt){
		System.out.print(prompt);
		return scanner.nextLine();
	}

	public int readInt(String prompt){
		System.out.print(prompt);
		return scanner.nextInt();
	}

}