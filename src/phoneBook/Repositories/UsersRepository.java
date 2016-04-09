package phoneBook.Repositories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import phoneBook.Entities.User;

public class UsersRepository extends BaseRepository<User> {

	String filePath = "users.txt";
	
	public int getNextID()
    {
        User u = new User();
        try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			
			String line;
			
			while((line=br.readLine())!=null){				
				u.setId(Integer.parseInt(line));
				line=br.readLine();
				u.setName(line);
				line=br.readLine();
				u.setPassword(line);
				line=br.readLine();
				u.setUsername(line);
				//u.setContacts(new ContactsRepository().getByUserID(u.getId()));
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File is missing!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File is missing!");
			e.printStackTrace();
		}
        return u.getId()+1;
    }
	
	public List<User> getAll(){
		List<User> users = new ArrayList<User>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			
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
				u.setContacts(new ContactsRepository().getByUserID(u.getId()));
				
				users.add(u);
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File is missing!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File is missing!");
			e.printStackTrace();
		}
		
		
		return users;
	}
	
	public User getByID(int id){
		return readUserFromFile(id);		
	}
	
	@Override
	public void Insert(User u){
		u.setId(getNextID());
		
		try {
			PrintWriter pw = new PrintWriter(filePath);
			pw.println(u.getId());
			pw.println(u.getName());
			pw.println(u.getPassword());
			pw.println(u.getUsername());
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("Missing file");
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void Update(User u){
		List<User> users = getAll();
		
		for(int i=0;i<users.size();i++){
			if(users.get(i).getId() == u.getId()){
				users.get(i).setId(u.getId());
				users.get(i).setName(u.getName());
				users.get(i).setPassword(u.getPassword());
				users.get(i).setUsername(u.getUsername());				
			}
		}
		try {
			PrintWriter pw = new PrintWriter(filePath);
			for(int i=0;i<users.size();i++){
			
				pw.println(users.get(i).getId());
				pw.println(users.get(i).getName());
				pw.println(users.get(i).getPassword());
				pw.println(users.get(i).getUsername());
				
				} 
			pw.close();
			} catch (FileNotFoundException e) {
				System.out.println("Missing file");				
				e.printStackTrace();
			}			
		}	
	
	@Override	
	public void Delete(User u){
		List<User> users = getAll();
	
		try {
			PrintWriter pw = new PrintWriter(filePath);
			for(int i=0;i<users.size();i++){
				if(u.getId() != users.get(i).getId()){
					
					pw.println(users.get(i).getId());
					pw.println(users.get(i).getName());
					pw.println(users.get(i).getPassword());
					pw.println(users.get(i).getUsername());
				
				} 
			}
			pw.close();
			} catch (FileNotFoundException e) {
				System.out.println("Missing file");				
				e.printStackTrace();
			}	
	}
	
	@Override
	public void Save(User item) {
		if(readUserFromFile(item.getId())!=null)
			Update(item);
		else
			Insert(item);		
	}
	
	
	private User readUserFromFile(int id) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			
			String line;
			
			while((line=br.readLine())!=null){
				if(Integer.parseInt(line) == id){
					User u = new User();
					u.setId(Integer.parseInt(line));
					line=br.readLine();
					u.setName(line);
					line=br.readLine();
					u.setPassword(line);
					line=br.readLine();
					u.setUsername(line);
					u.setContacts(new ContactsRepository().getByUserID(u.getId()));
					br.close();
					return u;
				}
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File is missing!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File is missing!");
			e.printStackTrace();
		}
		
		return null;
	}

	
}
