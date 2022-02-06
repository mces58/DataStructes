import java.util.Random;

public class ShellSort {

	public static void main(String[] args) {
		int size = 10;
		int[] array = create(size);
		
		System.out.print("Unsorted\t: ");
		print(array);
		
		System.out.print("Shell sort\t: ");
		shellSort(array);
		print(array);
	}
	
	public static int[] create(int size) {
		int[] array = new int[size];
		Random random = new Random();
		
		for(int i = 0; i < array.length; i++)
			array[i] = random.nextInt(100);
		
		return array;
	}
	
	// best case O(nlogn) , worst case O(n^2)
	public static void shellSort(int[] array) {
		for(int i = array.length / 2; i > 0; i /= 2) {
			for(int j = i; j < array.length; j++) {
				int temp = array[j];
				int k;
				
				for(k = j; k >= i && array[k - i] > temp; k -= i) // for(k = j; k >= i && array[k - i] < temp; k -= i) in order from largest to smallest
					array[k] = array[k - i];
				
				array[k] = temp;
			}
		}
	}
	
	public static void print(int[] array) {
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
}
