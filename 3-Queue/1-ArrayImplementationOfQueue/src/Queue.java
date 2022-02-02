
public class Queue {
	private final int capacity;
	private int front;
	private int rear;
	private int size;
	private int[] array;
	
	public Queue(int capacity) {
		this.capacity = capacity;
		this.front = 0;
		this.rear = -1;
		this.size = 0;
		this.array = new int[capacity];
	}
	
	private boolean isEmpty() {
		return size == 0;
	}
	
	private boolean isFull() {
		return size == capacity;
	}
	
	public void enQueue(int data) {
		if(isFull()) {
			System.out.println("Queue is full.");
			return;
		}	
//		rear = (rear + 1) % capacity;
//		array[rear] = data;
//		size++;
		
		if(rear + 1 == capacity)
			rear = -1;
		array[++rear] = data;
		size++;
		System.out.println(data + " queued up.");
	}
	
	public int deQueue() {
		if(isEmpty()) {
			System.out.println("Queue is empty.");
			return -1;
		}
//		int temp = array[front];
//		front = (front + 1) % capacity;
//		size--;
//		return temp;
		
		int temp = array[front++];
		
		if(front == capacity)
			front = 0;
		size--;
		return temp;
	}
	
	public int front() {
		if(isEmpty())
			return Integer.MIN_VALUE;
		return array[front];
	}
	
	public int rear() {
		if(isEmpty())
			return Integer.MIN_VALUE;
		return array[rear];
	}

	public int max() {
		if(isEmpty())
			return Integer.MIN_VALUE;
		
		int max = array[front];
		
		for(int i = front; i <= rear; i++) {
			if(array[i] > max)
				max = array[i];
		}
		return max;
	}
	
	public int min() {
		if(isEmpty())
			return Integer.MIN_VALUE;
		
		int min = array[front];
		
		for(int i = front; i <= rear; i++) {
			if(array[i] < min)
				min = array[i];
		}
		return min;
	}
	
	public boolean search(int data) {
		if(isEmpty())
			return false;
		
		boolean flag = false;
		
		for(int i = front; i <= rear; i++) {
			if(array[i] == data) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public void print() {
		if(isEmpty()) {
			System.out.println("Queue is empty.");
			return;
		}
		for(int i = front; i <= rear; i++)
			System.out.println(array[i]);
	}
}
