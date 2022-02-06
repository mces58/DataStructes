import java.util.Random;

public class InsertionSort {

	public static void main(String[] args) {
		int size = 10;
		int[] array = create(size);
		
		System.out.print("Unsorted\t: ");
		print(array);
		
		System.out.print("Insertion sort\t: ");
		insertionSort(array);
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
	public static void insertionSort(int[] array) {
		for(int i = 1; i < array.length; i++) {
			int key = array[i];
			int j = i - 1;
			
			while(j >= 0 && array[j] > key) { // while(j>= 0 && array[j] < key) in order from largest to smallest
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}
	}
	
	public static void print(int[] array) {
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
}
