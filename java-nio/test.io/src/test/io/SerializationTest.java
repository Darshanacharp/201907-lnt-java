package test.io;


import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.bookmanagement.Book;

public class SerializationTest {
	
	String testFilePath="c:/temp/emp.db";
	ObjectOutputStream oos;
	FileOutputStream file;
	Book book1=new Book("The Count of Monte Cristo","Alexandre Dumas",400,9.1,"fiction,classic,best-seller,history");
	Book book2=new Book("Kane And Abel","Jeffrey Archer",150,7.2,"fiction,best-seller");
	Book book3=new Book("Summons","John Grisham",280,9.1,"legal fiction,best-seller");
	
	Book [] books;
	
	File testFile;
	
	@Before
	public void init() {
		testFile=new File(testFilePath);
		if(testFile.exists())
			testFile.delete();
		try {
			file=new FileOutputStream(testFile);
			oos=new ObjectOutputStream(file);
		}
		catch(IOException ex) {
			throw new RuntimeException("Error Initialization");
		}
		books=new Book[] { book1,book2,book3 };
	}
	
	
	@Test(expected=NotSerializableException.class)	
	public void  cantSaveNonSerializableObject() throws IOException {
		
		Person person=new Person("Vivek");
		oos.writeObject(person);
		oos.close();
		
		
		
		
	}

	
	@Test	
	public void  canSaveSerializableObject() throws IOException {
		
		oos.writeObject(books);
		oos.close();
		file.close();
		
		assertTrue(testFile.exists());
		
	}
	
	
	
	
	
}
