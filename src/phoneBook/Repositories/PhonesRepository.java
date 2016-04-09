package phoneBook.Repositories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import phoneBook.Entities.Phone;

public class PhonesRepository implements Repository<Phone>{

	String filePath = "phones.txt";
	
	public int getNextID()
    {
        Phone p = new Phone();
        try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			
			String line;
			
			while((line=br.readLine())!=null){				
				p.setId(Integer.parseInt(line));
				line=br.readLine();
				p.setContactId(Integer.parseInt(line));
				line=br.readLine();
				p.setNumber(line);		
				
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File is missing!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File is missing!");
			e.printStackTrace();
		}
        return p.getId()+1;
    }
	
	public List<Phone> getAll() {
		
		List<Phone> phones = new ArrayList<Phone>();
        try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			
			String line;
			
			while((line=br.readLine())!=null){
				Phone p = new Phone();
				p.setId(Integer.parseInt(line));
				line=br.readLine();
				p.setContactId(Integer.parseInt(line));
				line=br.readLine();
				p.setNumber(line);					
				
				phones.add(p);
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File is missing!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File is missing!");
			e.printStackTrace();
		}
        
		return phones;
	}

	public Phone getByID(int id) {
		return readPhoneFromFile(id);
	}

	public List<Phone> getByContactID(int id){
		List<Phone> phones = new ArrayList<Phone>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			
			String line;
			
			while((line=br.readLine())!=null){
				Phone p = new Phone();
				p.setId(Integer.parseInt(line));
				line=br.readLine();
				p.setContactId(Integer.parseInt(line));
				line=br.readLine();
				p.setNumber(line);	
				
				if(p.getContactId()==id){
					phones.add(p);				
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
		return phones;
	}

	public void Insert(Phone p) {
		p.setId(getNextID());
		
		try {
			PrintWriter pw = new PrintWriter(filePath);
			pw.println(p.getId());
			pw.println(p.getContactId());
			pw.println(p.getNumber());					
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("Missing file");
			e.printStackTrace();
		}
	}

	public void Update(Phone p) {
		List<Phone> phones = getAll();
		
		for(int i=0;i<phones.size();i++){
			if(phones.get(i).getId() == p.getId()){
				phones.get(i).setId(p.getId());
				phones.get(i).setContactId(p.getContactId());	
				phones.get(i).setNumber(p.getNumber());
						
			}
		}
		try {
			PrintWriter pw = new PrintWriter(filePath);
			for(int i=0;i<phones.size();i++){
			
				pw.println(phones.get(i).getId());
				pw.println(phones.get(i).getContactId());
				pw.println(phones.get(i).getNumber());			
				
				} 
			pw.close();
			} catch (FileNotFoundException e) {
				System.out.println("Missing file");				
				e.printStackTrace();
			}
		
	}

	public void Delete(Phone p) {
		List<Phone> phones = getAll();
		
		try {
			PrintWriter pw = new PrintWriter(filePath);
			for(int i=0;i<phones.size();i++){
				if(p.getId() != phones.get(i).getId()){
					
					pw.println(phones.get(i).getId());
					pw.println(phones.get(i).getContactId());
					pw.println(phones.get(i).getNumber());	
				} 
			}
			pw.close();
			} catch (FileNotFoundException e) {
				System.out.println("Missing file");				
				e.printStackTrace();
			}	
		
	}

	public void Save(Phone p) {
		if(readPhoneFromFile(p.getId())!=null)
			Update(p);
		else
			Insert(p);
		
	}
	
	private Phone readPhoneFromFile(int id) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			
			String line;
			
			while((line=br.readLine())!=null){		
				Phone p = new Phone();
				p.setId(Integer.parseInt(line));
				line=br.readLine();
				p.setContactId(Integer.parseInt(line));
				line=br.readLine();
				p.setNumber(line);				
				
				if(p.getId()==id){
					br.close();
					return p;
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
