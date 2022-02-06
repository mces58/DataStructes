import java.util.Random;

public class BubbleSort {
	
	public static void main(String[] args) {
		int size = 10;
		int[] array = create(size);
		
		System.out.print("Unsorted\t: ");
		print(array);
		
		System.out.print("Bubble sort\t: ");
		bubbleSort(array);
		print(array);
	}
	
	public static int[] create(int size) {
		Random random = new Random();
		int[] array = new int[size];
		
		for(int i = 0; i < array.length; i++)
			array[i] = random.nextInt(100);
		
		return array;
	}

	// best case O(n) , worst case O(n^2)
	public static void bubbleSort(int[] array) {
		boolean flag = false;
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length - i - 1; j++) {
				if(array[j] > array[j + 1]) { // if(array[j] < array[j + 1]) in order from largest to smallest
					swap(array, j, j + 1);
					flag = true;
				}
			}
			if(!flag)
				break;
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
