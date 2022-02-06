import java.util.Random;

public class GnomeSort {

	public static void main(String[] args) {
		int size = 10;
		int[] array = create(size);
		
		System.out.print("Unsorted\t: ");
		print(array);
		
		System.out.print("Gnome sort\t: ");
		gnomeSort(array);
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
	public static void gnomeSort(int[] array) {
		int index = 0;
		
		while(index < array.length) {
			if(index == 0)
				index++;
			if(array[index] >= array[index - 1]) // if(array[index] <=  array[index - 1]) in order from largest to smallest
				index++;
			else {
				swap(array, index, index - 1);
				index--;
			}		
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
