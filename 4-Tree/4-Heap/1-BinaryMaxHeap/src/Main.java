
public class Main {

	public static void main(String[] args) {
		
		BinaryMaxHeap heap = new BinaryMaxHeap(5);

		heap.insert(16);
		heap.insert(10);
		heap.insert(12);
		heap.insert(33);
		heap.insert(50);
		
		System.out.print("Max heap: ");
		heap.print();
		
		System.out.println("\n\nDelete root.");
		heap.remove();
		System.out.print("Max heap: ");
		heap.print();
		
		System.out.println("\n\nMax value: " + heap.getMax());
		System.out.println("Search(12): " + heap.search(12));
		System.out.println("Search(1) : " + heap.search(1));
	}
}
