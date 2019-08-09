package in.conceptarchitect.peoplemanagement;

public class Person {
	
	int id;
	String name;
	String email;
	String tags;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public Person(int id, String name, String email, String tags) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.tags = tags;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", tags=" + tags + "]";
	}
	public Person() {
		super();
	}
	
	
	

}
