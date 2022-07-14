package interview;

import java.util.Arrays;
import java.util.Scanner;

public class ReArrangeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("Enter array size");
		int n=input.nextInt();
		int[] arr=new int[n];
		int[] result=new int[n];
		System.out.println("Enter array elements");
		for(int i=0;i<n;i++)
		{
			arr[i]=input.nextInt();
		}
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]==arr[i+1])
			{
				arr[i]=arr[i]*2;
				arr[i+1]=0;
			}
			else
				continue;
		}
		System.out.println(Arrays.toString(arr));
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==0)
				continue;
			for(int j=i;j>0;j--)
			{
				if(arr[j-1]==0)
				{
				int temp=arr[j];
				arr[j]=arr[j-1];
				arr[j-1]=temp;
				}
				else
					break;

			}
		}
		System.out.println(Arrays.toString(arr));
		

	}

}
