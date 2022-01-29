package business.abstracts;

import entities.concretes.AutoGalleryNode;

public interface AutoGalleryService {
	void insertFirst(AutoGalleryNode newCar);
	void insertLast(AutoGalleryNode newCar);
	void remove(String vrp);
	void search(String vrp);
	int numberOfCars();
	void print();
}
