package phoneBook.Entities;

import java.util.List;

public class User extends BaseEntity {

	private String username;
	private String password;
	private String name;
	private List<Contact> contacts;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContact(Contact c) {
		this.contacts.add(c);
	}
	public void setContacts(List<Contact> c) {
		this.contacts = c;
	}
	
	
}
