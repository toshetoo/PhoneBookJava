package phoneBook.Renderers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import phoneBook.Entities.User;
import phoneBook.Repositories.UsersRepository;

public class MenuRenderer {

	public void renderMainMenu(){
		clearConsole();
		System.out.println("Select a category:");
		System.out.println("1. Users");
		System.out.println("2. Contacts");
		System.out.println("3. Phones");
		String input = readFromConsole();
		
		switch(input){
		case "1": renderUsersMenu(); break;
		case "2": renderContactsMenu(); break;
		case "3": renderPhonesMenu(); break;
		default: 
			System.out.println("Invalid selection! Try again!");
			clearConsole();
			renderMainMenu(); 
			break;
		}
	}
	
	/*----Sub menus----*/
	private void renderUsersMenu(){
		clearConsole();
		System.out.println("Users");
		System.out.println("-----------");
		System.out.println("Select a category:");
		System.out.println("1. Insert");
		System.out.println("2. Update");
		System.out.println("3. Delete");
		System.out.println("4. Print specific user");
		System.out.println("5. Print all users");
		System.out.println("6. Return to main menu");
		
		String input = readFromConsole();
		
		switch(input){
		case "1": renderInsertUserMenu(); break;
		case "2": renderUpdateUserMenu(); break;
		case "3": renderDeleteUserMenu(); break;
		case "4": renderPrintSpecificUserMenu(); break;
		case "5": renderPrintAllUsersMenu(); break;
		case "6": renderMainMenu(); break;
		default: 
			System.out.println("Invalid selection! Try again!");
			sleep();
			clearConsole();
			renderUsersMenu(); 
			break;
		}
		
	}
	
	private void renderContactsMenu(){
		clearConsole();
		System.out.println("Contacts");
		System.out.println("-----------");
		System.out.println("Select a category:");
		System.out.println("1. Insert");
		System.out.println("2. Update");
		System.out.println("3. Delete");
		System.out.println("4. Print specific contact");
		System.out.println("5. Print all contacts");
		System.out.println("6. Return to main menu");
		
		String input = readFromConsole();
		
		switch(input){
		case "1": renderInsertContactMenu(); break;
		case "2": renderUpdateContactMenu(); break;
		case "3": renderDeleteContactMenu(); break;
		case "4": renderPrintSpecificContactMenu(); break;
		case "5": renderPrintAllContactsMenu(); break;
		case "6": renderMainMenu(); break;
		default: 
			System.out.println("Invalid selection! Try again!");
			sleep();
			clearConsole();
			renderContactsMenu(); 
			break;
		}
		
	}
	
	private void renderPhonesMenu(){
		clearConsole();
		System.out.println("Phones");
		System.out.println("-----------");
		System.out.println("Select a category:");
		System.out.println("1. Insert");
		System.out.println("2. Update");
		System.out.println("3. Delete");
		System.out.println("4. Print specific phone");
		System.out.println("5. Print all phones");
		System.out.println("6. Return to main menu");
		
		String input = readFromConsole();
		
		switch(input){
		case "1": renderInsertPhoneMenu(); break;
		case "2": renderUpdatePhoneMenu(); break;
		case "3": renderDeletePhoneMenu(); break;
		case "4": renderPrintSpecificPhoneMenu(); break;
		case "5": renderPrintAllPhonesMenu(); break;
		case "6": renderMainMenu(); break;
		default: 
			System.out.println("Invalid selection! Try again!");
			sleep();
			clearConsole();
			renderPhonesMenu(); 
			break;
		}
	}
	
	/*---Users Sub menus----*/
	private void renderInsertUserMenu(){
		clearConsole();
		System.out.println("Insert user");
		System.out.println("-----------");
		
		User u = new User();
		System.out.println("Insert name:");
		u.setName(readFromConsole());
		System.out.println("Insert username:");
		u.setUsername(readFromConsole());
		System.out.println("Insert password:");
		u.setPassword(readFromConsole());
		
		System.out.println("Saving user....");
		sleep();
		UsersRepository userRepo = new UsersRepository();
		userRepo.Save(u);
		System.out.println("User saved! Returning to main menu...");
		sleep();
		clearConsole();
		renderUsersMenu();
	}
	
	private void renderUpdateUserMenu(){
		
	}
	
	private void renderDeleteUserMenu(){
		
	}
	
	private void renderPrintSpecificUserMenu(){
		
	}
	
	private void renderPrintAllUsersMenu(){
		
	}
	
	/*---Contacts Sub menus---*/
	private void renderInsertContactMenu(){
		
	}
	
	private void renderUpdateContactMenu(){
		
	}
	
	private void renderDeleteContactMenu(){
		
	}
	
	private void renderPrintSpecificContactMenu(){
		
	}

	private void renderPrintAllContactsMenu(){
		
	}
	
	/*---Phones Sub menus---*/
	private void renderInsertPhoneMenu(){
		
	}
	
	private void renderUpdatePhoneMenu(){
		
	}
	
	private void renderDeletePhoneMenu(){
		
	}
	
	private void renderPrintSpecificPhoneMenu(){
		
	}

	private void renderPrintAllPhonesMenu(){
		
	}
	
	private void clearConsole(){
		for(int clear = 0; clear < 1000; clear++) {
		    System.out.println();
		}
	}

	private String readFromConsole(){
		String input;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        try {
			 input = br.readLine();
			 return input;
		} catch (IOException e) {
			System.out.println("Invalid string");
			e.printStackTrace();
		}
		return null;
	}

	private void sleep() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
}
