package demo.io;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class ByteArrayInputStreamTest {
	
	String testData="This is a simple text";
	byte  bytes[]= testData.getBytes();
	ByteArrayInputStream bis;
	
	@Before
	public void setup() {
		bis=new ByteArrayInputStream(bytes);
	}
	
	@Test
	public void length_StringAndByteArrayHaveSameLength() {
		
		assertEquals(testData.length(), bytes.length);
	}
	
	@Test
	public void available_byteArrayInputStreamHasInitialAvailableEqualsByteArraySize() {
		long length=bis.available();
		
		assertEquals(bytes.length, length);
	}
	
	@Test
	public void read_readsOneByteAsInt() {
		int value= bis.read();
		
		byte b=(byte) value;  //0-255
		
		assertEquals(bytes[0],b);
		
	}
	
	@Test
	public void available_eachByteReadReducesAvaialable() {
		bis.read();
		//now I have one byte less to read
		assertEquals(bytes.length-1, bis.available());
	}
	
	@Test
	public void read_canReadAWholeArrayOfBytes() throws IOException {
		byte [] buff=new byte[5];
		
		int read= bis.read(buff);
		
		assertEquals(buff.length, read);
		
		assertEquals(bytes.length-buff.length, bis.available());
		
	}
	
	@Test
	public void read_returnsActualBytesReadIfItIsLessThanBufferSize() throws IOException {
		byte [] buff=new byte[500];
		
		int read= bis.read(buff);
		
		assertEquals(bytes.length, read);
		
		assertEquals(0, bis.available());
		
	}
	
	@Test
	public void read_fromEmptyStreamReturnsMinus1() throws IOException {
		byte [] buff=new byte[500];
		
		int read= bis.read(buff);
		
		assumeTrue(bis.available()==0);
		
		int value=bis.read(); //nothing to read
		
		assertEquals(-1,value);
		
	}
	
	@Test
	public void read_canReadEntireStreamByteByByteToItsEnd() throws IOException {
		
		String data="";
		int i=0;
		int count=0;
		while( (i= bis.read()) != -1 )
		{
			data+=(char) i;
			count++;
		}
		
		bis.close();
		
		assertEquals(bytes.length, count);
		assertEquals(testData, data);
		
	}
	
	
	
	
	

}
