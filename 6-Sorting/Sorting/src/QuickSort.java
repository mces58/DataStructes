import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {
		int size = 10;
		int[] array = create(size);
		
		System.out.print("Unsorted\t: ");
		print(array);
		
		System.out.print("Quick sort\t: ");
		quickSort(array, 0, array.length - 1);
		print(array);
	}
	
	public static int[] create(int size) {
		Random random = new Random();
		int[] array = new int[size];
		
		for(int i = 0; i < array.length; i++)
			array[i] = random.nextInt(100);
		
		return array;
	}
	
	// best case O(nlogn) , worst case O(n^2)
	public static void quickSort(int[] array, int left, int right) {
		if(left >= right)
			return;
		
		int p = partition(array, left, right);
		
		quickSort(array, left, p - 1);
		quickSort(array, p + 1, right);
	}

	public static int partition(int[] array, int left, int right) {
		int pivot = array[right];
		int i = left;
		
		for(int j = left; j <= right; j++) {
			if(array[j] < pivot) { // if(array[j] > pivot) in order from largest to smallest
				swap(array, i, j);
				i++;
			}
		}
		swap(array, i, right);
		return i;
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
