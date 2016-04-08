package phoneBook.Repositories;

import java.util.ArrayList;
import java.util.List;

import phoneBook.Entities.Contact;
import phoneBook.Entities.User;

public class ContactsRepository extends BaseRepository {

	public List<Contact> getByUserID(int id){
		List<Contact> contacts = new ArrayList<Contact>();
		
		return contacts;
	}
}
