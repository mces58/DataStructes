import java.util.Scanner;

import business.abstracts.BakerService;
import business.concretes.BakerManager;
import entities.concretes.BakerNode;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the number of elements of the queue: ");
		int capacity = scan.nextInt();
		
		BakerService service = new BakerManager(capacity);
		BakerNode customer;
		
		int selection = -1;
		String name = "";
		int number = -1;
		
		while(selection != 0) {
			System.out.println(
					"\n0-Sign out.\n" + 
					"1-Add customer to queue.\n" +
					"2-Sell bread.\n" + 
					"3-Show customers waiting in queue.\n" + 
					"4-Show total revenue." 
					);
			System.out.print("\nChoose one of the above actions: ");
			selection = scan.nextInt();
			
			switch(selection) {
			case 1:
				scan.nextLine();
				System.out.print("Enter the customer's name: ");
				name = scan.nextLine();
				System.out.print("Enter the number of breads: ");
				number = scan.nextInt();
				
				customer = new BakerNode(name, number);
				service.enQueue(customer);
				break;
			case 2:
				System.out.println(service.deQueue());
				break;
			case 3:
				service.print();
				break;
			case 4: 
				System.out.println("Your total income: " + service.totalRevenue() + " ₺.");
				break;
			case 0:
				System.out.println("Have a nice day..");
				break;
			default:
				System.err.println("Incorrect operation!!");
				selection = 0;
			}
		}
	}
}
