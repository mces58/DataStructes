import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		int capacity = 5;
		
		Queue queue = new Queue(capacity);
		Random random = new Random();
		
		for(int i = 0; i < capacity; i++)
			queue.enQueue(random.nextInt(50));
		
		System.out.println("\nThe queue:");
		queue.print();
		
		System.out.println("\n" + queue.deQueue() + " dequeued from queue.\n");
		System.out.println("The queue:");
		queue.print();
		 
		System.out.println("\nFront element is: " + queue.front());
		System.out.println("Rear element is: " + queue.rear());
	    System.out.println("Max element is: " + queue.max());
	    System.out.println("Min element is: " + queue.min());
	    System.out.println("Search (1): " + queue.search(1));
	}
}
