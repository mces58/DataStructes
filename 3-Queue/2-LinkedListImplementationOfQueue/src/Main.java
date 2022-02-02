import java.util.Random;

import business.abstracts.QueueService;
import business.concretes.QueueManager;

public class Main {

	public static void main(String[] args) {
		QueueService service = new QueueManager();
		Random random = new Random();

		for(int i = 0; i < 5; i++)
			service.enQueue(random.nextInt(50));
		
		System.out.println("\nThe queue:");
		service.print();
		
		System.out.println("\n" + service.deQueue() + " dequeued from queue.\n");
		System.out.println("The queue:");
		service.print();
		
		
		System.out.println("\nFront element is: " + service.front());
		System.out.println("Rear element is: " + service.rear());
		System.out.println("Max element is: " + service.max());
		System.out.println("Min element is: " + service.min());
		System.out.println("Search (0): " + service.search(0));
		System.out.println("Number of elements in the queue: " + service.numberOfNodes());
	}
}
