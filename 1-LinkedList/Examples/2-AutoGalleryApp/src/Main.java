import java.util.Scanner;

import business.abstracts.AutoGalleryService;
import business.concretes.AutoGalleryListManager;
import entities.concretes.AutoGalleryNode;

public class Main {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		AutoGalleryService service = new AutoGalleryListManager();
		AutoGalleryNode car;
		
		int selection = -1;
		String vrp = "";
		String brand = "";
		int model = -1;
		String color = "";
		String fuelType = "";
		double hp = -1;
		double purchasePrice = -1;
		
		System.out.println("\t\t\t\t\t\tWELCOME TO THE CAR REGISTRATION APPLICATION");
		while(selection != 0) {
			System.out.println("\n************************************************");
			System.out.println(
					"0- Exit." + 
					"\n1- Add car to the top of the list." + 
					"\n2- Add car to the end of the list." + 
					"\n3- Sell the car." +
					"\n4- Search for cars." + 
					"\n5- Print the number of registered cars." +  
					"\n6- Print car list.\n"
					);
			System.out.print("Please choose one of them: ");
			selection = scan.nextInt();
			System.out.println("************************************************");
			
			if(selection == 1) {
				System.out.println("\n************************************************");
				System.out.println("Enter the car information.");
				
				scan.nextLine();
				System.out.print("VRP: ");				
				vrp = scan.nextLine().trim().replaceAll("\t", "-").replaceAll("\s", "-").toUpperCase();

				System.out.print("Brand: ");
				brand = scan.nextLine().trim();
				
				System.out.print("Model: ");
				model = scan.nextInt();
				
				scan.nextLine();
				System.out.print("Color: ");
				color = scan.nextLine().trim();
				
				System.out.print("Fuel type: ");
				fuelType= scan.nextLine().trim();
				
				System.out.print("HP: ");
				hp = scan.nextDouble();
				
				System.out.print("Purchase price: ");
				purchasePrice = scan.nextDouble();
			    
				car = new AutoGalleryNode(vrp, brand, model, color, fuelType, hp, purchasePrice);
				service.insertFirst(car);
				System.out.println("************************************************");
			}
			else if(selection == 2) {
				System.out.println("\n************************************************");
				System.out.println("Enter the car information.");
				
				scan.nextLine();
				System.out.print("VRP: ");
				vrp = scan.nextLine().trim().replaceAll("\t", "-").replaceAll("\s", "-").toUpperCase();
				
				System.out.print("Brand: ");
				brand = scan.nextLine().trim();
				
				System.out.print("Model: ");
				model = scan.nextInt();
				
				scan.nextLine();
				System.out.print("Color: ");
				color = scan.nextLine().trim();
				
				System.out.print("Fuel type: ");
				fuelType= scan.nextLine().trim();
				
				System.out.print("HP: ");
				hp = scan.nextDouble();
				
				System.out.print("Purchase price: ");
				purchasePrice = scan.nextDouble();
			    
				car = new AutoGalleryNode(vrp, brand, model, color, fuelType, hp, purchasePrice);
				service.insertLast(car);
				System.out.println("************************************************");
			}
			else if(selection == 3) {
				System.out.print("Enter the vrp of the car to be sold: ");
				scan.nextLine();
				String tempVrp = scan.nextLine().trim().replaceAll("\t", "-").replaceAll("\s", "-").toUpperCase();
				service.remove(tempVrp);
			}
			else if(selection == 4) {
				System.out.print("\nEnter the car's VRP to be search:");
				scan.nextLine();
				String tempVrp = scan.nextLine().trim().replaceAll("\t", "-").replaceAll("\s", "-").toUpperCase();				
				service.search(tempVrp);
			}
			else if(selection == 5)
				System.out.println("Number of registered cars: " + service.numberOfCars());
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
