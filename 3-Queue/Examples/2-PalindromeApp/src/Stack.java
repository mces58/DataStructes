
public class Stack {
	private Node top;
	private final int capacity;
	private int size;
	
	public Stack(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.top = null;
	}
	
	private boolean isFull() {
		return size == capacity;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void push(char character) {
		if(!isFull()) {
			Node node = new Node(character);
			
			if(isEmpty())
				top = node;
			else {
				node.setNext(top);
				top = node;
			}
			size++;
		}
	}
	
	public char pop() {
		if(!isEmpty()) {
			char character = top.getCharacter();
			top = top.getNext();
			size--;
			return character;
		}
		return 1;
	}
}
