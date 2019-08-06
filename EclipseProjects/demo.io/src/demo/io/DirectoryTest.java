package demo.io;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeFalse;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class DirectoryTest {

	static final String DIRECTORY_PATH="C:\\MyWorks\\Corporate\\201907-lnt-java\\test_dir";
	File dir;
	
	@Before
	public void setUp() throws Exception {
		 dir=new File(DIRECTORY_PATH);
	}

	@Test
	public void file_isAValidDirectory() {
		
		assertTrue(dir.isDirectory());
	}
	
	@Test
	public void file_canCreateANewDirectory() {
		File newDir= new File(dir, "new-dir");
		
		assumeFalse(newDir.exists());
		
		
		newDir.mkdir();
		
		assertTrue(newDir.exists());
		assertTrue(newDir.isDirectory());
		
		newDir.delete();
		
	}
	
	@Test
	public void files_canListFilesFromADirectory() {
		
		File [] files=dir.listFiles();
		
		assertEquals(5, files.length);
		
	}

}
