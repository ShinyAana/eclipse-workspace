package learn;
import java.util.Scanner ;    
public class SubarraySum {
    /* If our function subarray seems to be successful in finding any subarray whose sum of elements matches with the given sum value, then we will print the resulting Subarray, else we will return -1./  
    static int subarray(int arr[] , int n , int sum )  
    {  
        int currentsum, i , j ;  
        // start array with the initial index try all subarrays starting with  ' i '  
  
        for ( i = 0 ; i < n ; i++ ) {  
            currentsum = arr[ i ] ;  
            for (j = i + 1 ; j <= n ; j++) {  
                if (currentsum == sum) {  
                    int p = j - 1 ;  
                    System.out.println(  
                        " Sum found between indexes  " + i  
                        + " and " + p) ;  
                    return 1 ;  
                }  
                if (currentsum > sum || j == n)  
                    break ;  
                currentsum = currentsum + arr[j] ;  
            }  
        }  
  
        System.out.println(" No subarray found " ) ;  
        return 0 ;  
    }  
  
    public static void main( String[] args )  
    {  
        int n ;  
 Scanner sc = new Scanner ( System.in ) ;   
 System.out.println ( " Enter number of elements :  " ) ;  
 n = sc.nextInt() ;  
 int [] array = new int[ 100 ] ;  
 System.out.println ( " Enter elements of the array :  " ) ;  
 for ( int i = 0 ; i < n ; i++ )  
 {  
     array[ i ] = sc.nextInt() ;  
 }  
 System.out.println( " Enter value of sum : " ) ;  
 int sum = sc.nextInt() ;  
 subarray( array , n , sum ) ;  
    }  
}  



