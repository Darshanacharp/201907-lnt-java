package in.conceptarchitect.contacts;

public class Contact {

	String name;
	String email;
	String phone;
	String tags;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public Contact(String name, String email, String phone, String tags) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.tags = tags;
	}
	public Contact() {
		super();
	}
	@Override
	public String toString() {
		return "Contact [name=" + name + ", email=" + email + ", phone=" + phone + ", tags=" + tags + "]";
	}
	
	
}
