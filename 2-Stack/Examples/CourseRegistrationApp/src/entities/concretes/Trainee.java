package entities.concretes;

public class Trainee {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String courseName;
	private Trainee next;
	
	// constructor
	public Trainee(String firstName, String lastName, String email, String phoneNumber, String courseName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.courseName = courseName;
		this.id = 0;
		this.next = null;
	}

	// getter & setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Trainee getNext() {
		return next;
	}

	public void setNext(Trainee next) {
		this.next = next;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getCourseName() {
		return courseName;
	}
}
