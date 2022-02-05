import business.abstracts.SplayTreeService;
import business.concretes.SplayTreeManager;

public class Main {

	public static void main(String[] args) {
		
		SplayTreeService service = new SplayTreeManager();
		
		service.insert(15);
		service.insert(6);
		service.insert(20);
		service.insert(17);
		service.insert(30);
		service.insert(16);
		service.insert(18);
		
		System.out.println("Original version..");
		System.out.print("Pre-order\t: ");
		service.preOrder();
		
		System.out.print("\nIn-order\t: ");
		service.inOrder();
		
		System.out.print("\nPost-order\t: ");
		service.postOrder();
		
		System.out.print("\nLevel-order\t: ");
		service.levelOrder();
		
		System.out.println("\n\nBring 17 to the root.");
		service.splay(17);
		System.out.println("Modified version..");
		
		System.out.print("Pre-order\t: ");
		service.preOrder();
		
		System.out.print("\nIn-order\t: ");
		service.inOrder();
		
		System.out.print("\nPost-order\t: ");
		service.postOrder();
		
		System.out.print("\nLevel-order\t: ");
		service.levelOrder();
		
		System.out.println("\n\nDelete (17).");
		service.remove(17);
		System.out.print("Pre-order sort\t: ");
		service.preOrder();
		
		System.out.println("\n\nMin node\t: " + service.min());
		System.out.println("Max node\t: " + service.max());
		System.out.println("Search (17)\t: " + service.search(17));
		System.out.println("Search (20)\t: " + service.search(20));
		System.out.println("Height of Spay tree: " + service.height());
		System.out.println("The current number of nodes in the tree\t: " + service.numberOfNodes());
	}
}
