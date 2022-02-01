
public class Stack {
	private int[] array;
	private final int size;
	private int index;
	
	public Stack(int size) {
		this.size = size;
		this.index = 0;
		this.array = new int[size];
	}
	
	private boolean isEmpty() {
		return index == 0;
	}
	
	private boolean isFull() {
		return index == size;
	}
	
	public void push(int data) {
		if(isFull()) {
			System.out.println("Stack Overflow.");
			return;
		}
		array[index++] = data;
		System.out.println(data + " pushed into stack.");
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack Underflow.");
			return -1;
		}
//		int pop = array[--index];
//		return pop;
		return array[--index];
	}
	
	public int peak() {
		if(isEmpty()) {
			System.out.println("Stack Underflow.");
			return -1;
		}
		int top = index - 1;
		return array[top];
	}
	
	public int max() {
		if(isEmpty()) {
			System.out.println("Stack Underflow.");
			return -1;
		}
		int max = array[0];
		int temp = 0;
		
		while(temp != index) {
			if(array[temp] > max)
				max = array[temp];
			temp++;
		}
		return max;
	}
	
	public int min() {
		if(isEmpty()) {
			System.out.println("Stack Underflow.");
			return -1;
		}
		int min = array[0];
		
		for(int i = 0; i < index; i++) {
			if(array[i] < min)
				min = array[i];
		}
		return min;
	}
	
	public boolean search(int data) {
		if(isEmpty()) {
			System.out.println("Stack Underflow.");
			return false;
		}
		boolean flag = false;
		
		for(int i = 0; i < index; i++) {
			if(array[i] == data) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public void print() {
		if(isEmpty()) {
			System.out.println("Stack Underflow.");
			return;
		}
		for(int i = index - 1; i >= 0 ; i--)
			System.out.println(array[i]);
	}
}
