import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		int size = 5;
		Stack stack = new Stack(size);
		Random random = new Random();
		
		for(int i = 0; i < size; i++)
			stack.push(random.nextInt(50));

		System.out.println("\nThe stack: ");
		stack.print();
		
		System.out.println("\nPopped from stack: " + stack.pop());
		System.out.println("\nThe stack: ");
		stack.print();
		
		System.out.println("\nTop element is: " + stack.peak());
		System.out.println("Max element is: " + stack.max());
		System.out.println("Min element is: " + stack.min());
		System.out.println("Search (5): " + stack.search(5));
	}
}
