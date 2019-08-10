package in.conceptarchitect.contacts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class ContactBook implements Serializable{
	
	HashMap<String, Contact> contacts=new HashMap<>();
	private static  ContactBook instance=new ContactBook();
	public static ContactBook getInstance() {return instance;}
	
	static String path="C:\\MyWorks\\Corporate\\201907-lnt-java";
	
	
	static {
		ObjectInputStream is=null;
		try {
			is=new ObjectInputStream(new FileInputStream(path));
			instance=(ContactBook) is.readObject();
			
			
			
			
		}catch(Exception ex){
			instance=new ContactBook();
		}finally {try{is.close();}catch(Exception ex) {} };
		
		if(instance.contacts.size()==0) {
			DummyContacts.createConacts();
			instance.save();
		}
	}
	
	public void save() {
		ObjectOutputStream os=null;
		try {
			os=new ObjectOutputStream(new FileOutputStream(path));
			os.writeObject(this);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {try{os.close();}catch(Exception ex) {}};
		
	}
	
	public void addContact(Contact contact) {
		contacts.put(contact.getEmail().toLowerCase(), contact);
	}
	
	public Collection<Contact> getAllContacts(){
		return contacts.values();
	}
	
	public Contact getContact(String email) {
		return contacts.get(email.toLowerCase());
	}
	
	
}
