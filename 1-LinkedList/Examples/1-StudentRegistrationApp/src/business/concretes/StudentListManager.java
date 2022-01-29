package business.concretes;

import business.abstracts.StudentService;
import entities.concretes.StudentNode;

public class StudentListManager implements StudentService{
	private StudentNode head;
	private StudentNode tail;
	private StudentNode temp;
	
	// constructor
	public StudentListManager() {
		this.head = null;
		this.tail = null;
	}
	
	// ********************************************************************
	// ********** Add the student to the list from the beginning **********
	
	@Override
	public void insertFirst(StudentNode student) {
		if(head == null) {
			head = student;
			tail = student;
			System.out.println("First student added: " + student.getFirstName() + " " + student.getLastName());
		}
		else {
			temp = head;;
			
			while(true) {
				if(temp.getStudentNumber() == student.getStudentNumber()) {
					System.out.println("\nYou have already entered this student number.");
					return;
				}
				temp = temp.getNext();
				if(temp == null)
					break;
			}
			student.setNext(head);
			head = student;
			System.out.println("Student added: " + student.getFirstName() + " " + student.getLastName());
		}
	}
	
	// **************************************************************
	// ********** Add the student to the list from the end **********
	
	@Override
	public void insertLast(StudentNode student) {
		if(head == null) {
			head = student;
			tail = student;
			System.out.println("First student added: " + student.getFirstName() + " " + student.getLastName());
		}
		else {
			temp = head;;
			
			while(true) {
				if(temp.getStudentNumber() == student.getStudentNumber()) {
					System.out.println("\nYou have already entered this student number.");
					return;
				}
				temp = temp.getNext();
				if(temp == null)
					break;
			}
			tail.setNext(student);
			tail = student;
			System.out.println("Student added: " + student.getFirstName() + " " + student.getLastName());
		}
	}
	
	// ****************************************
	// ********** Remove the student **********
	
	@Override
	public void remove(int number) {
		if(head == null) {
			System.out.println("There aren't registered students.");
			return;
		}
		boolean flag = false;
		
		if(number == head.getStudentNumber() && head.getNext() == null) {
			System.out.println("Last registered student deleted: " + number);
			head = null;
			tail = null;
			flag = true;
		}
		else if(number == head.getStudentNumber() && head.getNext() != null) {
			System.out.println("Student deleted: " + number);
			head = head.getNext();
			flag = true;
		}
		else if(tail.getStudentNumber() == number) {
			System.out.println("Student deleted: " +number);
			tail.setNext(null);
			flag = true;
		}
		else {
			temp = head;
			StudentNode temp2 = head;
			
			while(temp.getNext() != null) {
				if(number == temp.getStudentNumber()) {
					System.out.println("Student deleted: " + number);
					temp2.setNext(temp.getNext());
					flag = true;
				}
				temp2 = temp;
				temp = temp.getNext();
			}
			if(number == temp.getStudentNumber()) {
				System.out.println("Student deleted: " + number);
				temp2.setNext(null);
				tail = temp2;
				return;
			}
		}
		if(!flag)
			System.out.println("There aren't registered students with this information: " + number);
	}
	
	// ****************************************
	// ********** Search the student **********
	
	@Override
	public void search(int number) {
		if(head == null) {
			System.out.println("There aren't registered students.");
			return;
		}
		temp = head;
		boolean flag = false;
		
		while(temp != null) {
			if(number == temp.getStudentNumber()) {
				System.out.println("\nInformation of student number: " + number);
				System.out.println(
						"\nStudent number: " + temp.getStudentNumber() + "\n" + 
						"Student first name: " + temp.getFirstName() + "\n" + 
						"Student last name: " + temp.getLastName() + "\n" + 
						"Exam 1: " + temp.getExam1() + "\n" +
						"Exam 2: " + temp.getExam2() + "\n" +
						"Mean average: " + temp.getMeanAverage() + "\n" + 
						"Situation: " + temp.getSituation() + "\n"
						);
				System.out.println("\n************************************************");
				flag = true;
				break;
			}
			temp = temp.getNext();
		}
		if(!flag)
			System.out.println("There aren't registered students with this information: " + number);
	}
	
	// ****************************************************************
	// ********** Print the number of students on the screen **********
	
	@Override
	public int numberOfStudents() {
		if(head == null) {
			System.out.println("There aren't registered students.");
			return 0;
		}
		temp = head;
		int count = 0;
		
		while(temp != null) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}
	
	// ********************************************
	// ********** Print the best student **********
	
	@Override
	public void theBestStudent() {
		if(head == null) {
			System.out.println("There aren't registered students.");
			return;
		}
		temp = head;
		StudentNode bestStudent = temp;
		
		while(true) {
			if(temp.getMeanAverage() > bestStudent.getMeanAverage()) {
				bestStudent = temp;
			}
			temp = temp.getNext();
			if(temp == null)
				break;
		}
		System.out.println("THE BEST STUDENT: " + bestStudent.getFirstName() + " " + bestStudent.getLastName() + "\nAVERAGE: " + bestStudent.getMeanAverage());
	}
	
	// *********************************************
	// ********** Print student to screen **********
	
	@Override
	public void print() {
		if(head == null) {
			System.out.println("There aren't registered students.");
			return;
		}
		temp = head;
		
		while(temp != null) {
			System.out.println("\n************************************************");
			System.out.println(
					"Student number: " + temp.getStudentNumber() + "\n" + 
					"Student first name: " + temp.getFirstName() + "\n" + 
					"Student last name: " + temp.getLastName() + "\n" + 
					"Exam 1: " + temp.getExam1() + "\n" +
					"Exam 2: " + temp.getExam2() + "\n" +
					"Mean average: " + temp.getMeanAverage() + "\n" + 
					"Situation: " + temp.getSituation()
					);
			temp = temp.getNext();
		}
		System.out.println("\n************************************************");
	}
}
