package business.abstracts;

public interface ListService {
	void insertFirst(int data);
	void insertLast(int data);
	void removeFirst();
	void removeLast();
	void sort();
	boolean search(int data);
	int numberOfNodes();
	int maxNode();
	int minNode();
	void print();
}
