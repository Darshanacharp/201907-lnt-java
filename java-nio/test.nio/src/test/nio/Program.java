package test.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Program {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//testFileRead();
		
		nioCopy("c:/temp/indian-flag.jpg","c:/temp/indian-flag-2.jpg");
		System.out.println("file written");
		
	}
	
	private static void nioCopy(String source, String destination) throws IOException {
		
		FileChannel src=new FileInputStream(source).getChannel();
		FileChannel trgt=new FileOutputStream(destination).getChannel();
		
		ByteBuffer buffer=ByteBuffer.allocate(8192); //8kb buffer
		
		int bytesRead=src.read(buffer);
		while(bytesRead>0) {
			System.out.print("+");
			buffer.flip();
			trgt.write(buffer);
			buffer.clear();
			bytesRead=src.read(buffer);
		}
		
		src.close();
		trgt.close();
			
		
	}

	private static void testFileRead() throws FileNotFoundException, IOException {
		String fileName= "c:/temp/numbers.txt";
		
		FileChannel channel= new RandomAccessFile(fileName,"rw")
							.getChannel();
		
		ByteBuffer buffer=ByteBuffer.allocate(64); //read 64 byte at a time.
		//buffer is by default writable (write mode). can't read from it
		
		// we can read a channle and write to buffer
		int bytesRead=channel.read(buffer); //read channel and write to buffer
		int readCount=0;
		
		while(bytesRead>0) {
			readCount++;
			
			//remeber buffer is in write mode. must flip its mode to read from it
			buffer.flip(); //convert buffer to read mode
			
			while(buffer.remaining()>0)
				System.out.print((char)buffer.get()); //get bytes from the  buffer
			
			
			buffer.clear(); //clear current buffer content and switch it to write mode
			bytesRead=channel.read(buffer); //read next round
		}
		
		System.out.println("Read file in "+readCount+" times ");
	}

}
