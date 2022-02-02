package business.concretes;

import business.abstracts.BakerService;
import entities.concretes.BakerNode;

public class BakerManager implements BakerService{
	private BakerNode front;
	private BakerNode rear;
	private final int capacity;
	private int size;
	private double totalRevenue;
	
	public BakerManager(int capacity) {
		this.front = null;
		this.rear = null;
		this.capacity = capacity;
		this.size = 0;
		this.totalRevenue = 0;
	}
	
	private boolean isFull() {
		return size == capacity;
	}
	
	private boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public void enQueue(BakerNode customer) {
		if(isFull()) {
			System.out.println("Queue is full.");
			return;
		}
		if(isEmpty()) {
			front = customer;
			rear = customer;
		}
		else {
			rear.setNext(customer);
			rear = customer;
		}
		System.out.println("\nCustomer queued up: " + customer.getName());
		size++;
	}
	
	@Override
	public String deQueue() {
		if(isEmpty())
			return "Queue is empty.";
		
		BakerNode temp = front;
		
		totalRevenue += front.getPrice();
		front = front.getNext();
		size--;
		
		return "The customer is out of the queue: " + temp.getName();
	}
	
	@Override
	public double totalRevenue() {
		return totalRevenue;
	}
	
	@Override
	public void print() {
		if(isEmpty()) {
			System.out.println("Queue is empty.");
			return;
		}
		BakerNode temp = front;
		
		while(temp != null) {
			System.out.println(
					"Name  : " + temp.getName() + "\n" +
					"Price : " + temp.getPrice() + " ₺.\n"
					);
			temp = temp.getNext();
		}
	}
}
