
public class TernarySearch {
	public static void main (String[] args) {
		
		int[] array = {1,2,3,4,5};
		int data = 5;
		int search = ternarySearch(array, 0, array.length - 1, data);

		if(search == -1)
			System.out.println("The item does not exist in the array.");
		else
			System.out.println("The index number of the element: " + search);
	}
	public static int ternarySearch(int array[], int left, int right, int data) {
		if (right >= left) {
			int mid1 = left + (right - left) / 3;
			int mid2 = mid1 + (right - left) / 3;
			
			if (array[mid1] == data) 
				return mid1;
			
			if (array[mid2] == data) 
				return mid2;
			
			if (array[mid1] > data)
			return ternarySearch(array, left, mid1 - 1, data);
			
			if (array[mid2] < data)
			return ternarySearch(array, mid2 + 1, right, data);
			
			return ternarySearch(array, mid1 + 1, mid2 - 1, data);
		}
		return -1;
	}
}
