package sortingAlgorithms;
import java.io.*;
import java.util.*;


public class InsertionSort {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the array size ");
		int n=in.nextInt();
		System.out.println("Enter array elements ");
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=in.nextInt();
		}
		for(int i=0;i<n;++i)
		{
			int j=i;
			while(j>0 && arr[j-1]>arr[j])
			{
				int temp=arr[j-1];
				arr[j-1]=arr[j];
				arr[j]=temp;
			
			j=j-1;
			}
		}
		for(int value:arr)
			System.out.print(value + " ");
	}

}
