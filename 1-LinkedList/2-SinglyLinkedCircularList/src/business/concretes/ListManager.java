
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
			tail.setNext(head); // tail.next = head;
		}
		else {
			newNode.setNext(head); // newNode.next = head;
			head = newNode;
			tail.setNext(head); // tail.next = head;
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
			tail.setNext(head); // tail.next = head;
		}
		else {
			tail.setNext(newNode); // tail.next = newNode;
			tail = newNode;
			tail.setNext(head); // tail.next = head;
		}
	}
	
	// *******************************************
	// ********** Delete from beginning **********
	
	@Override
	public void removeFirst() {
		if(head == null)
			System.out.println("List is empty.");
		else if(head == tail) {
			head = null;
			tail = null;
		}
		else {
			head = head.getNext();
			tail.setNext(head); // tail.next = head;
		}
	}
	
	// *************************************
	// ********** Delete from end **********
	
	@Override
	public void removeLast() {
		if(head == null)
			System.out.println("List is empty.");
		else if(head == tail) {
			head = null;
			tail = null;
		}
		else {
			Node temp = head;
			
			while(temp.getNext() != tail)
				temp = temp.getNext();
			tail = temp;
			tail.setNext(head); // tail.next = head;
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
		for(Node i = head; i != tail; i = i.getNext()) {
			for(Node j = i.getNext(); j != head; j = j.getNext()) {
				if(i.getData() > j.getData()) {
					// swap
					int temp = i.getData(); 
					i.setData(j.getData()); // i.data = j.data;
					j.setData(temp); // j.data = temp;
				}
			}
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
		
		while(true) {
			if(temp.getData() == data)
				return true;
			temp = temp.getNext();
			if(temp == head)
				break;
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
		
		while(true) {
			count++;
			temp = temp.getNext();
			if(temp == head)
				break;
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
		
		while(true) {
			if(temp.getData() > max)
				max = temp.getData();
			temp = temp.getNext();
			if(temp == head)
				break;
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
		
		while(true) {
			if(temp.getData() < min)
				min = temp.getData();
			temp = temp.getNext();
			if(temp == head)
				break;
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
		while(true) {
			System.out.print(temp.getData() + " -> ");
			temp = temp.getNext();
			if(temp == head)
				break;
		}
		System.out.print("tail\n");
	}
}
