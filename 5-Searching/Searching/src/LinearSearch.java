
public class LinearSearch {
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5};
		int data = 1;
		int search = search(array, data);
		
		if(search == -1)
			System.out.println("The item does not exist in the array.");
		else
			System.out.println("The index number of the element: " + search);
		
	}
	
	public static int search(int[] array, int data) {
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == data)
				return i;
		}
		return -1;
	}
}