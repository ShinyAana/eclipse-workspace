package rebeccaSan;

import java.util.Arrays;
import java.util.Scanner;

public class FindNextBigger {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of an array");
		int length = sc.nextInt();
		int[] arr = new int[length];
		
		System.out.println("Enter the array elements");
		for(int i=0;i<length;i++)
		{
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		for(int i=0;i<length;i++)
		{
			for(int j=i+1;j<length;j++)
			{
				if(arr[i]<arr[j])
				{
					System.out.print(arr[i]+ " -> " + arr[j] + " ");
					break;
				}
				
			}
		}
		/*
		 * int next = 0; for(int i=0;i<length;i++) { for(int j=i+1;j<length;j++) {
		 * if(arr[i]<arr[j]) { next=arr[j]; break; }
		 * 
		 * } System.out.print(arr[i]+ " -> " + next + "  "); next=-1;
		 * 
		 * }
		 */	
	}

}
