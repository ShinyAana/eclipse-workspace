package interview;
import java.util.*;
public class SecondHighFreq
{
    public static String stringWithSecondHighestFrequency(String[] A)
    {
        int n = A.length;
        HashMap<String,Integer> hash_table = new HashMap<String,Integer>();
        // Store the frequency of strings in a hash table
        for (int i = 0; i < n; i++)
        {
            Integer j = hash_table.get(A[i]); 
            hash_table.put(A[i], (j == null) ? 1 : j + 1); 
        }
        // Find the second highest frequency
        int max_freq = 0;
        int second_highest_freq = 0;
        for (Map.Entry<String,Integer> entry : hash_table.entrySet())  
        {
            max_freq = Math.max(max_freq, entry.getValue());
            if (second_highest_freq < entry.getValue() && entry.getValue() < max_freq)
            {
                second_highest_freq = entry.getValue();
                return entry.getKey();
            }
        }
        // Find the string with second_highest_freq
		/*
		 * for (Map.Entry<String,Integer> entry : hash_table.entrySet()) { if
		 * (entry.getValue() == second_highest_freq) { return entry.getKey(); } }
		 */ 
        return "";  
    }
  public static void main(String[] args) {
      String[] A = {"aaa", "bb", "bb", "aaa", "aaa", "c"};
    System.out.println("String with second highest frequency is: "+stringWithSecondHighestFrequency(A));
    Arrays.sort(A);
    System.out.println(Arrays.toString(A));
  }
}

