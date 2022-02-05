package business.abstracts;

public interface SplayTreeService {
	int height();
	void insert(int data);
	void remove(int data);
	void splay(int data);
	int min();
	int max();
	boolean search(int data);
	void preOrder();
	void inOrder();
	void postOrder();
	void levelOrder();
	int numberOfNodes();
}
