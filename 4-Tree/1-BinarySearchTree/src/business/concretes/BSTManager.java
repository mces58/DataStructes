package business.concretes;

import business.abstracts.BSTService;
import entities.concretes.Node;

public class BSTManager implements BSTService{
	private Node root;
	
	// constructor
	public BSTManager() {
		root = null;
	}
	
	// create a new node
	private Node newNode(int data) {
		this.root = new Node(data);
		return this.root;
	}
	
	// this method calls insertRec()
	@Override
	public void insert(int data) {
		this.root = insertRec(this.root, data);
	}

	// a recursive function to insert a new data in BST
	private Node insertRec(Node root, int data) {
		if(root == null)
			return newNode(data);
		if(data < root.getData())
			root.setLeft(insertRec(root.getLeft(), data)); // root.left = insertRec(root.left, data);
		else
			root.setRight(insertRec(root.getRight(), data)); // root.right = insertRec(root.right, data);
		
		return root;
	}
	
	// this method calls removeRec() 
	@Override
	public void remove(int data) {
		this.root = removeRec(this.root, data);
	}

	// a recursive function to delete an existing data in BST
	private Node removeRec(Node root, int data) {
		if(root == null)
			return root;
		
		if(data == root.getData()) {
			if(root.getLeft() == null && root.getRight() == null)
				return null;
			else if(root.getRight() == null) {
				root.setData(minRec(root.getRight())); // root.data = minRec(root.right);
				root.setRight(removeRec(root.getRight(), minRec(root.getRight()))); // root.right = removeRec(root.right, minRec(root.right));
				
				return root;
			}
			else {
				root.setData(maxRec(root.getLeft())); // root.data = maxRec(root.left);
				root.setLeft(removeRec(root.getLeft(), maxRec(root.getLeft()))); // root.left = removeRec(root.left, maxRec(root.left));
				
				return root;
			}
		}
		else if(root.getData() < data) {
			root.setRight(removeRec(root.getRight(), data)); // root.right = removeRec(root.right, data);
			
			return root;
		}
		else {
			root.setLeft(removeRec(root.getLeft(), data)); // root.left = removeRec(root.left, data);
			
			return root;
		}
	}
	
	// this method calls minRec() 
	@Override
	public int min() {
		return minRec(this.root);
	}
	
	// returns the minimum value in BST
	private int minRec(Node root) {
		if(root == null)
			return Integer.MIN_VALUE;
		
		while(root.getLeft() != null)
			root = root.getLeft();
		
		return root.getData();
	}
	
	// this method calls maxRec()
	@Override
	public int max() {
		return maxRec(this.root);
	}

	// returns the maximum value in BST
	private int maxRec(Node root) {
		if(root == null)
			return Integer.MIN_VALUE;
		
		while(root.getRight() != null)
			root = root.getRight();
		
		return root.getData();
	}
	
	// this method calls searchRec()
	@Override
	public boolean search(int data) {
		boolean flag = searchRec(this.root, data);
		
		return flag;
	}

	// a recursive function to search for data in BST
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

	// a utility function to do preOrder traversal of BST
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

	// a utility function to do inOrder traversal of BST
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

	// a utility function to do postOrder traversal of BST
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

	// a utility function to do levelOrder traversal of BST
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
	
	// this method calls heightRec()
	@Override
	public int height() {
		int height = heightRec(this.root);
		
		return height;
	}

	// a recursive function to find height in BST
	private int heightRec(Node root) {
		if(root == null)
			return 0;
		
		int left = heightRec(root.getLeft());
		int right = heightRec(root.getRight());
		
		if(left > right)
			return left + 1;
		else
			return right + 1;
	}
	
	// this method calls numberOfNodesRec()
	@Override
	public int numberOfNodes() {
		return numberOfNodesRec(this.root);
	}

	// a recursive function to find number of nodes in BST
	private int numberOfNodesRec(Node root) {
		if(root == null)
			return 0;
		
		return numberOfNodesRec(root.getLeft()) + numberOfNodesRec(root.getRight()) + 1;
	}
	
	// finding the maximum number of nodes that can be added to the BST
	// the max number of nodes is calculated with  2^height - 1
	@Override
	public double maxNumberOfNodes() {
		double x = Math.pow(2, height()) - 1;
		
		return x;
	}
}
