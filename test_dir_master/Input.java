import java.util.*;
import java.io.*;

class Input{

	static	Scanner scanner=new Scanner(System.in);

	public static String readString(String prompt){
		System.out.print(prompt);
		return scanner.nextLine();
	}

	public static int readInt(String prompt){
		System.out.print(prompt);
		return scanner.nextInt();
	}

}