package phoneBook;
import java.util.List;

import phoneBook.Entities.User;
import phoneBook.Renderers.MenuRenderer;
import phoneBook.Repositories.UsersRepository;;

public class PhoneBook {

	public static void main(String[] args) {	
		//printAll();
		MenuRenderer menu = new MenuRenderer();
		menu.renderMainMenu();
		
	}

	@SuppressWarnings("unused")
	private static void printAll() {
		UsersRepository userRepo = new UsersRepository();
		List<User> users = userRepo.getAll();
		//User u = userRepo.getByID(1);
		
		/*System.out.println("-------");
		System.out.println(u.getId());
		System.out.println(u.getName());
		System.out.println(u.getUsername());
		
		System.out.println("-------");*/
		
		for(int i=0;i<users.size();i++){
			System.out.println("###########");
			System.out.println("User "+(i+1));
			System.out.println(users.get(i).getId());
			System.out.println(users.get(i).getName());
			System.out.println(users.get(i).getUsername());
			
			for(int j=0; j<users.get(i).getContacts().size();j++){
				System.out.println("-------");
				System.out.println("Contact "+(j+1));
				System.out.println(users.get(i).getContacts().get(j).getId());
				System.out.println(users.get(i).getContacts().get(j).getName());
				System.out.println(users.get(i).getContacts().get(j).getUserId());
				
				for(int k=0; k<users.get(i).getContacts().get(j).getPhones().size();k++){
					System.out.println("-------");
					System.out.println("Phone "+(k+1));
					System.out.println(users.get(i).getContacts().get(j).getPhones().get(k).getId());
					System.out.println(users.get(i).getContacts().get(j).getPhones().get(k).getContactId());
					System.out.println(users.get(i).getContacts().get(j).getPhones().get(k).getNumber());
				}
			}
			System.out.println("###########");
		}
	}

}
