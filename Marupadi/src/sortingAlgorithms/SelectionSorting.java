package sortingAlgorithms;
import java.io.*;
import java.util.*;
public class SelectionSorting {

	public static void main(String[] args) {
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
	      int temp=0,i,j;
	     for(i=0;i<n;i++)
	       {
	         for(j=i+1;j<n;j++)
	           {
	             if(arr[i]>arr[j])
	             {
	               temp=arr[i];
	               arr[i]=arr[j];
	               arr[j]=temp;
	               }
	           }
	         System.out.println(arr[0] + " is the smallest");
	         }
	     System.out.println("Array after sorting :");
	     for(int value:arr)
	    	 System.out.print(" " + value);
	      
	}

}
