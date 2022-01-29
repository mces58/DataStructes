import java.util.Scanner;

import business.abstracts.StudentService;
import business.concretes.StudentListManager;
import entities.concretes.StudentNode;

public class Main {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		StudentService service = new StudentListManager();
		StudentNode student;
		
		int selection = -1;
		int number = -1;
		String firstName = "";
		String lastName = "";
		int exam1 = -1;
		int exam2 = -1;
		
		System.out.println("\t\t\t\t\t\tWELCOME TO THE STUDENT REGISTRATION APPLICATION");
		while(selection != 0) {
			System.out.println("\n************************************************");
			System.out.println(
					"0- Exit." + 
					"\n1- Add student to the top of the list." + 
					"\n2- Add student to the end of the list." + 
					"\n3- Delete the student." +
					"\n4- Search for students." + 
					"\n5- Print the number of registered students." + 
					"\n6- Print the best student to the screen." + 
					"\n7- Print the student list.\n"
					);
			System.out.print("Please choose one of them: ");
			selection = scan.nextInt();
			System.out.println("************************************************");
			
			if(selection == 1) {
				System.out.println("\n************************************************");
				System.out.println("Enter the student information.");
				
				System.out.print("Student number: ");
				number = scan.nextInt();
				
				scan.nextLine();
				System.out.print("First name: ");
				firstName = scan.nextLine().trim();
				
				System.out.print("Last name: ");
				lastName = scan.nextLine().trim().toUpperCase();
				
				System.out.print("Exam 1: ");
				exam1 = scan.nextInt();
				
				System.out.print("Exam 2: ");
				exam2 = scan.nextInt();
			    
				student = new StudentNode(number, firstName, lastName, exam1, exam2);
				service.insertFirst(student);
				System.out.println("************************************************");
			}
			else if(selection == 2) {
				System.out.println("\n************************************************");
				System.out.println("Enter the student information.");
				
				System.out.print("Student number: ");
				number = scan.nextInt();
				
				scan.nextLine();
				System.out.print("First name: ");
				firstName = scan.nextLine().trim();
				
				System.out.print("Last name: ");
				lastName = scan.nextLine().trim().toUpperCase();
				
				System.out.print("Exam 1: ");
				exam1 = scan.nextInt();
				
				System.out.print("Exam 2: ");
				exam2 = scan.nextInt();
			
				student = new StudentNode(number, firstName, lastName, exam1, exam2);
				service.insertLast(student);
				System.out.println("************************************************");
			}
			else if(selection == 3) {
				System.out.print("Enter the number of the student to be deleted: ");
				int tempNumber = scan.nextInt();
				service.remove(tempNumber);
			}
			else if(selection == 4) {
				System.out.print("Enter the student's number to be search:");
				int tempNumber = scan.nextInt();
				service.search(tempNumber);
			}
			else if(selection == 5)
				System.out.println("Number of registered students: " + service.numberOfStudents());
			else if(selection == 6)
				service.theBestStudent();
			else if(selection == 7)
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
