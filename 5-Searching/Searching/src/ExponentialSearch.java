
public class ExponentialSearch {

	public static void main(String args[]) {
		int[] array = {1,2,3,4,5};
		int data = 5;
		int search = exponentialSearch(array, array.length, data);
		

		if(search == -1)
			System.out.println("The item does not exist in the array.");
		else
			System.out.println("The index number of the element: " + search);
	}
	static int exponentialSearch(int array[], int length, int data) {
		
		if (array[0] == data)
			return 0;
	
		int i = 1;
		while (i < length && array[i] <= data)
			i = i * 2;
	
		return BinarySearch.binarySearch(array, i / 2, Math.min(i, length - 1), data);
	}
}
