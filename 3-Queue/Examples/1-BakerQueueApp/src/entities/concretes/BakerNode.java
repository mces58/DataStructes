package entities.concretes;

public class BakerNode {
	private String name;
	private int number;
	private double price;
	private BakerNode next;
	
	public BakerNode(String name, int number) {
		this.name = name;
		this.number = number;
		this.price = this.number * 3.75;
		this.next = null;
	}

	public BakerNode getNext() {
		return next;
	}

	public void setNext(BakerNode next) {
		this.next = next;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	public double getPrice() {
		return price;
	}
}
