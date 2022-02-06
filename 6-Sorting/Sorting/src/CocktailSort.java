import java.util.Random;

public class CocktailSort {

	public static void main(String[] args) {
		int size = 10;
		int[] array = create(size);
		
		System.out.print("Unsorted\t: ");
		print(array);
		
		System.out.print("Cocktail sort\t: ");
		cocktailSort(array);
		print(array);
	}
	
	public static int[] create(int size) {
		int[] array = new int[size];
		Random random = new Random();
		
		for(int i = 0; i < array.length; i++)
			array[i] = random.nextInt(100);
		
		return array;
	}
	
	// best case O(n) , worst case O(n^2)
	public static void cocktailSort(int[] array) {
		boolean swapped = true;
		int start = 0;
		int end = array.length;
		
		while(swapped) {
			swapped = false;
			
			for(int i = start; i < end - 1; i++) {
				if(array[i] > array[i + 1]) { // if(array[i] < array[i + 1]) in order from largest to smallest
					swap(array, i, i + 1);
					swapped = true;
				}
			}
			if(swapped == false)
				break;
			
			swapped = false;
			end = end - 1;
			
			for(int i = end - 1; i >= start; i--) {
				if(array[i] > array[i + 1]) { // if(array[i] < array[i + 1]) in order from largest to smallest
					swap(array, i, i + 1);
					swapped = true;
				}
			}
			start++;
		}
	}
	
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b]; 
		array[b] = temp;
	}
	
	public static void print(int[] array) {
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
}
