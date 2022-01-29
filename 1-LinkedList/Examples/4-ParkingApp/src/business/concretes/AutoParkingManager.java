package business.concretes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import business.abstracts.AutoParkingService;
import entities.concretes.AutoParkingNode;

public class AutoParkingManager implements AutoParkingService{
	private AutoParkingNode head;
	private AutoParkingNode tail;
	private AutoParkingNode temp;
	private int index; // for the parking index of the car
	private double totalEarnings;
	
	// constructor
	public AutoParkingManager() {
		head = null;
		tail = null;
		temp = null;
		index = 0;
		totalEarnings = 0;
	}
	
	// *****************************************************
	// ********** Park the car in the parking lot **********
	
	@Override
	public void add(AutoParkingNode car) {
		if(head == null) {
			head = car;
			tail = car;
			head.setNext(tail);
			tail.setPrev(head);
			head.setPrev(tail);
			tail.setNext(head);
			System.out.println("Car entered the parking lot: " + car.getVrp());
			
			index++;
			car.setIndex(car.getIndex() + index);
		}
		else {
			temp = head;
			
			while(true) {
				if(temp.getVrp().equals(car.getVrp())) {
					System.out.println("\nYou have already entered this plate.");
					return;
				}
				temp = temp.getNext();
				if(temp == head)
					break;
			}
			car.setNext(head);
			head.setPrev(car);
			head = car;
			head.setPrev(tail);
			tail.setNext(head);
			System.out.println("Car entered the parking lot: " + car.getVrp());
			
			index++;
			car.setIndex(car.getIndex() + index);
		}
	}
	
	// *********************************************************
	// ********** Take the car out of the parking lot **********
	
	@Override
	public void remove(String vrp, String checkOutTime) {
		if(head == null) {
			System.out.println("The parking lot is empty.");
			return;
		}
		boolean flag = false;
		
		if(head == tail && head.getVrp().equals(vrp)) {			
			System.out.println("Car exited: " + vrp);

			calculatePayment(head, checkOutTime);
			
			head = null;
			tail = null;
			index = 0;
			flag = true;
		}
		else if(head != tail && head.getVrp().equals(vrp)) {
			System.out.println("Car exited: " + vrp);
			
			calculatePayment(head, checkOutTime);
			
			head = head.getNext();
			head.setPrev(tail);
			tail.setNext(head);
			flag = true;
		}
		else {
			temp = head;
			AutoParkingNode temp2 = temp;
			
			while(temp != tail) {
				if(temp.getVrp().equals(vrp)) {
					System.out.println("Car exited: " + vrp);
					
					calculatePayment(temp, checkOutTime);
					
					temp2.setNext(temp.getNext());
					temp.getNext().setPrev(temp2);
					flag = true;
				}
				temp2 = temp;
				temp = temp.getNext();
			}
			if(temp.getVrp().equals(vrp)) {
				System.out.println("Car exited: " + vrp);
				
				calculatePayment(temp, checkOutTime);
				
				tail = temp2;
				head.setPrev(tail);
				tail.setNext(head);
				flag = true;
			}
		}
		if(!flag)
			System.out.println("This license plate car is not in the parking lot: " + vrp);
	}
	
	// ****************************************************
	// ********** Calculate parking time and fee **********
	
	private void calculatePayment(AutoParkingNode car, String checkOutTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date date1,date2;
		
		try {
			date1 = sdf.parse(car.getCheckInTime());
			date2 = sdf.parse(checkOutTime);
			
			car.setTimeSpent(date2.getTime() - date1.getTime());
			car.setTimeSpent(car.getTimeSpent() / 60000); // convert to minutes 
			car.setPay(car.getTimeSpent() / 4);
			
			System.out.println("Time spent in the parking lot: " + car.getTimeSpent() + " minutes.");
			System.out.println("Amount to be paid: " + car.getPay() + " $.");
			
			totalEarnings += car.getPay();
			
		} catch (ParseException e) {
			System.out.println("Format error!!");
			e.printStackTrace();
			return;
		}
	}
	
	// ****************************************************
	// ********** Earnings at the end of the day **********
	
	@Override
	public double totalEarnings() {
		return totalEarnings;
	}
	
	// ************************************
	// ********** Search the car **********
	
	@Override
	public void search(String vrp) {
		if(head == null) {
			System.out.println("The parking lot is empty.");
			return;
		}
		temp = head;
		boolean flag = false;
		
		while(true) {
			if(temp.getVrp().equals(vrp)) {
				System.out.println("\nVRP\t\tCheck-in time\t\tOrder of the car");
				System.out.println(temp.getVrp() + "\t" + temp.getCheckInTime() + "\t\t\t\t" + temp.getIndex());
				flag = true;
				break;
			}
			temp = temp.getNext();
			if(temp == head)
				break;
		}
		if(!flag)
			System.out.println("This license plate car is not in the parking lot: " + vrp);
	}
	
	// ************************************************************
	// ********** Print the number of cars on the screen **********
	
	@Override
	public int numberOfCars() {
		if(head == null) {
			System.out.println("The parking lot is empty.\n");
			return 0;
		}
		temp = head;
		int count = 0;
		
		while(true) {
			count++;
			temp = temp.getNext();
			if(temp == head)
				break;
		}
		return count;
	}
	
	// ***************************************************
	// ********** Print cars in the parking lot **********
	
	@Override
	public void print() {
		if(head == null) {
			System.out.println("The parking lot is empty.");
			return;
		}
		System.out.println("\n\tVRP\t\tCHECK-IN TIME\t\tORDER OF THE CAR");
		temp = head;
		
		while(temp != tail) {
			System.out.println("\t" + temp.getVrp() +"\t\t" + temp.getCheckInTime() + "\t\t\t" + temp.getIndex());
			temp = temp.getNext();
		}
		System.out.println("\t" + temp.getVrp() +"\t\t" + temp.getCheckInTime() + "\t\t\t" + temp.getIndex());
	}
}
