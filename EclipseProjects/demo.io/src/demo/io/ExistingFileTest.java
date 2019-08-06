package demo.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ExistingFileTest {

	static final String MASTER_PATH="C:\\MyWorks\\Corporate\\201907-lnt-java\\test_dir_master";
	static final String DIRECTORY_PATH="C:\\MyWorks\\Corporate\\201907-lnt-java\\test_dir";
	static final String EXISTING_FILE="Input.java";
	
	File newName=new File(DIRECTORY_PATH, "new-name.txt");
	
	File file;
	static final String PATH=DIRECTORY_PATH+"\\"+EXISTING_FILE;
	static final int FILE_SIZE=333;
	
	@Before
	public void setUp() throws Exception {
		file=new File(PATH);
		
		File masterFile=new File(MASTER_PATH, EXISTING_FILE);
		
		
		
		assumeTrue(file.exists());
	}
	
	@Test
	public void exists_fileObjectCanIdentifyThatFileExists() {
		
		assertTrue(file.exists());
	}
	
	@Test
	public void info_returnsTheCorrectLengthOfTheFile() {
		
		long length= file.length();
		
		assertEquals(FILE_SIZE, length);
	}
	
	
	@Test
	public void info_lastModifiedReturnsBasedDateForANonExistingFile() {
		long elapsed= file.lastModified();
		Date date=new Date(elapsed);
		
		Date today=new Date();
		
		assertEquals(today.getYear(), date.getYear());
		
	}
	
	@Test
	public void rename_canRenameAFile() {
		
		
		
		file.renameTo(newName);
		
		//assertFalse(file.exists());
		
		assertTrue(newName.exists());
		
		
		
	}
	
//	
//	@Test
//	public void exists_fileObjectCanIdentifyThatFileExists() {
//		File file=new File(DIRECTORY_PATH, EXISTING_FILE);
//		
//		assertTrue(file.exists());
//	}
	
	
}
