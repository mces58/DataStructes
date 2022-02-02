package business.concretes;

import business.abstracts.QueueService;
import entities.concretes.Node;

public class QueueManager implements QueueService{
	private Node front;
	private Node rear;
	
	public QueueManager() {
		this.front = null;
		this.rear = null;
	}
	
	private Node newNode(int data) {
		Node newNode = new Node(data);
		
		newNode.setData(data);
		newNode.setNext(null);
		
		return newNode;
	}

	private boolean isEmpty() {
		if(rear == null)
			return true;
		return false;
	}
	
	@Override
	public void enQueue(int data) {
		Node newNode = newNode(data);
		
		if(isEmpty()) {
			front = newNode;
			rear = newNode;
		}
		else {
			rear.setNext(newNode); // rear.next = newNode
			rear = newNode;
		}
		System.out.println(data + " queued up.");
	}

	@Override
	public int deQueue() {
		if(isEmpty())
			return Integer.MIN_VALUE;
		
		int temp = front.getData();
		
		front = front.getNext();
		if(front == null)
			rear = null;
		return temp;
	}
	
	@Override
	public int max() {
		if(isEmpty())
			return Integer.MIN_VALUE;
		
		int max = front.getData();
		Node temp = front;
		
		while(true) {
			if(temp.getData() > max)
				max = temp.getData();
			temp = temp.getNext();
			if(temp == rear.getNext())
				break;
		}
		return max;
	}
	
	@Override
	public int min() {
		if(isEmpty())
			return Integer.MIN_VALUE;
		
		int min = front.getData();
		Node temp = front;
	
		while(true) {
			if(temp.getData() < min)
				min = temp.getData();
			temp = temp.getNext();
			if(temp == rear.getNext())
				break;
		}
		return min;
	}
	
	@Override
	public boolean search(int data) {
		if(isEmpty()) {
			System.out.println("Queue is empty.");
			return false;
		}
		boolean flag = false;
		Node temp = front;
		
		while(true) {
			if(temp.getData() == data) {
				flag = true;
				break;
			}
			temp = temp.getNext();
			if(temp == rear.getNext())
				break;
		}
		return flag;
	}
	
	@Override
	public int numberOfNodes() {
		if(isEmpty())
			return Integer.MIN_VALUE;
		
		int counter = 0;
		Node temp = front;
		
		while(true) {
			counter++;
			temp = temp.getNext();
			if(temp == rear.getNext())
				break;
		}
		return counter;
	}
	
	@Override
	public int front() {
		if(isEmpty())
			return Integer.MIN_VALUE;
		return front.getData();
	}
	
	@Override
	public int rear() {
		if(isEmpty())
			return Integer.MIN_VALUE;
		return rear.getData();
	}
	
	@Override
	public void print() {
		if(isEmpty()) {
			System.out.println("Stack is empty.");
			return;
		}
		Node temp = front;
		
		while(temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}
}
