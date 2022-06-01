package rebeccaSan;

import java.util.Scanner;

public class LargestPairSum {

	public static void main(String[] args) {
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
		int max=0;
		int temp=0;
		for(int i=0;i<length;i++)
		{
			for(int j=i+1;j<length;j++)
			{
			  temp=arr[i]+arr[j];
			  if(max<temp)
				  max=temp;
			}
		}
		System.out.println("The Maximum contiguous sum pair "+max);
			
		
		

	}

}
