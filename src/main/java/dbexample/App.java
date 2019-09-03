package dbexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.PersonDao;
import objects.Person;

/*what you'll do
 * 1. Look through the code and understand what's happening...
 * 2. In your person Dao, create new methods for update, delete, and query
 * 		-for update, reference the insert method as they might be similar
 * 		-for query, maybe query by username or something else, maybe even ID.
 *Remember to update your method calls within the switch statement as well.  
 */

public class App {

	public static void main(String[] args) {
		String choice = "";
		Scanner input = new Scanner(System.in);
		
		while(!choice.equalsIgnoreCase("quit")) {
			System.out.println("Select from: query, insert, delete, quit");
			choice = input.nextLine();
			
			switch(choice) {
			case "query":
				query();
				break;
			case "insert":
				insert();
				break;
			case "delete":
				//TODO implement meeeee
				break;
			case "quit":
				System.out.println("byeee");
				return;
				
			default:
				System.out.println("Invalid choice");
				break;
			}
		}
		
		
		
	}
	
	private static void query() {
		ArrayList<Person> people = new PersonDao().getPeople();
		for(Person p:people) {
			System.out.println(p.toString());
		}
	}
	
	private static void insert() {
		Person p = new Person();
		System.out.println("enter username: ");
		Scanner s = new Scanner(System.in);
		p.setUsername(s.nextLine());
		System.out.println("enter password: ");
		p.setPassword(s.nextLine());
		System.out.println("enter first name: ");
		p.setFirstname(s.nextLine());
		System.out.println("enter last name: ");
		p.setLastname(s.nextLine());
		System.out.println("enter brief description about user");
		p.setDescription(s.nextLine());
		
		new PersonDao().insertPerson(p);
	}
	
	
	/*Implement the delete method here which should use the person dao
	 
	 */
	
	/*
	private static void delete() {
		
	}
	*/

}
