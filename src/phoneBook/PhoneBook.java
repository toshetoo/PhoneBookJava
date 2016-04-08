package phoneBook;
import java.util.List;

import phoneBook.Entities.User;
import phoneBook.Repositories.UsersRepository;;

public class PhoneBook {

	public static void main(String[] args) {
				
		UsersRepository userRepo = new UsersRepository();
		List<User> users = userRepo.getAll();
		User u = userRepo.GetByID(1);
		
		System.out.println("-------");
		System.out.println(u.getId());
		System.out.println(u.getName());
		System.out.println(u.getUsername());
		
		System.out.println("-------");
		for(int i=0;i<users.size();i++){
			System.out.println(users.get(i).getId());
			System.out.println(users.get(i).getName());
			System.out.println(users.get(i).getUsername());
			
		}
		
		
	}

}
