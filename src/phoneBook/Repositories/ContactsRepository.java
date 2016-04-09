package phoneBook.Repositories;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import phoneBook.Entities.Contact;

public class ContactsRepository implements Repository<Contact> {

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
	
	public List<Contact> getAll() {
		
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
	
	public Contact getByID(int id) {
		
		return readContactFromFile(id);
	}

	
	public void Insert(Contact c) {
			c.setId(getNextID());
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(new File(filePath),true));
			pw.println(c.getId());
			pw.println(c.getUserId());
			pw.println(c.getName());					
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("Missing file");
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}

	public void Update(Contact c) {
		
		List<Contact> contacts = getAll();
		
		for(int i=0;i<contacts.size();i++){
			if(contacts.get(i).getId() == c.getId()){
				contacts.get(i).setId(c.getId());
				contacts.get(i).setName(c.getName());
				contacts.get(i).setUserId(c.getUserId());			
			}
		}
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(new File(filePath),true));
			for(int i=0;i<contacts.size();i++){
			
				pw.println(contacts.get(i).getId());
				pw.println(contacts.get(i).getUserId());
				pw.println(contacts.get(i).getName());			
				
				} 
			pw.close();
			} catch (FileNotFoundException e) {
				System.out.println("Missing file");				
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

	public void Delete(Contact c) {
		List<Contact> contacts = getAll();
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(new File(filePath),true));
			for(int i=0;i<contacts.size();i++){
				if(c.getId() != contacts.get(i).getId()){
					
					pw.println(contacts.get(i).getId());
					pw.println(contacts.get(i).getUserId());
					pw.println(contacts.get(i).getName());	
				} 
			}
			pw.close();
			} catch (FileNotFoundException e) {
				System.out.println("Missing file");				
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		
	}

	public void Save(Contact c) {
		if(readContactFromFile(c.getId())!=null)
			Update(c);
		else
			Insert(c);	
		
	}

	private Contact readContactFromFile(int id) {
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
}
