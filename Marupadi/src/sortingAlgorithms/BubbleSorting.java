package sortingAlgorithms;
import java.io.*;
import java.util.*;
public class BubbleSorting {

	public static void main(String[] args) 
	{
	      Scanner in=new Scanner(System.in);
	      System.out.println("Enter array  size");
	      int n=in.nextInt();
	      int[] arr=new int[n];
	      System.out.println("Enter array  value");
	      for(int i=0;i<n;i++)
	        {
	          arr[i]=in.nextInt();
	        }
	      //System.out.println("largest value in an array ");
	     int j=1;
	      while(j<n)
	     {
	    	 int i=0;
	    	 while(i<n-j)
	    	 {
	    		 if(arr[i]>arr[i+1])
	    		 {
	    			 int temp=arr[i];
	    			 arr[i]=arr[i+1];
	    			 arr[i+1]=temp;
	    		 }
	    		 i++;
	    	 }
	    	 j++;
	     }
	      //System.out.println("Second largest "+ arr[n-2]);
	      System.out.println("Array after sorting :");
		     for(int value:arr)
		    	 System.out.print(" " + value);
		    
	}

}
