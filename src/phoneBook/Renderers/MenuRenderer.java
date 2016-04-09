package phoneBook.Renderers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import phoneBook.Entities.Contact;
import phoneBook.Entities.Phone;
import phoneBook.Entities.User;
import phoneBook.Repositories.ContactsRepository;
import phoneBook.Repositories.PhonesRepository;
import phoneBook.Repositories.UsersRepository;

@SuppressWarnings("unused")
public class MenuRenderer {

	public void renderMainMenu(){
		//clearConsole();
		System.out.println("Select a category:");
		System.out.println("1. Users");
		System.out.println("2. Contacts");
		System.out.println("3. Phones");
		System.out.println("4. Exit");
		String input = readFromConsole();
		
		switch(input){
		case "1": renderUsersMenu(); break;
		case "2": renderContactsMenu(); break;
		case "3": renderPhonesMenu(); break;
		case "4": System.exit(0);break;
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
		renderMenusHeader("Users");
		
		String input = readFromConsole();
		
		switch(input){
		case "1": renderInsertUserMenu(); break;
		case "2": renderUpdateUserMenu(); break;
		case "3": renderDeleteUserMenu(); break;
		case "4": renderPrintSpecificUserMenu(); break;
		case "5": renderPrintAllUsersMenu(); break;
		case "6": 
			clearConsole();
			renderMainMenu(); break;
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
		renderMenusHeader("Contacts");
		
		String input = readFromConsole();
		
		switch(input){
		case "1": renderInsertContactMenu(); break;
		case "2": renderUpdateContactMenu(); break;
		case "3": renderDeleteContactMenu(); break;
		case "4": renderPrintSpecificContactMenu(); break;
		case "5": renderPrintAllContactsMenu(); break;
		case "6": 
			clearConsole();
			renderMainMenu(); break;
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
		renderMenusHeader("Phones");
		
		String input = readFromConsole();
		
		switch(input){
		case "1": renderInsertPhoneMenu(); break;
		case "2": renderUpdatePhoneMenu(); break;
		case "3": renderDeletePhoneMenu(); break;
		case "4": renderPrintSpecificPhoneMenu(); break;
		case "5": renderPrintAllPhonesMenu(); break;
		case "6": 
			clearConsole();
			renderMainMenu(); break;
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
		clearConsole();
		System.out.println("Edit user");
		System.out.println("-----------");
		
		UsersRepository userRepo = new UsersRepository();
		List<User> users = new ArrayList<User>();
		users = userRepo.getAll();
		
		System.out.println("Which user do you like to edit?");
		
		for(int i=0;i<users.size();i++){
			System.out.println((i+1) + ". " + users.get(i).getName());
		}
		
		String input = readFromConsole();
		if(Integer.parseInt(input)-1>users.size() || Integer.parseInt(input)-1< 0){
			System.out.println("Invalid ID. Try again!");
			sleep();			
			renderUpdateUserMenu();
		}
		else{
			System.out.println("You have selected the user "+ users.get(Integer.parseInt(input)-1).getName());
			System.out.println("ID: "+ users.get(Integer.parseInt(input)-1).getId());	
			System.out.println("Username: "+ users.get(Integer.parseInt(input)-1).getUsername());	
			System.out.println("Password: "+ users.get(Integer.parseInt(input)-1).getPassword());	
		}
		
		System.out.println("-------");
		System.out.println("Enter new name:");
		users.get(Integer.parseInt(input)-1).setName(readFromConsole());
		System.out.println("Enter new username:");
		users.get(Integer.parseInt(input)-1).setUsername(readFromConsole());;
		System.out.println("Enter new password:");
		users.get(Integer.parseInt(input)-1).setPassword(readFromConsole());
		
		System.out.println("Saving user....");
		sleep();
		
		userRepo.Save(users.get(Integer.parseInt(input)-1));
		System.out.println("User saved! Returning to main menu...");
		sleep();
		clearConsole();
		renderUsersMenu();				
			
	}
	
	private void renderDeleteUserMenu(){
		clearConsole();
		System.out.println("Delete user");
		System.out.println("-----------");
		
		UsersRepository userRepo = new UsersRepository();
		List<User> users = new ArrayList<User>();
		users = userRepo.getAll();
		
		System.out.println("Which user do you like to delete?");
		
		for(int i=0;i<users.size();i++){
			System.out.println((i+1) + ". " + users.get(i).getName());
		}
		
		String input = readFromConsole();
		if(Integer.parseInt(input)-1>users.size() || Integer.parseInt(input)-1< 0){
			System.out.println("Invalid ID. Try again!");
			sleep();			
			renderUpdateUserMenu();
		}
		else{
			System.out.println("You have selected the user "+ users.get(Integer.parseInt(input)-1).getName());
			sleep();
			System.out.println("Deleting user....");
			sleep();
			userRepo.Delete(users.get(Integer.parseInt(input)-1));
			System.out.println("User deleted! Returning to main menu...");
			sleep();
			clearConsole();
			renderUsersMenu();	
		}	
	}
	
	private void renderPrintSpecificUserMenu(){
		clearConsole();
		System.out.println("Print user");
		System.out.println("-----------");
		
		UsersRepository userRepo = new UsersRepository();
		List<User> users = new ArrayList<User>();
		users = userRepo.getAll();
		
		System.out.println("Which user do you like to print?");
		
		for(int i=0;i<users.size();i++){
			System.out.println((i+1) + ". " + users.get(i).getName());
		}
		
		String input = readFromConsole();
		if(Integer.parseInt(input)-1>users.size() || Integer.parseInt(input)-1< 0){
			System.out.println("Invalid ID. Try again!");
			sleep();			
			renderUpdateUserMenu();
		}
		else{
			System.out.println("You have selected the user "+ users.get(Integer.parseInt(input)-1).getName());
			System.out.println("ID: "+ users.get(Integer.parseInt(input)-1).getId());	
			System.out.println("Username: "+ users.get(Integer.parseInt(input)-1).getUsername());	
			System.out.println("Password: "+ users.get(Integer.parseInt(input)-1).getPassword());	
		}
		
		System.out.println("Enter any char to return to menu....");
		String answer = readFromConsole();
		sleep();
		clearConsole();
		renderUsersMenu();	
	}
	
	private void renderPrintAllUsersMenu(){
		clearConsole();
		System.out.println("List of all users");
		System.out.println("------------");
		UsersRepository userRepo = new UsersRepository();
		List<User> users = userRepo.getAll();
		
		for(int i=0;i<users.size();i++){
			System.out.println("###########");
			System.out.println("User "+(i+1));
			System.out.println(users.get(i).getId());
			System.out.println(users.get(i).getName());
			System.out.println(users.get(i).getUsername());
		}
		
		System.out.println("Enter any char to return to menu....");
		String answer = readFromConsole();
		sleep();
		clearConsole();
		renderUsersMenu();
	}
	
	/*---Contacts Sub menus---*/
	private void renderInsertContactMenu(){
		clearConsole();
		System.out.println("Insert contact");
		System.out.println("-----------");
		
		Contact c = new Contact();
		System.out.println("Insert name:");
		c.setName(readFromConsole());
		
		System.out.println("Choose a user to asing the contact to:");
		UsersRepository userRepo = new UsersRepository();
		List<User> users = userRepo.getAll();
		
		for(int i=0;i<users.size();i++){
			System.out.println("-----");
			System.out.println("User "+(i+1));
			System.out.println(users.get(i).getId() + " " + users.get(i).getName());			
		}
		
		System.out.println("Insert user id:");
		c.setUserId(Integer.parseInt(readFromConsole())-1);		
		
		System.out.println("Saving user....");
		sleep();
		ContactsRepository contactsRepo = new ContactsRepository();
		contactsRepo.Save(c);
		System.out.println("Contact saved! Returning to main menu...");
		sleep();
		clearConsole();
		renderContactsMenu();
	}
	
	private void renderUpdateContactMenu(){
		clearConsole();
		System.out.println("Edit contact");
		System.out.println("-----------");
		
		ContactsRepository contactsRepo = new ContactsRepository();
		List<Contact> contacts = new ArrayList<Contact>();
		contacts = contactsRepo.getAll();
		
		System.out.println("Which contact do you like to edit?");
		
		for(int i=0;i<contacts.size();i++){
			System.out.println((i+1) + ". " + contacts.get(i).getName());
		}
		
		String input = readFromConsole();
		if(Integer.parseInt(input)-1>contacts.size() || Integer.parseInt(input)-1< 0){
			System.out.println("Invalid ID. Try again!");
			sleep();			
			renderUpdateContactMenu();
		}
		else{
			System.out.println("You have selected the contact "+ contacts.get(Integer.parseInt(input)-1).getName());
			System.out.println("ID: "+ contacts.get(Integer.parseInt(input)-1).getId());	
			System.out.println("Name: "+ contacts.get(Integer.parseInt(input)-1).getName());
		}
		
		System.out.println("-------");
		System.out.println("Enter new name:");
		contacts.get(Integer.parseInt(input)-1).setName(readFromConsole());
		
		System.out.println("Saving contact....");
		sleep();
		
		contactsRepo.Save(contacts.get(Integer.parseInt(input)-1));
		System.out.println("Contact saved! Returning to main menu...");
		sleep();
		clearConsole();
		renderContactsMenu();
	}
	
	private void renderDeleteContactMenu(){
		clearConsole();
		System.out.println("Delete contact");
		System.out.println("-----------");
		
		ContactsRepository contactsRepo = new ContactsRepository();
		List<Contact> contacts = new ArrayList<Contact>();
		contacts = contactsRepo.getAll();
		
		System.out.println("Which contact do you like to delete?");
		
		for(int i=0;i<contacts.size();i++){
			System.out.println((i+1) + ". " + contacts.get(i).getName());
		}
		
		String input = readFromConsole();
		if(Integer.parseInt(input)-1>contacts.size() || Integer.parseInt(input)-1< 0){
			System.out.println("Invalid ID. Try again!");
			sleep();			
			renderUpdateContactMenu();
		}
		else{
			System.out.println("You have selected the contact "+ contacts.get(Integer.parseInt(input)-1).getName());
			sleep();
			System.out.println("Deleting contact....");
			sleep();
			contactsRepo.Delete(contacts.get(Integer.parseInt(input)-1));
			System.out.println("Contact deleted! Returning to main menu...");
			sleep();
			clearConsole();
			renderContactsMenu();	
		}
	}
	
	private void renderPrintSpecificContactMenu(){
		clearConsole();
		System.out.println("Print specific contact");
		System.out.println("-----------");
		
		ContactsRepository contactsRepo = new ContactsRepository();
		List<Contact> contacts = new ArrayList<Contact>();
		contacts = contactsRepo.getAll();
		
		System.out.println("Which contact do you like to print?");
		
		for(int i=0;i<contacts.size();i++){
			System.out.println((i+1) + ". " + contacts.get(i).getName());
		}
		
		String input = readFromConsole();
		if(Integer.parseInt(input)-1>contacts.size() || Integer.parseInt(input)-1< 0){
			System.out.println("Invalid ID. Try again!");
			sleep();			
			renderUpdateContactMenu();
		}
		else{
			System.out.println("You have selected the contact "+ contacts.get(Integer.parseInt(input)-1).getName());
			System.out.println("ID: "+ contacts.get(Integer.parseInt(input)-1).getId());	
			System.out.println("Name: "+ contacts.get(Integer.parseInt(input)-1).getName());
		}
		
		System.out.println("Enter any char to return to menu....");
		String answer = readFromConsole();
		sleep();
		clearConsole();
		renderContactsMenu();	
	}

	private void renderPrintAllContactsMenu(){
		clearConsole();
		System.out.println("List of all contacts");
		System.out.println("------------");
		
		ContactsRepository contactsRepo = new ContactsRepository();
		List<Contact> contacts = new ArrayList<Contact>();
		contacts = contactsRepo.getAll();
		
		for(int i=0; i<contacts.size();i++){
			System.out.println("-------");
			System.out.println("Contact "+(i+1));
			System.out.println(contacts.get(i).getId());
			System.out.println(contacts.get(i).getName());
			System.out.println(contacts.get(i).getUserId());
		}
		System.out.println("Enter any char to return to menu....");
		String answer = readFromConsole();
		sleep();
		clearConsole();
		renderContactsMenu();
	}
	
	/*---Phones Sub menus---*/
	private void renderInsertPhoneMenu(){
		clearConsole();
		System.out.println("Insert Phone");
		System.out.println("-----------");
		
		Phone p = new Phone();
		System.out.println("Choose a contact to asing the phone to:");
		ContactsRepository contactsRepo = new ContactsRepository();
		List<Contact> contacts = contactsRepo.getAll();
		
		for(int i=0;i<contacts.size();i++){
			System.out.println("-----");
			System.out.println("Contact "+(i+1));
			System.out.println(contacts.get(i).getId() + " " + contacts.get(i).getName());			
		}
		
		System.out.println("Insert contact id:");
		p.setContactId(Integer.parseInt(readFromConsole())-1);	
		
		System.out.println("Insert number:");
		p.setNumber(readFromConsole());
		
		System.out.println("Saving phone....");
		sleep();
		PhonesRepository phonesRepo = new PhonesRepository();
		phonesRepo.Save(p);
		System.out.println("Phone saved! Returning to main menu...");
		sleep();
		clearConsole();
		renderPhonesMenu();
	}
	
	private void renderUpdatePhoneMenu(){
		clearConsole();
		System.out.println("Edit phone");
		System.out.println("-----------");
		
		PhonesRepository phonesRepo = new PhonesRepository();
		List<Phone> phones = new ArrayList<Phone>();
		phones = phonesRepo.getAll();
		
		System.out.println("Which phone do you like to edit?");
		
		for(int i=0;i<phones.size();i++){
			System.out.println((i+1) + ". " + phones.get(i).getNumber());
		}
		
		String input = readFromConsole();
		if(Integer.parseInt(input)-1>phones.size() || Integer.parseInt(input)-1< 0){
			System.out.println("Invalid ID. Try again!");
			sleep();			
			renderUpdateContactMenu();
		}
		else{
			System.out.println("You have selected the phone "+ phones.get(Integer.parseInt(input)-1).getNumber());
			System.out.println("ID: "+ phones.get(Integer.parseInt(input)-1).getId());				
		}
		
		System.out.println("-------");
		System.out.println("Enter new number:");
		phones.get(Integer.parseInt(input)-1).setNumber(readFromConsole());
		
		System.out.println("Saving phone....");
		sleep();
		
		phonesRepo.Save(phones.get(Integer.parseInt(input)-1));
		System.out.println("Phone saved! Returning to main menu...");
		sleep();
		clearConsole();
		renderPhonesMenu();
	}
	
	private void renderDeletePhoneMenu(){
		clearConsole();
		System.out.println("Delete phone");
		System.out.println("-----------");
		
		PhonesRepository phonesRepo = new PhonesRepository();
		List<Phone> phones = new ArrayList<Phone>();
		phones = phonesRepo.getAll();
		
		System.out.println("Which phone do you like to delete?");
		
		for(int i=0;i<phones.size();i++){
			System.out.println((i+1) + ". " + phones.get(i).getNumber());
		}
		
		String input = readFromConsole();
		if(Integer.parseInt(input)-1>phones.size() || Integer.parseInt(input)-1< 0){
			System.out.println("Invalid ID. Try again!");
			sleep();			
			renderUpdateContactMenu();
		}
		else{
			System.out.println("You have selected the phone "+ phones.get(Integer.parseInt(input)-1).getNumber());
			System.out.println("ID: "+ phones.get(Integer.parseInt(input)-1).getId());
			
			sleep();
			System.out.println("Deleting phone....");
			sleep();
			phonesRepo.Delete(phones.get(Integer.parseInt(input)-1));
			System.out.println("Phone deleted! Returning to main menu...");
			sleep();
			clearConsole();
			renderPhonesMenu();	
		}
		
	}
	
	private void renderPrintSpecificPhoneMenu(){
		clearConsole();
		System.out.println("Print specific phone");
		System.out.println("-----------");
		
		PhonesRepository phonesRepo = new PhonesRepository();
		List<Phone> phones = new ArrayList<Phone>();
		phones = phonesRepo.getAll();
		
		System.out.println("Which phone do you like to print?");
		
		for(int i=0;i<phones.size();i++){
			System.out.println((i+1) + ". " + phones.get(i).getNumber());
		}
		
		String input = readFromConsole();
		if(Integer.parseInt(input)-1>phones.size() || Integer.parseInt(input)-1< 0){
			System.out.println("Invalid ID. Try again!");
			sleep();			
			renderUpdateContactMenu();
		}
		else{
			System.out.println("You have selected the phone "+ phones.get(Integer.parseInt(input)-1).getNumber());
			System.out.println("ID: "+ phones.get(Integer.parseInt(input)-1).getId());				
		}
		
		System.out.println("Enter any char to return to menu....");
		String answer = readFromConsole();
		sleep();
		clearConsole();
		renderPhonesMenu();
	}

	private void renderPrintAllPhonesMenu(){
		clearConsole();
		System.out.println("Print specific phone");
		System.out.println("-----------");
		
		PhonesRepository phonesRepo = new PhonesRepository();
		List<Phone> phones = new ArrayList<Phone>();
		phones = phonesRepo.getAll();
		
		for(int i=0; i<phones.size();i++){
			System.out.println("-------");
			System.out.println("Phone "+(i+1));
			System.out.println(phones.get(i).getId());
			System.out.println(phones.get(i).getNumber());
			
		}
		System.out.println("Enter any char to return to menu....");
		String answer = readFromConsole();
		sleep();
		clearConsole();
		renderPhonesMenu();
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
	
	private void renderMenusHeader(String category) {
		System.out.println(category);
		System.out.println("-----------");
		System.out.println("Select a category:");
		System.out.println("1. Insert");
		System.out.println("2. Update");
		System.out.println("3. Delete");
		System.out.println("4. Print specific " + category.toLowerCase());
		System.out.println("5. Print all " + category.toLowerCase());
		System.out.println("6. Return to main menu");
	}
	
	private void sleep() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
}
