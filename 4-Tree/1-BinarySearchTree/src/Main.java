import business.abstracts.BSTService;
import business.concretes.BSTManager;

public class Main {

	public static void main(String[] args) {
		
		BSTService service = new BSTManager();

		service.insert(5);
		service.insert(3);
		service.insert(7);
		service.insert(2);
		service.insert(4);
		service.insert(6);
		service.insert(15);

		System.out.print("Pre-order sort\t: ");
		service.preOrder();
		
		System.out.print("\nIn-order sort\t: ");
		service.inOrder();
		
		System.out.print("\nPost-order sort\t: ");
		service.postOrder();
		
		System.out.print("\nLevel-order sort: ");
		service.levelOrder();
		
		System.out.println("\n\nDelete (5).");
		service.remove(5);
		System.out.print("Pre-order sort\t: ");
		service.preOrder();
		
		System.out.println("\n\nMin node\t: " + service.min());
		System.out.println("Max node\t: " + service.max());
		System.out.println("Search (5)\t: "+ service.search(5));
		System.out.println("Search (7)\t: "+ service.search(7));
		System.out.println("Height of BST\t: " + service.height());
		System.out.println("The current number of nodes in the tree\t: " + service.numberOfNodes());
		System.out.println("While the height of the BST is " + service.height() + ", it can hold a maximum of " + service.maxNumberOfNodes() + " nodes.");
	}
}
