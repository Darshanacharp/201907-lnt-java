package in.conceptarchitect.peoplemanagement;

import java.util.Collection;
import java.util.HashMap;

public class PeopleManagement {
	
	HashMap<Integer,Person> people=new HashMap<Integer,Person>();
	
	public static final PeopleManagement instance=new PeopleManagement();
	
	public PeopleManagement() {
		String [] names= {	"Vivek Dutta Mishra","Amit Singh","Chetan Deshmukh",
				"Sanjay Singh","Prabhat Kumar Mishra", "Vijay Kumar",
				"Seema Mishra","Shweta Mishra","Shivanshi Mishra"};

		int i=0;
		

		
		for(String name: names) {
			i++;
			addPerson(name,i);
			
		}
	}	
	

	private void addPerson(String name,int id) {
		// TODO Auto-generated method stub
		String [] tags= {"developer","social activist","photography","business" };
		
		Person p=new Person(id,name,name.toLowerCase().replace(" ", ".")+"@gmail.com", tags[id % tags.length]);
		people.put(id, p);
	}
	
	
	public Collection<Person> getPeople(){
		return people.values();
	}
	
	public Person getPersonById(int id) {
		if(!people.containsKey(id))
			throw new InfoNotFoundException();
		
		return people.get(id);
	}
	
	

}
