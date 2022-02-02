import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int capacity = 100;
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		Stack stack = new Stack(capacity);
		Queue queue = new Queue(capacity);
		
		System.out.print("Enter a word or number: ");
		String string = scan.nextLine();
		char[] ch = string.toCharArray();
		boolean flag = true;

		for(int i = 0; i < string.length(); i++) {
			stack.push(ch[i]);
			queue.enQueue(ch[i]);
		}
		
		while(!stack.isEmpty()) {
			if(stack.pop() != queue.deQueue()) {
				flag = false;
				break;
			}
		}
		
		if(flag)
			System.out.println(string + " is palindrome.");
		else
			System.out.println(string + " is not palindrome.");
	}
}
