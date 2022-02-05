package business.abstracts;

public interface AVLTreeService {
	int height();
	void insert(int data);
	void remove(int data);
	int min();
	int max();
	boolean search(int data);
	void preOrder();
	void inOrder();
	void postOrder();
	void levelOrder();
	int numberOfNodes();
}
