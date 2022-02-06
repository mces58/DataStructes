import java.util.Random;

public class MergeSort {

	public static void main(String[] args) {
		int size = 10;
		int[] array = create(size);
		
		System.out.print("Unsorted\t: ");
		print(array);
		
		System.out.print("Merge sort\t: ");
		sort(array, 0, array.length - 1);
		print(array);
	}
	
	public static int[] create(int size) {
		int[] array = new int[size];
		Random random = new Random();
		
		for(int i = 0; i < array.length; i++)
			array[i] = random.nextInt(100);
		
		return array;
	}
	
	public static void sort(int[] array, int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			
			// sort first and second half
			sort(array, left, mid);
			sort(array, mid + 1, right);
			
			// merge sorted halves
			mergeSort(array, left, mid, right);
		}
	}
	
	// best case O(nlogn) , worst case O(nlogn)
	public static void mergeSort(int[] array, int left, int mid, int right) {
		// size calculations of two arrays to be merged
		int n1 = mid - left + 1;
		int n2 = right - mid;
		
		// define temporary arrays
		int[] Left = new int[n1];
		int[] Right = new int[n2];
		
		// copy data into temporary arrays
		for(int i = 0; i < n1; i++)
			Left[i] = array[left + i];
		for(int i = 0; i < n2; i++)
			Right[i] = array[mid + i + 1];
		
		int i = 0, j = 0;
		int k = left;
		
		// merge temporary arrays
		while(i < n1 && j < n2) {
			if(Left[i] <= Right[j]) { // if(Left[i] >= Right[j]) in order from largest to smallest
				array[k] = Left[i];
				i++;
			}
			else {
				array[k] = Right[j];
				j++;
			}
			k++;
		}
		
		// copy the remaining elements of the left array
		while(i < n1) {
			array[k] = Left[i];
			i++;
			k++;
		}
		
		// copy the remaining elements of the right array
		while(j < n2) {
			array[k] = Right[j];
			j++;
			k++;
		}
	}
	
	public static void print(int[] array) {
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
}
