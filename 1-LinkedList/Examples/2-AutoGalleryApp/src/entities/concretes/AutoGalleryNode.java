package entities.concretes;

public class AutoGalleryNode {
	private String vrp; // vehicle registration plate
	private String brand;
	private int model;
	private String color;
	private String fuelType;
	private double hp; // horse power
	private double purchasePrice;
	private double salePrice;
	private AutoGalleryNode next;
	
	// constructor
	public AutoGalleryNode(String vrp, String brand, int model, String color, String fuelType, double hp, double purchasePrice) {
		this.vrp = vrp;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.fuelType = fuelType;
		this.hp = hp;
		this.purchasePrice = purchasePrice;
		this.salePrice = this.purchasePrice * 1.2;
		this.next = null;
	}

	// getter & setter
	public String getVrp() {
		return vrp;
	}

	public void setVrp(String vrp) {
		this.vrp = vrp;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public double getHp() {
		return hp;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public AutoGalleryNode getNext() {
		return next;
	}

	public void setNext(AutoGalleryNode next) {
		this.next = next;
	}

	public double getSalePrice() { // no setter
		return salePrice;
	}
}
