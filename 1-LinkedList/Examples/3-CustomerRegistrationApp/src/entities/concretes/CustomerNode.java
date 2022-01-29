package entities.concretes;

public class CustomerNode {
	private int id;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private String product;
	private CustomerNode next;
	private CustomerNode prev;
	
	// constructor
	public CustomerNode(int id, String firstName, String lastName, String gender, String email, String product) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.product = product;
		this.next = null;
		this.prev = null;
	}

	// getter & setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public CustomerNode getNext() {
		return next;
	}

	public void setNext(CustomerNode next) {
		this.next = next;
	}

	public CustomerNode getPrev() {
		return prev;
	}

	public void setPrev(CustomerNode prev) {
		this.prev = prev;
	}
}
