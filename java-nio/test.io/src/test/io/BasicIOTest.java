package test.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import org.junit.Before;
import org.junit.Test;

public class BasicIOTest {

	String testFilePath="c:/temp/numbers.txt";
	String targetFilePath="c:/temp/numbers-output.txt";
	File testFile;
	File targetFile;
	long size;
	
	@Before
	public void setUp() throws Exception {
		
		testFile=new File(testFilePath);
		assumeTrue(
				"Test File : "+testFilePath+" doesn't exist",
				testFile.exists());
		
		size=testFile.length();
		targetFile=new File(targetFilePath);
		
		
		
		
	}

	@Test
	public void inputStream_canReadEntireFile() {
		try {
			
		
			FileInputStream in=new FileInputStream(testFile);
			int ch;
			long count=0;
			while((ch= in.read() )!=-1)
				count++;
			
			
			assertEquals(size, count);
		}
		catch(Exception ex) {
			fail("unable to read the file");
		}
	}

	
	@Test
	public void can_writeAndReadStream() {

			String input="Hello World";
			
			byte [] inputData= input.getBytes();
			
			ByteArrayInputStream bis=new ByteArrayInputStream(inputData);
			
			ByteArrayOutputStream bos=new ByteArrayOutputStream(input.length());
			
			int ch;
			while(bis.available()>0)
				bos.write(bis.read());

			String output= new String(bos.toByteArray());
			
			assertEquals(input, output);
			
	}

	
	
	
	
}







