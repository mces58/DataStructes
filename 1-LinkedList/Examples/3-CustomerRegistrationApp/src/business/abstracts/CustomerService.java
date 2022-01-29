package business.abstracts;

import entities.concretes.CustomerNode;

public interface CustomerService {
	void insertFirst(CustomerNode customer);
	void insertLast(CustomerNode customer);
	void remove(int id);
	void search(int id);
	int numberOfCustomers();
	void print();
}
