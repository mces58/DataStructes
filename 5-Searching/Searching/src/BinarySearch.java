
public class BinarySearch {

	public static void main(String[] args) {
		
		int[] array = {1,2,3,4,5};
		int data = 5;
		int search = binarySearch(array, 0, array.length - 1, data);

		if(search == -1)
			System.out.println("The item does not exist in the array.");
		else
			System.out.println("The index number of the element: " + search);
			
	}
    public static int binarySearch(int arr[], int left, int right, int data) {
    	if (right >= left) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == data)
                return mid;

            if (arr[mid] > data)
                return binarySearch(arr, left, mid - 1, data);

            return binarySearch(arr, mid + 1, right, data);
        }
        return -1;
    }
}
