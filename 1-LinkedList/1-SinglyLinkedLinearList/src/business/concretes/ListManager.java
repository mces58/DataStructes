package business.concretes;

import business.abstracts.ListService;
import entities.concretes.Node;

public class ListManager implements ListService{
	private Node head;
	private Node tail;
	
	// constructor
	public ListManager() {
		this.head = null;
		this.tail = null;
	}
	
	// *************************************
	// ********** Create new node **********
	
	private Node newNode(int data) {
		Node newNode = new Node(data);
		
		newNode.setData(data); // newNode.data = data;
		newNode.setNext(null); // newNode.next = null;
		
		return newNode;
	}
	
	// **************************************
	// ********** Add to beginning **********
	
	@Override
	public void insertFirst(int data) {
		Node newNode = newNode(data);
		
		if(head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			newNode.setNext(head); // newNode.next = head;
			head = newNode;
		}
	}
	
	// ********************************
	// ********** Add to end **********
	
	@Override
	public void insertLast(int data) {
		Node newNode = newNode(data);
		
		if(head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.setNext(newNode); // tail.next = newNode;
			tail = newNode;
		}
	}
	
	// *******************************************
	// ********** Delete from beginning **********
	
	@Override
	public void removeFirst() {
		if(head == null)
			System.out.println("List is empty.");
		else if(head.getNext() == null) {
			head = null;
			tail = null;
		}
		else
			head = head.getNext(); // head = head.next;
	}
	
	// *************************************
	// ********** Delete from end **********
	
	@Override
	public void removeLast() {
		if(head == null)
			System.out.println("List is empty.");
		else if(head.getNext() == null) {
			head = null;
			tail = null;
		}
		else {
			Node temp = head;
			
			while(temp.getNext().getNext() != null)
				temp = temp.getNext();
			temp.setNext(null); // temp.next = null;
			tail = temp;
		}
	}
	
	// ***********************************
	// ********** Sort the list **********
	
	@Override 
	public void sort() {
		if(head == null) {
			System.out.println("List is empty.");
			return;
		}
		Node i = head;
		
		while(i != null) {
			Node j = i.getNext();
			
			while(j != null) {
				if(i.getData() > j.getData()) {
					// swap
					int temp = i.getData();
					i.setData(j.getData());
					j.setData(temp);
				}
				j = j.getNext();
			}
			i = i.getNext();
		}
	}
	
	// *************************************
	// ********** Search the list **********
	
	@Override
	public boolean search(int data) {
		if(head == null) {
			System.out.println("List is empty.");
			return false;
		}
		Node temp = head;
		
		while(temp != null) {
			if(temp.getData() == data)
				return true;
			temp = temp.getNext();
		}
		return false;
	}
	
	// **********************************************
	// ********** Give the number of nodes **********
	
	@Override
	public int numberOfNodes() {
		if(head == null) {
			System.out.println("List is empty.");
			return 0;
		}
		Node temp = head;
		int count = 0;
		
		while(temp != null) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}
	
	// **********************************
	// ********** Maximum node **********
	
	@Override
	public int maxNode() {
		if(head == null) {
			System.out.println("List is empty.");
			return 0;
		}
		Node temp = head;
		int max = temp.getData();
		
		while(temp != null) {
			if(temp.getData() > max)
				max = temp.getData();
			temp = temp.getNext();
		}
		return max;
	}
	
	// **********************************
	// ********** Minimum node **********
	
	@Override
	public int minNode() {
		if(head == null) {
			System.out.println("List is empty.");
			return 0;
		}
		Node temp = head;
		int min = temp.getData();
		
		while(temp != null) {
			if(temp.getData() < min)
				min = temp.getData();
			temp = temp.getNext();
		}
		return min;
	}
	
	// *************************************
	// ********** Print to screen **********
	
	@Override
	public void print() {
		if(head == null) {
			System.out.println("List is empty.");
			return;
		}
		Node temp = head;
		System.out.print("head -> ");
		while(temp != null) {
			System.out.print(temp.getData() + " -> ");
			temp = temp.getNext();
		}
		System.out.print("tail\n");
	}
}
