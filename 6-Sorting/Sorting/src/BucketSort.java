import java.util.Random;

public class BucketSort {

	public static void main(String[] args) {
		int size = 10;
		int[] array = create(size);
		
		System.out.print("Unsorted\t: ");
		print(array);
		
		System.out.print("Bucket sort\t: ");
		bucketSort(array);
		print(array);
	}
	
	public static int[] create(int size) {
		int[] array = new int[size];
		Random random = new Random();
		
		for(int i = 0; i < array.length; i++)
			array[i] = random.nextInt(100);
		
		return array;
	}
	
	// best case O(n) , worst case O(n)
	public static void bucketSort(int[] array) {
		int max = getMax(array);
		int[] bucket = new int[max + 1];
		
		for(int i = 0; i < array.length; i++)
			bucket[array[i]]++;
		
		int index = 0;
		
		for(int i = 0; i < bucket.length; i++) {
			for(int j = 0; j < bucket[i]; j++)
				array[index++] = i;
		}
	}
	
	public static int getMax(int[] array) {
		int max = 0;
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max)
				max = array[i];
		}
		return max;
	}
	
	public static void print(int[] array) {
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
}
