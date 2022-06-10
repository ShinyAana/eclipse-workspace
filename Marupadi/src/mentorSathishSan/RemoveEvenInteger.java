package mentorSathishSan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RemoveEvenInteger {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of an array");
		int length = sc.nextInt();
		int[] arr = new int[length];
		int[] result=new int[length/2];
		System.out.println("Enter the array elements");
		for(int i=0;i<length;i++)
		{
			arr[i]=sc.nextInt();
		}
		int temp=0;
		for(int i=0;i<length;i++)
		{
			if(arr[i]%2!=0)
			{
				result[temp]=arr[i];
				temp++;
			}
		}
		System.out.println("After removing even numbers "+ Arrays.toString(result));
	}

}
