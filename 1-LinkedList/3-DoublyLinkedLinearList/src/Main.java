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
		service.printLeftToRight();
		service.printRightToLeft();
		
		System.out.println("After two deletions from the beginning of the list: ");
		service.removeFirst(); 
		service.removeFirst();
		service.printLeftToRight();
		service.printRightToLeft();
		
		System.out.println("After two deletions from the end of the list: ");
		service.removeLast();
		service.removeLast(); 
		service.printLeftToRight();
		service.printRightToLeft();
		
		System.out.println("Sorted: ");
		service.sort();
		service.printLeftToRight();
		service.printRightToLeft();
		
		System.out.println("Are there 49 in the list: " + service.search(49));
		System.out.println("Number of nodes: " + service.numberOfNodes());
		System.out.println("Max node: " + service.maxNode());
		System.out.println("Min node: " + service.minNode());
	}
}
