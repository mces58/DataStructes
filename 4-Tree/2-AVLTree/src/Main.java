import business.abstracts.AVLTreeService;
import business.concretes.AVLTreeManager;

public class Main {

	public static void main(String[] args) {
		
		AVLTreeService service = new AVLTreeManager();
		
		service.insert(4);
		service.insert(10);
		service.insert(30);
		service.insert(15);
		service.insert(20);
		service.insert(17);
		service.insert(40);
		service.insert(2);
		
		System.out.print("Pre-order sort\t:");
		service.preOrder();
		
		System.out.print("\nIn-order sort\t:");
		service.inOrder();
		
		System.out.print("\nPost-order sort\t:");
		service.postOrder();
		
		System.out.print("\nLevel-order sort\t:");
		service.levelOrder();
		
		System.out.println("\n\nDelete (15).");
		service.remove(15);
		System.out.print("Pre-order sort\t:");
		service.preOrder();
		
		System.out.println("\n\nMin node\t: " + service.min());
		System.out.println("Max node\t: " + service.max());
		System.out.println("Search (15)\t: " + service.search(15));
		System.out.println("Search (10)\t: " + service.search(10));
		System.out.println("Height of AVL\t: " + service.height());
		System.out.println("The current number of nodes in the tree\t: " + service.numberOfNodes());
	}
}
