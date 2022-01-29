package entities.concretes;

public class StudentNode {
	private int studentNumber;
	private String firstName;
	private String lastName;
	private int exam1;
	private int exam2;
	private double meanAverage;
	private String situation;
	private StudentNode next;
	
	// constructor
	public StudentNode(int studentNumber, String firstName, String lastName, int exam1, int exam2) {
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.exam1 = exam1;
		this.exam2 = exam2;
		this.meanAverage = this.exam1 * 0.3 + this.exam2 * 0.7;
		
		if(this.meanAverage >= 50)
			this.situation = "passed";
		else
			this.situation = "failed";
		
		this.next = null;
	}
	
	// getter & setter
	public int getStudentNumber() {
		return studentNumber;
	}
	
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getExam1() {
		return exam1;
	}
	
	public void setExam1(int exam1) {
		this.exam1 = exam1;
	}
	
	public int getExam2() {
		return exam2;
	}
	
	public void setExam2(int exam2) {
		this.exam2 = exam2;
	}
	
	public StudentNode getNext() {
		return next;
	}
	
	public void setNext(StudentNode next) {
		this.next = next;
	}
	
	public double getMeanAverage() { // no setter
		return meanAverage;
	}
	
	public String getSituation() { // no setter
		return situation;
	}
}
