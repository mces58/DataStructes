import java.util.Random;

import business.abstracts.ListService;
import business.concretes.ListManager;

public class Main {

	public static void main(String[] args) {
		ListService service = new ListManager();
		Random random = new Random();
		
		for(int i = 5; i > -1; i--)
			service.insertFirst(random.nextInt(50));
		for(int i = 6; i < 10; i++)
			service.insertLast(random.nextInt(50));
		
		System.out.println("The list:");
		service.print();
		
		System.out.println("\nAfter two deletions from the beginning of the list: ");
		service.removeFirst();
		service.removeFirst();
		service.print();
		
		System.out.println("\nAfter two deletions from the end of the list: ");
		service.removeLast();
		service.removeLast(); 
		service.print();
		
		System.out.println("\nSorted:");
		service.sort();
		service.print();
		
		System.out.println("\nAre there 14 in the list: " + service.search(14));
		System.out.println("Number of nodes: " + service.numberOfNodes());
		System.out.println("Max node: " + service.maxNode());
		System.out.println("Min node: " + service.minNode());
	}
}
