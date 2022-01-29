package business.abstracts;

import entities.concretes.AutoParkingNode;

public interface AutoParkingService {
	void add(AutoParkingNode car);
	void remove(String vrp, String checkOutTime);
	double totalEarnings();
	void search(String vrp);
	int numberOfCars();
	void print();
}
