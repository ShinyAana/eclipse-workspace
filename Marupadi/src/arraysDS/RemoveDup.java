package arraysDS;

/*public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        // Counter for keeping track of elements other than val
        int count = 0;
        // Loop through all the elements of the array
        for (int i = 0; i < nums.length; i++) {
            // If the element is not val
            if (nums[i] != val) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
*/
import java.util.Arrays;

public class RemoveDup {

	public static void main(String[] args)
	{
		int[] arr= {2,2,3,4,5,5,7};
		//Arrays.sort(arr);     
	      
        int[] result = new int[arr.length];
        int previous = arr[0];
        result[0] = previous;

        for (int i = 1; i < arr.length; i++) {
            int ch = arr[i];

            if (previous != ch) {
                result[i] = ch;
            }
            
            previous = ch;
        }
        System.out.println(Arrays.toString(result));
    }
}
