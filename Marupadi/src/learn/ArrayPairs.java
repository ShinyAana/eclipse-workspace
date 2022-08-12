package learn;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("Enter array size");
		int n=input.nextInt();
		int[] arr=new int[n];
		System.out.println("Enter array values");
		for(int i=0;i<n;i++)
		{
			arr[i]=input.nextInt();
		}
		System.out.println();
		for(int i=0;i<n-1;i+=2)
		{
			if(i+1<n)
			{
				if(arr[i]>arr[i+1])
				{
					int temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		for(int i=0;i<n-1;i+=2)
			
		{
			System.out.print("(" + arr[i] + ", " + arr[i+1] + ")");
		}
		System.out.println();

	}

}
