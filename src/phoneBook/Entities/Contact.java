package phoneBook.Entities;

import java.util.List;

public class Contact extends BaseEntity{

	private int userId;	
	private String name;
	private List<Phone> phones;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Phone> getPhones() {
		return phones;
	}
	public void setPhone(Phone e) {
		this.phones.add(e);
	}
	public void setPhones(List<Phone> p) {
		this.phones = p;
	}
}
