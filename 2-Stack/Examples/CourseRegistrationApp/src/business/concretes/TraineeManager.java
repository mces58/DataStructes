package business.concretes;

import business.abstracts.TraineeService;
import entities.concretes.Trainee;

public class TraineeManager implements TraineeService{
	private final int size;
	private Trainee[] array;
	private int index;
	
	// constructor
	public TraineeManager(int size) {
		this.size = size;
		this.index = 0;
		this.array = new Trainee[size];
	}
	
	private boolean isFull() {
		return index == size;
	}
	
	private boolean isEmpty() {
		return index == 0;
	}
	
	// add to stack
	@Override
	public void push(Trainee trainee) {
		if(isFull())
			System.out.println("The quota is full. We cannot recruit new trainees.");
		else {
			if(index == 0) {
				trainee.setId(index);
				
				array[index++] = trainee;
				System.out.println("\nFirst trainee added to the course: " + trainee.getFirstName() + " " + trainee.getLastName());
				return;
			}
			trainee.setId(index);
			
			array[index++] = trainee;
			System.out.println("\nTrainee added to the course: " + trainee.getFirstName() + " " + trainee.getLastName());
		}
	}
	
	// delete from stack
	@Override
	public String pop() {
		if(isEmpty()) {
			return "No one is registered on the course.";
		}
		int temp = --index;

		return "Trainee deleted: " + array[temp].getFirstName() + " " + array[temp].getLastName();
	}
	
	// print the stack
	@Override
	public void print() {
		if(isEmpty()) {
			System.out.println("\nNo one is registered on the course.");
			return;
		}
		int i = index - 1;
		
		while(i != -1) {
			System.out.println("\n****************************************");
			System.out.println(
					"ID             : " + array[i].getId() + "\n" +  
					"First name     : " + array[i].getFirstName() + "\n" +
					"Last name      : " + array[i].getLastName() + "\n" +
					"Email address  : " + array[i].getEmail() + "\n" +
					"Phone number   : " + array[i].getPhoneNumber() + "\n" + 
					"Course name    : " + array[i].getCourseName() 
					);
			System.out.println("****************************************");
			i--;
		}
	}
}
