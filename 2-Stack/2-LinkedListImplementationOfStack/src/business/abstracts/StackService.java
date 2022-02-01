package business.abstracts;

public interface StackService {
	void push(int data);
	int pop();
	int peak();
	int max();
	int min();
	boolean search(int data);
	int numberOfNodes();
	void print();
}
