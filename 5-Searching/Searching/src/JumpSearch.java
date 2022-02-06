
public class JumpSearch {

	public static void main(String [ ] args) {
		int arr[] = {1,2,3,4,5};
		int data = 5;
	    int search = jumpSearch(arr, data);

		if(search == -1)
			System.out.println("The item does not exist in the array.");
		else
			System.out.println("The index number of the element: " + search);
	}
	public static int jumpSearch(int[] array, int data) {
		int n = array.length;
 
        int step = (int)Math.floor(Math.sqrt(n));
 

        int prev = 0;
        while (array[Math.min(step, n)-1] < data)
        {
            prev = step;
            step += (int)Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }
 

        while (array[prev] < data)
        {
            prev++;
            
            if (prev == Math.min(step, n))
                return -1;
        }

        if (array[prev] == data)
            return prev;
 
        return -1;
    }
}
