package in.conceptarchitect.contacts;

import java.util.Random;

public class DummyContacts {
	
	public static  void createConacts() {
		
		String [] names= {"Vivek Dutta Mishra","Sanjay Mall","Amit Singh","Chetan Deskmukh"};
		
		for(String name :names)
			createContact(name);
		
		
	}
	
	private static void createContact(String name) {
		// TODO Auto-generated method stub
		String email=name.toLowerCase().replace(' ', '.')+"@gmail.com";
		String phone=generatePhoneNumber();
		String tags[]= {"friend","coworker","associte","doctor","driver"};
		int n=randome.nextInt(tags.length);
		Contact c=new Contact(name,email,phone, tags[n]);
		
		book.addContact(c);
		
		
	}
	static Random randome=new Random();
	
	private static String generatePhoneNumber() {
		// TODO Auto-generated method stub
		
		String str="9090999";
		
		int n=randome.nextInt(200)+100;
		
		return str+n;
		
	}

	static ContactBook book=ContactBook.getInstance();
	

}
