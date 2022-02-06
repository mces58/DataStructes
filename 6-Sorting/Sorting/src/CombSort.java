import java.util.Random;

public class CombSort {

	public static void main(String[] args) {
		int size = 10;
		int[] array = create(size);
		
		System.out.print("Unsorted\t: ");
		print(array);
		
		System.out.print("Comb sort\t: ");
		combSort(array);
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
	public static void combSort(int[] array) {
		int len = array.length;
		boolean swapped = true;
		
		while(len != 1 || swapped == true) {
			len = getNextGap(len);
			swapped = false;
			
			for(int i = 0; i < array.length - len; i++) {
				if(array[i] > array[i + len]) { // if(array[i] < array[i + len]) in order from largest to smallest
					swap(array,i,i + len);
					swapped = true;
				}
			}
		}
	}
	
	public static int getNextGap(int len) {
		len = (len * 10) / 13;
		if(len < 1)
			return 1;
		return len;
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
