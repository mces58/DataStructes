package entities.concretes;

public class AutoParkingNode {
	private String vrp; // vehicle registration plate
	private String checkInTime; 
	private String checkOutTime;
	private long timeSpent;
	private double pay; 
	private int index;
	private AutoParkingNode next;
	private AutoParkingNode prev;
	
	// constructor
	public AutoParkingNode(String vrp, String checkInTime) {
		this.vrp = vrp;
		this.checkInTime = checkInTime;
		this.checkOutTime = null;
		this.timeSpent = 0;
		this.pay = 0;
		this.index = 0;
		this.next = null;
		this.prev = null;
	}

	// getter & setter
	public String getVrp() {
		return vrp;
	}

	public void setVrp(String vrp) {
		this.vrp = vrp;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public long getTimeSpent() {
		return timeSpent;
	}

	public void setTimeSpent(long timeSpent) {
		this.timeSpent = timeSpent;
	}

	public double getPay() {
		return pay;
	}

	public void setPay(double pay) {
		this.pay = pay;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public AutoParkingNode getNext() {
		return next;
	}
	
	public void setNext(AutoParkingNode next) {
		this.next = next;
	}

	public AutoParkingNode getPrev() {
		return prev;
	}

	public void setPrev(AutoParkingNode prev) {
		this.prev = prev;
	}
}
