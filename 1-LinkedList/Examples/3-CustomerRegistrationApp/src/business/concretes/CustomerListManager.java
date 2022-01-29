package business.concretes;

import business.abstracts.CustomerService;
import entities.concretes.CustomerNode;

public class CustomerListManager implements CustomerService{
	private CustomerNode head;
	private CustomerNode tail;
	private CustomerNode temp;
	
	// constructor
	public CustomerListManager(){
		this.head = null;
		this.tail = null;
		this.temp = null;
	}
	
	// *********************************************************************
	// ********** Add the customer to the list from the beginning **********
	
	@Override
	public void insertFirst(CustomerNode customer) {
		if(head == null) {
			head = customer;
			tail = customer;
			System.out.println("First customer added: " + customer.getFirstName() + " " + customer.getLastName());
		}
		else {
			temp = head;
			
			while(true) {
				if(temp.getId() == customer.getId()) {
					System.out.println("\nYou have already entered this id.");
					return;
				}
				temp = temp.getNext();
				if(temp == null)
					break;
			}
			customer.setNext(head);
			head.setPrev(customer);
			head = customer;
			System.out.println("Customer added: " + customer.getFirstName() + " " + customer.getLastName());
		}
	}
	
	// ***************************************************************
	// ********** Add the customer to the list from the end **********
	
	@Override
	public void insertLast(CustomerNode customer) {
		if(head == null) {
			head = customer;
			tail = customer;
			System.out.println("First customer added: " + customer.getFirstName() + " " + customer.getLastName());
		}
		else {
			temp = head;
			
			while(true) {
				if(temp.getId() == customer.getId()) {
					System.out.println("\nYou have already entered this id.");
					return;
				}
				temp = temp.getNext();
				if(temp == null)
					break;
			}
			tail.setNext(customer);
			customer.setPrev(tail);
			tail = customer;
			System.out.println("Customer added: " + customer.getFirstName() + " " + customer.getLastName());
		}
	}
	
	// *****************************************
	// ********** Remove the customer **********
	
	@Override
	public void remove(int id) {
		if(head == null) {
			System.out.println("There aren't registered customers.");
			return;
		}
		boolean flag = false;
		
		if(head.getNext() == null && head.getId() == id) {
			System.out.println("Last registered customer deleted: " + id);
			head = null;
			tail = null;
			flag = true;
		}
		else if(head.getNext() != null && head.getId() == id) {
			System.out.println("Customer deleted: " + id);
			head = head.getNext();
			head.setPrev(null);
			flag = true;
		}
		else if(tail.getId() == id) {
			System.out.println("Customer deleted: " + id);
			tail = tail.getPrev();
			tail.setNext(null);
			flag = true;
		}
		else {
			temp = head;
			
			while(temp != null) {
				if(temp.getId() == id) {
					System.out.println("Customer deleted: " + id);
					temp.getNext().setPrev(temp.getPrev());
					temp.getPrev().setNext(temp.getNext());
					flag = true;
					break;
				}
				temp = temp.getNext();
			}
		}
		if(!flag)
			System.out.println("There aren't registered customers with this information: " + id);
	}
	
	// *****************************************
	// ********** Search the customer **********
	
	@Override
	public void search(int id) {
		if(head == null) {
			System.out.println("There aren't registered customers.");
			return;
		}
		temp = head;
		boolean flag = false;
		
		while(temp != null) {
			if(temp.getId() == id) {
				System.out.println("\nInformation of customer id: " + id);
				System.out.println(
						"\nCustomer id: " + temp.getId() + "\n" + 
						"First name: " + temp.getFirstName() + "\n" + 
						"Last name: " + temp.getLastName() + "\n" + 
						"Gender: " + temp.getGender() + "\n" +
						"Email: " + temp.getEmail() + "\n" +
						"Purchased product: " + temp.getProduct() + "\n"
						);
				System.out.println("************************************************");
				flag = true;
				break;
			}
			temp = temp.getNext();
		}
		if(!flag)
			System.out.println("There aren't registered customers with this information.");
	}
	
	// *****************************************************************
	// ********** Print the number of customers on the screen **********
	
	@Override
	public int numberOfCustomers() {
		if(head == null) {
			System.out.println("There aren't registered customers.\n");
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
	
	// **********************************************
	// ********** Print customer to screen **********
	
	@Override
	public void print() {
		if(head == null) {
			System.out.println("There aren't registered customers.");
			return;
		}
		temp = head;
		
		while(temp != null) {
			System.out.println("\n************************************************");
			System.out.println(
					"Customer id: " + temp.getId() + "\n" + 
					"First name: " + temp.getFirstName() + "\n" + 
					"Last name: " + temp.getLastName() + "\n" + 
					"Gender: " + temp.getGender() + "\n" +
					"Email: " + temp.getEmail() + "\n" +
					"Purchased product: " + temp.getProduct()
					);
			temp = temp.getNext();
		}
		System.out.println("\n************************************************");
	}
}
