import java.util.Random;

public class HeapSort {

	public static void main(String[] args) {
		int size = 10;
		int[] array = create(size);
		
		System.out.print("Unsorted\t: ");
		print(array);
		
		System.out.print("Heap sort\t: ");
		heapSort(array);
		print(array);
	}
	
	public static int[] create(int size) {
		int[] array = new int[size];
		Random random = new Random();
		
		for(int i = 0; i < array.length; i++)
			array[i] = random.nextInt(100);
		
		return array;
	}
	
	// best case O(nlogn) , worst case O(nlogn)
	public static void heapSort(int[] array) {
		int len = array.length;
		
		for(int i = (len / 2) - 1; i >= 0; i--)
			heapify(array, len, i);
		
		for(int i = len - 1; i > 0; i--) {
			swap(array, 0, i);
			heapify(array, i, 0);
		}
	}
	
	public static void heapify(int[] array, int len, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		if(left < len && array[left] > array[largest]) // if(left < len && array[left] < array[largest]) in order from largest to smallest
			largest = left;
		
		if(right < len && array[right] > array[largest]) // if(right < len && array[right] < array[largest]) in order from largest to smallest
			largest = right;
		
		if(largest != i) {
			swap(array, largest, i);
			heapify(array, len, largest);
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
