package business.concretes;

import business.abstracts.AVLTreeService;
import entities.concretes.Node;

public class AVLTreeManager implements AVLTreeService{
	private Node root;
	
	// constructor
	public AVLTreeManager() {
		this.root = null;
	}
	
	// create a new node
	private Node newNode(int data) {
		this.root = new Node(data);
		return this.root;
	}
	
	// this method calls height(Node root)
	@Override
	public int height() {
		return height(this.root);
	}
	
	// a utility function to get height of the tree
	private int height(Node root) {
		if(root == null)
			return 0;
		
		return root.getHeight();
	}
	
	// calculate the balance factor of the root of the node
	private int balanceFactor(Node root) {
		if(root == null)
			return 0;
		
		return height(root.getLeft()) - height(root.getRight());
	}
	
	// a utility function to rotate the subtree to the right
	private Node rightRotate(Node root) {
		Node rc = root.getLeft();
		Node T2 = rc.getRight();
		
		rc.setRight(root); // rc.right = root;
		root.setLeft(T2); // root.left = T2;
		
		root.setHeight(1 + Math.max(height(root.getLeft()), height(root.getRight()))); // root.height = Math.max(height(root.left), height(root.right)) + 1;
		rc.setHeight(1 + Math.max(height(rc.getLeft()), height(rc.getRight()))); // rc.height = Math.max(height(rc.left), height(rc.right)) + 1;
		
		return rc;
	}

	// a utility function to rotate the subtree to the left
    private Node leftRotate(Node root) {
        Node lc = root.getRight();
        Node T2 = lc.getLeft();

        lc.setLeft(root); // lc.left = root;
        root.setRight(T2); // lc.right = T2;
 
        root.setHeight(1 + Math.max(height(root.getLeft()), height(root.getRight()))); // lc.height = Math.max(height(lc.left), height(lc.right)) + 1;
        lc.setHeight(1 + Math.max(height(lc.getLeft()), height(lc.getRight()))); // root.height = Math.max(height(root.left), height(root.right)) + 1;

        return lc;
    }
	
	// this method calls insertRec()
	@Override
	public void insert(int data) {
		this.root = insertRec(this.root, data);
	}

	// a recursive function to insert a new data in AVL
	private Node insertRec(Node root, int data) {
		// 1- same with BST
		if(root == null)
			return newNode(data);
		
		if(data < root.getData())
			root.setLeft(insertRec(root.getLeft(), data)); // root.left = insertRec(root.left, data);
		
		else if(data > root.getData())
			root.setRight(insertRec(root.getRight(), data)); // root.right = insertRec(root.right, data);
		
		else // equal keys are not allowed
			return root;
		
		// 2- calculate the height of the root
		root.setHeight(1 + Math.max(height(root.getLeft()), height(root.getRight()))); // root.height = Math.max(height(root.left), height(root.right)) + 1;
		
		// 3- take the balance factor of this parent node to check if this node has become unbalanced
		int bf = balanceFactor(root);
		
		// if this node becomes unstable, there are 4 situations
		// LL
		if(bf > 1 && data < root.getLeft().getData())
			return rightRotate(root);
		
		// RR
		if(bf < -1 && data > root.getRight().getData())
			return leftRotate(root);
		
		// LR
		if(bf > 1 && data > root.getLeft().getData()) {
			root.setLeft(leftRotate(root.getLeft())); // root.left = leftRotate(root.left);
			return rightRotate(root);
		}
		// RL
		if(bf < -1 && data < root.getRight().getData()) {
			root.setRight(rightRotate(root.getRight())); // root.right = rightRotate(root.right);
			return leftRotate(root);
		}
		return root;
	}

	// this method calls removeRec()
	@Override
	public void remove(int data) {
		this.root = removeRec(this.root, data);
	}

