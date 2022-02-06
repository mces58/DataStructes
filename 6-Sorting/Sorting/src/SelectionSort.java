import java.util.Random;

public class SelectionSort {

	public static void main(String[] args) {
		int size = 10;
		int[] array = create(size);
		
		System.out.print("Unsorted\t: ");
		print(array);
		
		System.out.print("Selection sort\t: ");
		selectionSort(array);
		print(array);
	}
	
	public static int[] create(int size) {
		int[] array = new int[size];
		Random random = new Random();
		
		for(int i = 0; i < array.length; i++)
			array[i] = random.nextInt(100);
		
		return array;
	}
	
	// best case O(n^2) , worst case O(n^2)
	public static void selectionSort(int[] array) {
		int minIndex;
		
		for(int i = 0; i < array.length; i++) {
			minIndex = i;
			
			for(int j = i + 1; j < array.length; j++) {
				if(array[j] < array[minIndex]) // if(array[j] > array[minIndex]) in order from largest to smallest
					minIndex = j;
			}
			swap(array, i, minIndex);
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
