import java.util.Scanner;

import business.abstracts.CustomerService;
import business.concretes.CustomerListManager;
import entities.concretes.CustomerNode;

public class Main {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		CustomerService service = new CustomerListManager();
		CustomerNode customer;
		
		int selection = -1;
		int id = -1;
		String firstName = "";
		String lastName = "";
		String gender = "";
		String email = "";
		String product = "";
		
		System.out.println("\t\t\t\t\t\tWELCOME TO THE CUSTOMER REGISTRATION APPLICATION");
		while(selection != 0) {
			System.out.println("\n************************************************");
			System.out.println(
					"0- Exit." + 
					"\n1- Add customer to the top of the list." + 
					"\n2- Add customer to the end of the list." + 
					"\n3- Delete the customer." +
					"\n4- Search for customers." + 
					"\n5- Print the number of registered customers." +  
					"\n6- Print the customer list.\n"
					);
			System.out.print("Please choose one of them: ");
			selection = scan.nextInt();
			System.out.println("************************************************");
			
			if(selection == 1) {
				System.out.println("\n************************************************");
				System.out.println("Enter the customer information.");
				
				System.out.print("Customer id: ");
				id = scan.nextInt();
				
				scan.nextLine();
				System.out.print("First name: ");
				firstName = scan.nextLine().trim();
				
				System.out.print("Last name: ");
				lastName = scan.nextLine().trim().toUpperCase();
				
				System.out.print("Gender: ");
				gender = scan.nextLine().trim();
				
				System.out.print("Email: ");
				email = scan.nextLine().trim();
				
				System.out.print("Purchased product: ");
				product = scan.nextLine().trim();
			    
				customer = new CustomerNode(id, firstName, lastName, gender, email, product);
				service.insertFirst(customer);
				System.out.println("************************************************");
			}
			else if(selection == 2) {
				System.out.println("\n************************************************");
				System.out.println("Enter the customer information.");
				
				System.out.print("Customer id: ");
				id = scan.nextInt();
				
				scan.nextLine();
				System.out.print("First name: ");
				firstName = scan.nextLine().trim();
				
				System.out.print("Last name: ");
				lastName = scan.nextLine().trim().toUpperCase();
				
				System.out.print("Gender: ");
				gender = scan.nextLine().trim();
				
				System.out.print("Email: ");
				email = scan.nextLine().trim();
				
				System.out.print("Purchased product: ");
				product = scan.nextLine().trim();
			
				customer = new CustomerNode(id, firstName, lastName, gender, email, product);
				service.insertLast(customer);
				System.out.println("************************************************");
			}
			else if(selection == 3) {
				System.out.print("Enter the ID number of the customer to be deleted: ");
				int tempNumber = scan.nextInt();
				service.remove(tempNumber);
			}
			else if(selection == 4) {
				System.out.print("Enter the customer's number to be search:");
				int tempNumber = scan.nextInt();
				service.search(tempNumber);
			}
			else if(selection == 5)
				System.out.println("Number of registered customers: " + service.numberOfCustomers());
			else if(selection == 6)
				service.print();
			else if(selection == 0)
				System.out.println("Have a nice day..");
			else {
				System.out.println("Please enter a valid number.");
				break;
			}
		}
	}
}
