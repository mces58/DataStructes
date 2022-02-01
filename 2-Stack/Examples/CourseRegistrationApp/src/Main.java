import java.util.Scanner;

import business.abstracts.TraineeService;
import business.concretes.TraineeManager;
import entities.concretes.Trainee;

public class Main {
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		TraineeService service;
		Trainee trainee;
		int selection = -1;
		System.out.println("\t\t\t******************** WELCOME TO COURSE REGISTRATION APPLICATION ********************");
		
		while(selection != 0) {
			System.out.println("\n----- Main menu -----");
			System.out.println(
			"\n0-Sign out.\n" + 
			"1-Create a math course.\n" + 
			"2-Create a painting course.\n" + 
			"3-Create a science course.\n"
			);
			System.out.print("Choose one of the above actions: ");
			selection = scan.nextInt();
			
			if(selection == 1) {
				System.out.println("\nCreating a math course..\n");
				System.out.print("\nEnter the number of quota of the mathematics course: ");
				int quota = scan.nextInt();
				service = new TraineeManager(quota);
				
				int selection2 = -1;
				while(selection2 != 0) {
					System.out.println("\n*****************************************");
					System.out.println(
							"0-Go to main menu.\n" + 
							"1-Add trainee.\n" + 
							"2-Delete trainee.\n" + 
							"3-Show trainees.\n"
							);
					System.out.print("\nChoose one of the above actions: ");
					selection2 = scan.nextInt();
					
					if(selection2 == 1) {
						System.out.println("\nEnter the trainee information..");
						scan.nextLine();
						System.out.print("First name: ");
						String firstName = scan.nextLine().trim();
						
						System.out.print("Last name: ");
						String lastName = scan.nextLine().trim().toUpperCase();
						
						System.out.print("Email: ");
						String email = scan.nextLine().trim();
						
						System.out.print("Phone number: ");
						String phoneNumber = scan.nextLine().trim();
						
						trainee = new Trainee(firstName, lastName, email, phoneNumber, "MATH");
						service.push(trainee);
					}
					else if(selection2 == 2) {
						System.out.println("\n" + service.pop());
					}
					else if(selection2 == 3) {
						service.print();
					}

					else if(selection2 == 0) {
						break;
					}
					else {
						System.out.println("\nIncorrect entry!!");
						break;
					}
				}
			}
			else if(selection == 2) {
				System.out.println("\nCreating a painting course..\n");
				System.out.print("\nEnter the number of quota of the painting course: ");
				int quota = scan.nextInt();
				service = new TraineeManager(quota);
				
				int selection2 = -1;
				while(selection2 != 0) {
					System.out.println("\n*****************************************");
					System.out.println(
							"0-Go to main menu.\n" + 
							"1-Add trainee.\n" + 
							"2-Delete trainee.\n" + 
							"3-Show trainees.\n"
							);
					System.out.print("\nChoose one of the above actions: ");
					selection2 = scan.nextInt();
					
					if(selection2 == 1) {
						System.out.println("\nEnter the trainee information..");
						scan.nextLine();
						System.out.print("First name: ");
						String firstName = scan.nextLine().trim();
						
						System.out.print("Last name: ");
						String lastName = scan.nextLine().trim().toUpperCase();
						
						System.out.print("Email: ");
						String email = scan.nextLine().trim();
						
						System.out.print("Phone number: ");
						String phoneNumber = scan.nextLine().trim();
						
						trainee = new Trainee(firstName, lastName, email, phoneNumber, "PAINTING");
						service.push(trainee);
					}
					else if(selection2 == 2) {
						System.out.println("\n" + service.pop());
					}
					else if(selection2 == 3) {
						service.print();
					}
					else if(selection2 == 0) {
						break;
					}
					else {
						System.out.println("\nIncorrect entry!!");
						break;
					}
				}
			}
			else if(selection == 3) {
				System.out.println("\nCreating a sciense course..\n");
				System.out.print("\nEnter the number of quota of the science course: ");
				int quota = scan.nextInt();
				service = new TraineeManager(quota);
				
				int selection2 = -1;
				while(selection2 != 0) {
					System.out.println("\n*****************************************");
					System.out.println(
							"0-Go to main menu.\n" + 
							"1-Add trainee.\n" + 
							"2-Delete trainee.\n" + 
							"3-Show trainees.\n"
							);
					System.out.print("\nChoose one of the above actions: ");
					selection2 = scan.nextInt();
					
					if(selection2 == 1) {
						System.out.println("\nEnter the trainee information..");
						scan.nextLine();
						System.out.print("First name: ");
						String firstName = scan.nextLine().trim();
						
						System.out.print("Last name: ");
						String lastName = scan.nextLine().trim().toUpperCase();
						
						System.out.print("Email: ");
						String email = scan.nextLine().trim();
						
						System.out.print("Phone number: ");
						String phoneNumber = scan.nextLine().trim();
						
						trainee = new Trainee(firstName, lastName, email, phoneNumber, "SCIENCE");
						service.push(trainee);
					}
					else if(selection2 == 2) {
						System.out.println("\n" + service.pop());
					}
					else if(selection2 == 3) {
						service.print();
					}
					else if(selection2 == 0) {
						break;
					}
					else {
						System.out.println("\nIncorrect entry!!");
						break;
					}
				}
			}
			else if(selection == 0) {
				System.out.println("\nHave a nice day..");
				break;
			}
			else {
				System.out.println("\nInvalid choice!!");
				break;
			}
		}
	}
}
