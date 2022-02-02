
public class Queue {
	private Node front;
	private Node rear;
	private final int capacity;
	private int size;
	
	public Queue(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.front = null;
		this.rear = null;
	}
	
	private boolean isFull() {
		return size == capacity;
	}
	
	private boolean isEmpty() {
		return size == 0;
	}
	
	public void enQueue(char character) {
		if(!isFull()) {
			Node node = new Node(character);
			
			if(isEmpty())
				front = rear = node;
			else {
				rear.setNext(node);
				rear = node;
			}
			size++;
		}
	}
	
	public char deQueue() {
		if(!isEmpty()) {
			char character = front.getCharacter();
			front = front.getNext();
			size--;
			return character;
		}
		else
			return 1;
	}
}
