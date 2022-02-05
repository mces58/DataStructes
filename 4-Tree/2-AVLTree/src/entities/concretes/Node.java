package entities.concretes;

public class Node {
	private int data;
	private int height;
	private Node left;
	private Node right;
	
	// constructor
	public Node(int data) {
		this.data = data;
		this.height = 1;
		this.left = null;
		this.right = null;
	}

	// getter & setter
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}
