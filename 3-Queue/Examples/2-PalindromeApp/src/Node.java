
public class Node {
	private char character;
	private Node next;
	
	public Node(char character) {
		this.character = character;
		this.next = null;
	}

	public char getCharacter() {
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
