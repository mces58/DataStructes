package business.abstracts;

public interface QueueService {
	void enQueue(int data);
	int deQueue();
	int max();
	int min();
	boolean search(int data);
	int numberOfNodes();
	int front();
	int rear();
	void print();
}
