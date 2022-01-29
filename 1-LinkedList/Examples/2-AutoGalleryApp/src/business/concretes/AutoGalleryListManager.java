package business.concretes;

import business.abstracts.AutoGalleryService;
import entities.concretes.AutoGalleryNode;

public class AutoGalleryListManager implements AutoGalleryService{
	AutoGalleryNode head;
	AutoGalleryNode tail;
	AutoGalleryNode temp;
	
	// constructor
	public AutoGalleryListManager() {
		this.head = null;
		this.tail = null;
		this.temp = null;
	}
	
	// ****************************************************************
	// ********** Add the car to the list from the beginning **********
	
	@Override
	public void insertFirst(AutoGalleryNode newCar) {
		if(head == null) {
			head = newCar;
			tail = newCar;
			tail.setNext(head);
			System.out.println("First car added: " + newCar.getVrp());
		}
		else {
			temp = head;
			
			while(true) {
				if(temp.getVrp().equals(newCar.getVrp())) {
					System.out.println("\nYou have already entered this plate.");
					return;
				}
				temp = temp.getNext();
				if(temp == head)
					break;
			}
			newCar.setNext(head);
			head = newCar;
			tail.setNext(head);
			System.out.println("Car added: " + newCar.getVrp());
		}
	}
	
	// **********************************************************
	// ********** Add the car to the list from the end **********
	
	@Override
	public void insertLast(AutoGalleryNode newCar) {
		if(head == null) {
			head = newCar;
			tail = newCar;
			tail.setNext(head);
			System.out.println("First car added: " + newCar.getVrp());
		}
		else {
			temp = head;
			
			while(true) {
				if(temp.getVrp().equals(newCar.getVrp())) {
					System.out.println("\nYou have already entered this plate.");
					return;
				}
				temp = temp.getNext();
				if(temp == head)
					break;
			}
			tail.setNext(newCar);
			tail = newCar;
			tail.setNext(head);
			System.out.println("Car added: " + newCar.getVrp());
		}
	}
	
	// *****************************************
	// ********** Remove the customer **********
	
	@Override
	public void remove(String vrp) {
		if(head == null) {
			System.out.println("There aren't registered cars.");
			return;
		}
		boolean flag = false;
		
		if(head == tail && head.getVrp().equals(vrp)) {
			System.out.println("The vehicle with plate " + vrp + " was sold for " + head.getSalePrice() + " dollar.");
			head = null;
			tail = null;
			flag = true;
		}
		else if(head != tail && head.getVrp().equals(vrp)) {
			System.out.println("The vehicle with plate " + vrp + " was sold for " + head.getSalePrice() + " dollar.");
			head = head.getNext();
			flag = true;
		}
		else {
			temp = head;
			AutoGalleryNode temp2 = head;
			
			while(temp != tail) {
				if(temp.getVrp().equals(vrp)) {
					System.out.println("The vehicle with plate " + vrp + " was sold for " + temp.getSalePrice() + " dollar.");
					temp2.setNext(temp.getNext());
					flag = true;
				}
				temp2 = temp;
				temp = temp.getNext();
			}
			if(temp.getVrp().equals(vrp)) {
				System.out.println("The vehicle with plate " + vrp + " was sold for " + temp.getSalePrice() + " dollar.");
				tail = temp2;
				tail.setNext(head);
				flag = true;
			}
		}
		if(!flag)
			System.out.println("There aren't registered cars with this information: " + vrp);
	}
	
	// ************************************
	// ********** Search the car **********
	
	@Override
	public void search(String vrp) {
		if(head == null) {
			System.out.println("There aren't registered cars.");
			return;
		}
		boolean flag = false;
		temp = head;
		
		while(true) {
			if(temp.getVrp().equals(vrp)) {
				System.out.println("\nInformation of car: ");
				System.out.println(
						"\nVRP: " + temp.getVrp() + "\n" + 
						"Brand: " + temp.getBrand() + "\n" + 
						"Model: " + temp.getModel() + "\n" +
						"Color: " + temp.getColor() + "\n" +
						"Fuel type: " + temp.getFuelType() + "\n" +
						"HP: " + temp.getHp() + "\n" +
						"Purchase price: " + temp.getPurchasePrice() + "\n" +
						"Sale price: " + temp.getSalePrice()+ "\n"
						);
				System.out.println("\n************************************************");
				flag = true;
				break;
			}
			temp = temp.getNext();
			if(temp == head)
				break;
		}
		if(!flag)
			System.out.println("There aren't registered cars with this information: " + vrp);
	}

	// ************************************************************
	// ********** Print the number of cars on the screen **********
	
	@Override
	public int numberOfCars() {
		if(head == null) {
			System.out.println("There aren't registered cars.");
			return 0;
		}
		int count = 0;
		temp = head;
		
		while(true) {
			count++;
			temp = temp.getNext();
			if(temp == head)
				break;
		}
		return count;
	}
	
	// *****************************************
	// ********** Print car to screen **********
	
	@Override
	public void print() {
		if(head == null) {
			System.out.println("There aren't registered cars.");
			return;
		}
		temp = head;
		
		while(temp != tail) {
			System.out.println("\n************************************************");
			System.out.println(
					"\nVRP: " + temp.getVrp() + "\n" + 
					"Brand: " + temp.getBrand() + "\n" + 
					"Model: " + temp.getModel() + "\n" +
					"Color: " + temp.getColor() + "\n" +
					"Fuel type: " + temp.getFuelType() + "\n" +
					"HP: " + temp.getHp() + "\n" +
					"Purchase price: " + temp.getPurchasePrice() + "\n" +
					"Sale price: " + temp.getSalePrice()+ "\n"
					);
			temp = temp.getNext();
			System.out.println("************************************************");
		}
		System.out.println(
				"\nVRP: " + temp.getVrp() + "\n" +  
				"Brand: " + temp.getBrand() + "\n" + 
				"Model: " + temp.getModel() + "\n" +
				"Color: " + temp.getColor() + "\n" +
				"Fuel type: " + temp.getFuelType() + "\n" +
				"HP: " + temp.getHp() + "\n" +
				"Purchase price: " + temp.getPurchasePrice() + "\n" +
				"Sale price: " + temp.getSalePrice()
				);
	}
}
