package demo.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class NonExistingFileTest {

	static final String DIRECTORY_PATH="C:\\MyWorks\\Corporate\\201907-lnt-java\\test_dir";
	static final String NONEXISTANT_FILE="new-file.txt";
	File file;
	static final String PATH=DIRECTORY_PATH+"\\"+NONEXISTANT_FILE;
	
	@Before
	public void setUp() throws Exception {
		file=new File(PATH);
		
		
		
		
		assumeFalse(file.exists());
	}
	
	@After
	public void tearDown() {
		if(file.exists())
			file.delete();
	}

	@Test
	public void new_pathSuppliedToFileObjectMayNotExist() {
		
		assertNotNull(file);
	}
	
	@Test
	public void info_weCanFindPathRelatedInfoForNonExistingFilesAlso() {
		
		assertEquals(NONEXISTANT_FILE	, file.getName());
		assertEquals(DIRECTORY_PATH, file.getParent());		
		assertEquals(PATH, file.getAbsolutePath());
	}

	@Test
	public void exists_fileObjectCanIdentifyThatFileDoesnotExist() {
		
		assertFalse(file.exists());
	}
	
	@Test
	public void info_weReturns0LengthForANonExistingFile() {
		
		long length= file.length();
		
		assertEquals(0, length);
	}
	
	
	@Test
	public void info_lastModifiedReturnsBasedDateForANonExistingFile() {
		long elapsed= file.lastModified();
		Date date=new Date(elapsed);
		
		assertEquals(0,elapsed);
		
	}
	
	@Test
	public void create_canCreateNonExistingFile() throws IOException {
		
		boolean result=file.createNewFile();
		
		assertTrue(result);
		
		assertTrue(file.exists());
		
		
	}
	
//	
//	@Test
//	public void exists_fileObjectCanIdentifyThatFileExists() {
//		File file=new File(DIRECTORY_PATH, EXISTING_FILE);
//		
//		assertTrue(file.exists());
//	}
	
	
}