	// a recursive function to delete an existing data in AVL
	private Node removeRec(Node root, int data) {
		//  1- same with BTS
		if(root == null)
			return root;
		
		if(data < root.getData())
			root.setLeft(removeRec(root.getLeft(), data)); // root.left = removeRec(root.left, data);
		
		else if(data > root.getData())
			root.setRight(removeRec(root.getRight(), data)); // root.right = removeRec(root.right, data);
		
		// if the key is the same as the root's key, this is the node to delete
		else {
			// node with or without children
			if(root.getLeft() == null || root.getRight() == null) {
				Node temp;
				
				if(root.getLeft() != null)
					temp = root.getLeft();
				else
					temp = root.getRight();
				
				if(temp == null) {
					temp = root;
					root = null;
				}
				else
					root = temp;
				
				temp = null;
			}
			else {
				Node temp = minRec(root.getRight());
				root.setData(temp.getData()); // root.data = temp.data;
				root.setRight(removeRec(root.getRight(), temp.getData())); // root.right = removeRec(root.right, temp.data);
			}
		}
		// if the tree has only one node then return
		if(root == null)
			return root;
		
		// 2- calculate the height of the root
		root.setHeight(1 + Math.max(height(root.getLeft()), height(root.getRight()))); // root.height = Math.max(height(root.left), height(root.right)) + 1;
		
		// 3- take the balance factor of this parent node to check if this node has become unbalanced
		int bf = balanceFactor(root);
		
		// if this node becomes unstable, there are 4 situations
		// LL
		if(bf > 1 && balanceFactor(root.getLeft()) >= 0)
			return rightRotate(root);
		
		// RR
		if(bf < -1 && balanceFactor(root.getRight()) <= 0)
			return leftRotate(root);
		
		// LR
		if(bf > 1 && balanceFactor(root.getLeft()) < 0) {
			root.setLeft(leftRotate(root.getLeft())); // root.left = leftRotate(root.left);
			return rightRotate(root);
		}
		// RL
		if(bf < -1 && balanceFactor(root.getRight()) > 0) {
			root.setRight(rightRotate(root.getRight())); // root.right = rightRotate(root.right);
			return leftRotate(root);
		}
		return root;
	}
	
	// this method calls minRec() 
	@Override
	public int min() {
		if(this.root == null)
			return Integer.MIN_VALUE;
		
		Node temp = minRec(this.root);
		return temp.getData();
	}
	
	// returns the node with the minimum value in the AVL
	private Node minRec(Node root) {
		while(root.getLeft() != null)
			root = root.getLeft();
		
		return root;
	}
	
	// this method calls maxRec()
	@Override
	public int max() {
		if(this.root == null)
			return Integer.MIN_VALUE;
		
		Node temp = maxRec(this.root);
		return temp.getData();
	}

	// returns the node with the maximum value in the AVL
	private Node maxRec(Node root) {
		while(root.getRight() != null)
			root = root.getRight();
		
		return root;
	}
	
	// this method calls searchRec()
	@Override
	public boolean search(int data) {
		boolean flag = searchRec(this.root, data);
		
		return flag;
	}

	// a recursive function to search for data in AVL
	private boolean searchRec(Node root, int data) {
		if(root == null)
			return false;
		
		if(data == root.getData())
			return true;
		
		if(searchRec(root.getLeft(), data) == true)
			return true;

		else if(searchRec(root.getRight(), data) == true)
			return true;
		
		else
			return false;
	}
	
	// this method calls preOrderRec()
	@Override
	public void preOrder() {
		preOrderRec(this.root);
	}
	
	// a utility function to do preOrder traversal of AVL
	private void preOrderRec(Node root) {
		if(root != null) {
			System.out.print(root.getData() + " ");
			preOrderRec(root.getLeft());
			preOrderRec(root.getRight());
		}
	}
	
	// this method calls inOrderRec()
	@Override
	public void inOrder() {
		inOrderRec(this.root);
	}
	
	// a utility function to do inOrder traversal of AVL
	private void inOrderRec(Node root) {
		if(root != null) {
			inOrderRec(root.getLeft());
			System.out.print(root.getData() + " ");
			inOrderRec(root.getRight());
		}
	}
	
	// this method calls postOrderRec()
	@Override
	public void postOrder() {
		postOrderRec(this.root);
	}
	
	// a utility function to do postOrder traversal of AVL
	private void postOrderRec(Node root) {
		if(root != null) {
			postOrderRec(root.getLeft());
			postOrderRec(root.getRight());
			System.out.print(root.getData() + " ");
		}
	}
	
	// this method calls levelOrderRec()
	@Override
	public void levelOrder() {
		int height = height();
		
		for(int i = 0; i <= height; i++)
			levelOrderRec(this.root, i);
	}
	
	// a utility function to do levelOrder traversal of AVL
	private void levelOrderRec(Node root, int height) {
		if(root == null)
			return;
		
		if(height == 1)
			System.out.print(root.getData() + " ");
		
		else if(height > 1) {
			levelOrderRec(root.getLeft(), height - 1);
			levelOrderRec(root.getRight(), height - 1);
		}
			
	}
	
	// this method calls numberOfNodesRec()
	@Override
	public int numberOfNodes() {
		return numberOfNodesRec(this.root);
	}
	
	// a recursive function to find number of nodes in AVL
	private int numberOfNodesRec(Node root) {
		if(root == null)
			return 0;
		
		return numberOfNodesRec(root.getLeft()) + numberOfNodesRec(root.getRight()) + 1; 
	}
}
