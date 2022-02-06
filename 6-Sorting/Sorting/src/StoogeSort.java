import java.util.Random;

public class StoogeSort {

	public static void main(String[] args) {
		int size = 10;
		int[] array = create(size);
		
		System.out.print("Unsorted\t: ");
		print(array);
		
		System.out.print("Stooge sort\t: ");
		stoogeSort(array, 0, array.length - 1);
		print(array);
	}
	
	public static int[] create(int size) {
		int[] array = new int[size];
		Random random = new Random();
		
		for(int i = 0; i < array.length; i++)
			array[i] = random.nextInt(100);
		
		return array;
	}
	
	// best case O(n^(log3/log1.5)) , worst case O(n^(log3/log1.5))
	public static void stoogeSort(int[] array, int lower, int upper) {
		if(lower > upper)
			return;
		
		if(array[lower] > array[upper]) // if(array[lower] > array[upper]) in order from largest to smallest
			swap(array, lower, upper);
		
		if(upper - lower + 1 > 2) {
			int t = (upper - lower + 1) / 3;
			
			stoogeSort(array, lower, upper - t);
			stoogeSort(array, lower + t, upper);
			stoogeSort(array, lower, upper - t);
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
