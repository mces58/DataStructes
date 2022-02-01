package business.concretes;

import business.abstracts.StackService;
import entities.concretes.Node;

public class StackManager implements StackService{
	private Node top;
	
	
	public StackManager() {
		this.top = null;
	}
	
	private Node newNode(int data) {
		Node newNode = new Node(data);
		
		newNode.setData(data);
		newNode.setNext(null);
		
		return newNode;
	}
	
	private boolean isEmpty() {
		if(top == null)
			return true;
		return false;
	}
	
	@Override
	public void push(int data) {
		Node newNode = newNode(data);
		
		if(isEmpty()) {
			top = newNode;
		}
		else {
			newNode.setNext(top); // newNode.next = top;
			top = newNode;
		}
		System.out.println(data + " pushed to stack.");
	}
	
	@Override
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty.");
			return -1;
		}
		int pop = top.getData();
		top = top.getNext();
		return pop;
	}
	
	@Override
	public int peak() {
		if(isEmpty()) {
			System.out.println("Stack is empty.");
			return -1;
		}
		return top.getData();
	}
	
	@Override
	public int max() {
		if(isEmpty()) {
			System.out.println("Stack is empty.");
			return -1;
		}
		int max = top.getData();
		Node temp = top;
		
		while(temp != null) {
			if(temp.getData() > max)
				max = temp.getData();
			temp = temp.getNext();
		}
		return max;
	}
	
	@Override
	public int min() {
		if (isEmpty()) {
			System.out.println("Stack is empty.");
			return -1;
		}
		int min = top.getData();
		Node temp = top;
		
		while(temp != null) {
			if(temp.getData() < min)
				min = temp.getData();
			temp = temp.getNext();
		}
		return min;
	}
	
	@Override
	public boolean search(int data) {
		if (isEmpty()) {
			System.out.println("Stack is empty.");
			return false;
		}
		Node temp = top;
		boolean flag = false;
		
		while(temp != null) {
			if(temp.getData() == data) {
				flag = true;
				break;
			}
			temp = temp.getNext();
		}
		return flag;
	}
	
	@Override
	public int numberOfNodes() {
		if(isEmpty()) {
			System.out.println("Stack is empty.");
			return 0;
		}
		int count = 0;
		Node temp = top;
		
		while(temp != null) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}
	
	@Override
	public void print() {
		if(isEmpty()) {
			System.out.println("Stack is empty.");
			return;
		}
		Node temp = top;
		
		while(temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}
}
