
public class BinaryMinHeap {
	private int[] array;
	private final int capacity;
	private int heapSize;
	
	// constructor
	public BinaryMinHeap(int capacity) {
		this.capacity = capacity;
		this.heapSize = 0;
		this.array = new int[this.capacity];
	}
	
	// check if it is full
	private boolean isFull() {
		return heapSize == capacity;
	}
	
	// check if it is empty
	private boolean isEmpty() {
		return heapSize == 0;
	}
	
	// to heapify a subtree with the root at given index
	private int getParent(int i) {
		return (i - 1) / 2;
	}
	
	// to get index of left child of node at index i
	private int getLeftChild(int i) {
		return (2 * i) + 1;
	}
	
	// to get index of right child of node at index i
	private int getRightChild(int i) {
		return (2 * i) + 2;
	}
	
	// a utility function to swap two elements
	private void swap(int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	// a recursive method to heapify a subtree with the root at given index
	// this method assumes that the subtrees are already heapified
	private void minHeapify(int i) {
		int left = getLeftChild(i);
		int right = getRightChild(i);
		int smallest = 0;
		
		if(left < heapSize && array[left] < array[i])
			smallest = left;
		else
			smallest = i;
		
		if(right < heapSize && array[right] < array[smallest])
			smallest = right;
		
		if(smallest != i) {
			swap(smallest, i);
			minHeapify(smallest);
		}
	}
	
	// return min value
	public int getMin() {
		return array[0];
	}
	
	// inserts a new data 
	public void insert(int data) {
		if(isFull()) {
			System.out.println("Heap Overflow!");
			return;
		}
		heapSize++;
		int i = heapSize - 1;
		
		array[i] = data;
		while(i != 0 && array[i] < array[getParent(i)]) {
			swap(i, getParent(i));
			i = getParent(i);
		}
	}
	
	// this function deletes data at index i
	public void remove() {
		if(isEmpty()) {
			System.out.println("Heap Underflow!");
			return;
		}
		swap(0, heapSize - 1);
		heapSize--;
		minHeapify(0);
	}
	
	// a utility function to search for data in the heap
	public boolean search(int data) {
		if(isEmpty())
			return false;
		
		for(int i = 0; i < heapSize; i++) {
			if(data == array[i])
				return true;
		}
		return false;
	}
	
	// print the heap
	public void print() {
		if(isEmpty()) {
			System.out.println("Heap Underflow!");
			return;
		}
		for(int i = 0; i < heapSize; i++)
			System.out.print(array[i] + " ");
	}
}
