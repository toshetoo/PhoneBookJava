package phoneBook.Repositories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import phoneBook.Entities.User;

public class UsersRepository extends BaseRepository<User> {

	public List<User> getAll(){
		List<User> users = new ArrayList<User>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("users.txt"));
			
			String line;
			
			while((line=br.readLine())!=null){
				User u = new User();
				u.setId(Integer.parseInt(line));
				line=br.readLine();
				u.setName(line);
				line=br.readLine();
				u.setPassword(line);
				line=br.readLine();
				u.setUsername(line);
				//u.setContacts(new ContactsRepository().getByUserID(u.getId()));
				
				users.add(u);
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("File is missing!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File is missing!");
			e.printStackTrace();
		}
		
		
		return users;
	}
	public User GetByID(int id){
		User u = new User();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("users.txt"));
			
			String line;
			
			while((line=br.readLine())!=null){
				if(Integer.parseInt(line) == id){
					u.setId(Integer.parseInt(line));
					line=br.readLine();
					u.setName(line);
					line=br.readLine();
					u.setPassword(line);
					line=br.readLine();
					u.setUsername(line);
					u.setContacts(new ContactsRepository().getByUserID(u.getId()));
				}
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("File is missing!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File is missing!");
			e.printStackTrace();
		}
		
		return u;
		
	}
	public void Insert(User u){
		
	}
	public void Update(User u){
		
	}
	public void Delete(User u){
	
	}
}
