import java.util.Random;

import business.abstracts.StackService;
import business.concretes.StackManager;

public class Main {

	public static void main(String[] args) {
		StackService service = new StackManager();
		Random random = new Random();
		
		for(int i = 0; i < 5; i++)
			service.push(random.nextInt(50));
		
		System.out.println("\nThe stack:");
		service.print();
		
		System.out.println("\nPopped from stack: " + service.pop());
		System.out.println("\nThe stack:");
		service.print();
		
		System.out.println("\nTop element is: " + service.peak());
		System.out.println("Max element is: " + service.max());
		System.out.println("Min element is: " + service.min());
		System.out.println("Search (0): " + service.search(0));
		System.out.println("Number of elements in the stack: " + service.numberOfNodes());
	}
}
