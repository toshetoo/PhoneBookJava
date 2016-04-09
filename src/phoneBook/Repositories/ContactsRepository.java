package phoneBook.Repositories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import phoneBook.Entities.Contact;
import phoneBook.Entities.User;

public class ContactsRepository extends BaseRepository<Contact> {

	String filePath = "contacts.txt";
	
	public int getNextID()
    {
        Contact c = new Contact();
        try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			
			String line;
			
			while((line=br.readLine())!=null){				
				c.setId(Integer.parseInt(line));
				line=br.readLine();
				c.setUserId(Integer.parseInt(line));
				line=br.readLine();
				c.setName(line);				
				//c.setPhones(new PhonesRepository().getByContactID(c.getId()));
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File is missing!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File is missing!");
			e.printStackTrace();
		}
        return c.getId()+1;
    }
	
	@Override
	protected List<Contact> getAll() {
		
		List<Contact> contacts = new ArrayList<Contact>();
        try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			
			String line;
			
			while((line=br.readLine())!=null){
				Contact c = new Contact();
				c.setId(Integer.parseInt(line));
				line=br.readLine();
				c.setUserId(Integer.parseInt(line));
				line=br.readLine();
				c.setName(line);				
				c.setPhones(new PhonesRepository().getByContactID(c.getId()));
				
				contacts.add(c);
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File is missing!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File is missing!");
			e.printStackTrace();
		}
        
		return contacts;
	}

	public List<Contact> getByUserID(int id){
		
		List<Contact> contacts = new ArrayList<Contact>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			
			String line;
			
			while((line=br.readLine())!=null){
				Contact c = new Contact();
				c.setId(Integer.parseInt(line));
				line=br.readLine();
				c.setUserId(Integer.parseInt(line));
				line=br.readLine();
				c.setName(line);				
				c.setPhones(new PhonesRepository().getByContactID(c.getId()));
				
				if(c.getUserId()==id){
					contacts.add(c);				
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
		return contacts;
	}
	
	@Override
	protected Contact getByID(int id) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			
			String line;
			
			while((line=br.readLine())!=null){		
				Contact c = new Contact();
				c.setId(Integer.parseInt(line));
				line=br.readLine();
				c.setUserId(Integer.parseInt(line));
				line=br.readLine();
				c.setName(line);				
				c.setPhones(new PhonesRepository().getByContactID(c.getId()));
				
				if(c.getId()==id){
					br.close();
					return c;
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

	@Override
	protected void Insert(Contact item) {
			item.setId(getNextID());
		
		try {
			PrintWriter pw = new PrintWriter(filePath);
			pw.println(item.getId());
			pw.println(item.getUserId());
			pw.println(item.getName());					
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("Missing file");
			e.printStackTrace();
		}
		
	}

	@Override
	protected void Update(Contact c) {
		
		List<Contact> contacts = getAll();
		
		for(int i=0;i<contacts.size();i++){
			if(contacts.get(i).getId() == c.getId()){
				contacts.get(i).setId(c.getId());
				contacts.get(i).setName(c.getName());
				contacts.get(i).setUserId(c.getUserId());			
			}
		}
		try {
			PrintWriter pw = new PrintWriter(filePath);
			for(int i=0;i<contacts.size();i++){
			
				pw.println(contacts.get(i).getId());
				pw.println(contacts.get(i).getUserId());
				pw.println(contacts.get(i).getName());			
				
				} 
			pw.close();
			} catch (FileNotFoundException e) {
				System.out.println("Missing file");				
				e.printStackTrace();
			}
		
	}

	@Override
	protected void Delete(Contact item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void Save(Contact item) {
		// TODO Auto-generated method stub
		
	}

	
}
