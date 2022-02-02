package business.abstracts;

import entities.concretes.BakerNode;

public interface BakerService {
	void enQueue(BakerNode customer);
	String deQueue();
	double totalRevenue();
	void print();
}
