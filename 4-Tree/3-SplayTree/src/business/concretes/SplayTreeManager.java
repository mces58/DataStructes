package business.concretes;

import business.abstracts.SplayTreeService;
import entities.concretes.Node;

public class SplayTreeManager implements SplayTreeService{
	private Node root;
	
	// constructor
	public SplayTreeManager() {
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
    
    // this method calls insert(Node root, int data)
    @Override
	public void insert(int data) {
		this.root = insert(this.root, data);
	}

    // a recursive function to insert a new data in Splay tree
	private Node insert(Node root, int data) {
		// same with BST
		if(root == null)
			return newNode(data);
		
		if(data < root.getData())
			root.setLeft(insert(root.getLeft(), data)); // root.left = insertRec(root.left, data);
		
		else
			root.setRight(insert(root.getRight(), data)); // root.right = insertRec(root.right, data);
		
		root.setHeight(1 + Math.max(height(), data)); // root.height = Math.max(height(root.left), height(root.right)) + 1;
		
		return root;
	}
	
	// this method calls remove(Node root, int data)
	@Override
	public void remove(int data) {
		this.root = remove(this.root, data);
	}
	
	// a recursive function to delete an existing data in Splay tree
	private Node remove(Node root, int data) {
		// deletion is the same as AVL
		// however, rotations are not performed here
		if(root == null)
			return root;
		
		if(data < root.getData())
			root.setLeft(remove(root.getLeft(), data)); // root.left = removeRec(root.left, data);
		
		else if(data > root.getData())
			root.setRight(remove(root.getRight(), data)); // root.right = removeRec(root.right, data);
		
		else {
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
				Node temp = min(root.getRight());
				root.setData(temp.getData()); // root.data = temp.data;
				root.setRight(remove(root.getRight(), temp.getData())); // root.right = removeRec(root.right, temp.data);
			}
		}
		if(root == null)
			return root;
		
		root.setHeight(1 + Math.max(height(root.getLeft()), height(root.getRight()))); // root.height = Math.max(height(root.left), height(root.right)) + 1;
		
		return root;
	}
	
	// this method calls splay(Node root, int data)
	@Override
	public void splay(int data) {
		this.root = splay(this.root, data);
	}

	// this function returns the searched node to root 
	// returns the last accessed item to the root if the searched node is not in the tree
	// this function changes the tree and returns the new root
	// the Splay tree does not need to be balanced.
	private Node splay(Node root, int data) {
		// root is empty or root has key
		if(root == null || root.getData() == data)
			return root;
		
		root.setHeight(1 + Math.max(height(root.getLeft()), height(root.getRight()))); // root.height = Math.max(height(root.left), height(root.right)) + 1;
		
		if(root.getData() > data) {
			// key is not in tree, we are done
			if(root.getLeft() == null)
				return root;
			
			// zig-zig 
			if(root.getLeft().getData() > data) {
				root.getLeft().setLeft(splay(root.getLeft().getLeft(), data));
				root = rightRotate(root);
			}
			// zig-zag
			else if(root.getLeft().getData() < data) {
				root.getLeft().setRight(splay(root.getLeft().getRight(), data));
				
				if(root.getLeft().getRight() != null) 
					root.setLeft(leftRotate(root.getLeft()));
			}
			return (root.getLeft() == null) ? root : rightRotate(root);	
		}
		else {
			if(root.getRight() == null) 
				return root;
			
			// zag-zig
			if(root.getRight().getData() > data) {
				root.getRight().setLeft(splay(root.getRight().getLeft(), data));
				
				if(root.getRight().getLeft() != null)
					root.setRight(rightRotate(root.getRight()));
				
			}
			// zag-zag 
			else if(root.getRight().getData() < data) {
				root.getRight().setRight(splay(root.getRight().getRight(), data));
				root = leftRotate(root);
			}
			return (root.getLeft() == null) ? root : leftRotate(root);
		}
	}
	
	// this method calls min(Node root) 
	@Override
	public int min() {
		if(root == null)
			return Integer.MIN_VALUE;
		
		Node temp = min(this.root);
		
		return temp.getData();
	}
	
	// returns the node with the minimum value in the Splay tree
	private Node min(Node root) {
		while(root.getLeft() != null)
			root = root.getLeft();
		
		return root;
	}
	
	// this method calls max(Node root)
	@Override
	public int max() {
		if(root == null)
			return Integer.MIN_VALUE;
		
		Node temp = max(this.root);
		
		return temp.getData();
	}
	
	// returns the node with the maximum value in the Splay tree
	private Node max(Node root) {
		while(root.getRight() != null)
			root = root.getRight();
		
		return root;
	}
	
	// this method calls search(Node root, int data)
	@Override
	public boolean search(int data) {
		boolean flag = search(this.root, data);
		
		return flag;
	}
	
	// the search function for Splay tree
	// Splay is already a search function
	// then can also be used here
	// but I didn't use it
	private boolean search(Node root, int data) {
		if(root == null)
			return false;
		
		if(root.getData() == data)
			return true;
		
		if(search(root.getLeft(), data) == true)
			return true;
		
		else if(search(root.getRight(), data) == true)
			return true;
		
		else
			return false;
	}
	
	// this method calls preOrder(Node root)
	@Override
	public void preOrder() {
		preOrder(this.root);
	}
	
	// a utility function to do preOrder traversal of Splay tree
	private void preOrder(Node root) {
		if(root != null) {
			System.out.print(root.getData() + " ");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}
	
	// this method calls inOrder(Node root)
	@Override
	public void inOrder() {
		inOrder(this.root);
	}
	
	// a utility function to do inOrder traversal of Splay tree
	private void inOrder(Node root) {
		if(root != null) {
			inOrder(root.getLeft());
			System.out.print(root.getData() + " ");
			inOrder(root.getRight());
		}
	}
	
	// this method calls postOrder(Node root)
	@Override
	public void postOrder() {
		postOrder(this.root);
	}
	
	// a utility function to do postOrder traversal of Splay tree
	private void postOrder(Node root) {
		if(root != null) {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(root.getData() + " ");
		}
	}
	
	// this method calls levelOrder(Node root, int height)
	@Override
	public void levelOrder() {
		int height = height();
		
		for(int i = 0; i <= height; i++)
			levelOrder(this.root, i);
	}
	
	// a utility function to do levelOrder traversal of Splay tree
	private void levelOrder(Node root, int height) {
		if(root == null)
			return;
		
		if(height == 1)
			System.out.print(root.getData() + " ");
		
		else if(height > 1) {
			levelOrder(root.getLeft(), height - 1);
			levelOrder(root.getRight(), height - 1);
		}
	}
	
	// this method calls numberOfNodes(Node root)
	@Override
	public int numberOfNodes() {
		return numberOfNodes(this.root);
	}
	
	// a recursive function to find number of nodes in Splay tree
	private int numberOfNodes(Node root) {
		if(root == null)
			return 0;
		
		return numberOfNodes(root.getLeft()) + numberOfNodes(root.getRight()) + 1;
	}
}
