
public class Main {

	public static void main(String[] args) {
		
		BinaryMinHeap heap = new BinaryMinHeap(5);

		heap.insert(16);
		heap.insert(10);
		heap.insert(12);
		heap.insert(33);
		heap.insert(50);
		
		System.out.print("Min heap: ");
		heap.print();
		
		System.out.println("\n\nDelete root.");
		heap.remove();
		System.out.print("Min heap: ");
		heap.print();
		
		System.out.println("\n\nMin value: " + heap.getMin());
		System.out.println("Search(12): " + heap.search(12));
		System.out.println("Search(1) : " + heap.search(1));
	}
}
