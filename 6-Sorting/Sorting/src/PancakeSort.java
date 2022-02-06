import java.util.Random;

public class PancakeSort {

	public static void main(String[] args) {
		int size = 10;
		int[] array = create(size);
		
		System.out.print("Unsorted\t: ");
		print(array);
		
		System.out.print("Pancake sort\t: ");
		pancakeSort(array);
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
	public static void pancakeSort(int[] array) {
		for(int i = array.length; i > 1; i--) {
			int max = getMax(array, i);
			
			if(max != i - 1) {
				flip(array, max + 1);
				flip(array, i);
			}
		}
	}

	public static int getMax(int[] array, int length) {
		int max = 0;
		
		for(int i = 1; i < length; i++) {
			if(array[i] > array[max]) // if(array[max] > array[i]) in order from largest to smallest
				max = i;
		}
		return max;
	}

	public static void flip(int[] array, int length) {
		for(int i = 0; i < length / 2; i++)
			swap(array, i, length - i - 1);
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
