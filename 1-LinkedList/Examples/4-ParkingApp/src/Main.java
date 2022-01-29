import java.util.Scanner;

import business.abstracts.AutoParkingService;
import business.concretes.AutoParkingManager;
import entities.concretes.AutoParkingNode;

public class Main {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		AutoParkingService service = new AutoParkingManager();
		AutoParkingNode car;
		
		int selection = -1;
		String vrp = null;
		int hour = -1;
		int minute = -1;
		String time = null;
		
		System.out.println("\t\t\t\t\t\tWELCOME TO THE CAR PARKING APPLICATION");
		while(selection != 0) {
			System.out.println("\n************************************************");
			System.out.println(
					"0- Exit." + 
					"\n1- Entrance to the parking lot." + 
					"\n2- Exit from the parking lot." +
					"\n3- Find out total earnings." + 
					"\n4- Search for cars." +  
					"\n5- Number of cars in the parking lot." + 
					"\n6- Show cars in the parking lot.\n"
					);
			System.out.print("Please choose one of them: ");
			selection = scan.nextInt();
			System.out.println("************************************************");
			
			if(selection == 1) {
				System.out.println("\n************************************************");
				System.out.println("Enter the license plate of the car.");
				
				scan.nextLine();
				System.out.print("VRP: ");				
				vrp = scan.nextLine().trim().replaceAll("\t", "-").replaceAll("\s", "-").toUpperCase();
				
				System.out.print("Enter the parking entrance time.\n");
				System.out.print("Hour: ");
				hour = scan.nextInt();
				System.out.print("Minute: ");
				minute = scan.nextInt();
				
				if(hour >= 24 || hour < 0 || minute >= 60 || minute < 0) {
					System.out.print("Incorrect information entry.");
					return;
				}
				
				if(hour >= 0 && hour <= 9 && minute >= 0 && minute <= 9)
					time =  "0" + String.valueOf(hour) + ":" + "0" + String.valueOf(minute);
				else if(hour >= 0 && hour <= 9)
					time = "0" + String.valueOf(hour) + ":" + String.valueOf(minute);
				else if(minute >= 0 && minute <= 9)
					time = String.valueOf(hour) + ":" + "0" + String.valueOf(minute);
				else
					time = String.valueOf(hour) + ":" + String.valueOf(minute);
				
				car = new AutoParkingNode(vrp, time);
				service.add(car);
				System.out.println("************************************************");
			}
			else if(selection == 2) {
				System.out.println("\n************************************************");
				
				scan.nextLine();
				System.out.print("Enter the license plate of the car: ");
				vrp = scan.nextLine().trim().replaceAll("\t", "-").replaceAll("\s", "-").toUpperCase();
				
				System.out.print("Enter the exit time from the parking lot.\n");
				System.out.print("Hour: ");
				hour = scan.nextInt();
				System.out.print("Minute: ");
				minute = scan.nextInt();

				if(hour >= 24 || hour < 0 || minute >= 60 || minute < 0) {
					System.out.print("Incorrect information entry.");
					return;
				}
				
				if(hour >= 0 && hour <= 9 && minute >= 0 && minute <= 9)
					time =  "0" + String.valueOf(hour) + ":" + "0" + String.valueOf(minute);
				else if(hour >= 0 && hour <= 9)
					time = "0" + String.valueOf(hour) + ":" + String.valueOf(minute);
				else if(minute >= 0 && minute <= 9)
					time = String.valueOf(hour) + ":" + "0" + String.valueOf(minute);
				else
					time = String.valueOf(hour) + ":" + String.valueOf(minute);
				
				service.remove(vrp, time);
				System.out.println("************************************************");
			}
			else if(selection == 3)
				System.out.println("Total earnings at the end of the day: " + service.totalEarnings() + " $.");
			else if(selection == 4) {
				System.out.print("\nEnter the car's VRP to be search: ");
				scan.nextLine();
				String temVrp = scan.nextLine().trim().replaceAll("\t", "-").replaceAll("\s", "-").toUpperCase();
				
				service.search(temVrp);
			}
			else if(selection == 5)
				System.out.println("Number of cars in the parking lot: " + service.numberOfCars());
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
