package arraysDS;

/*search for integer K.
If any array element is found to be equal to K, then print index of K.
Otherwise, if any array element is found to be greater than K, print that index as 
the insert position of K. If no element is found to be exceeding K, K must be inserted after the last array element.
*/		import java.io.*;
		 
		class FindElement{
		 
		// Function to find insert position of K
		static int find_index(int[] arr, int n, int K)
		{
		     
		    // Lower and upper bounds
		    int start = 0;
		    int end = n - 1;
		 
		    // Traverse the search space
		    while (start <= end)
		    {
		        int mid = (start + end) / 2;
		 
		        // If K is found
		        if (arr[mid] == K)
		            return mid;
		 
		        else if (arr[mid] < K)
		            start = mid + 1;
		 
		        else
		            end = mid - 1;
		    }
		 
		    // Return insert position
		    return end + 1;
		}
		 
		// Driver Code
		public static void main(String[] args)
		{
		    int[] arr = { 1, 3, 5, 6 };
		    int n = arr.length;
		    int K = 4;
		     
		    System.out.println(find_index(arr, n, K));
		}
		}
		 
	
		/*
		 * // Java program for the above approach import java.io.*;
		 * 
		 * class GFG{
		 * 
		 * // Function to find insert position of K static int find_index(int[] arr, int
		 * n, int K) {
		 * 
		 * // Traverse the array for(int i = 0; i < n; i++)
		 * 
		 * // If K is found if (arr[i] == K) return i;
		 * 
		 * // If current array element // exceeds K else if (arr[i] > K) return i;
		 * 
		 * // If all elements are smaller // than K return n; }
		 * 
		 * // Driver Code public static void main(String[] args) { int[] arr = { 1, 3,
		 * 5, 6 }; int n = arr.length; int K = 2;
		 * 
		 * System.out.println(find_index(arr, n, K)); } }
		 */