package mentorSathishSan;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductExceptItself {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of an array");
		int length = sc.nextInt();
		int[] arr = new int[length];
		//int[] result=new int[length*length];
		ArrayList<Integer> result=new ArrayList<>();
		System.out.println("Enter the array elements");
		for(int i=0;i<length;i++)
		{
			arr[i]=sc.nextInt();
		}
		int temp=0,total=1;
		for(int i=0;i<length;i++)
		{
			for(int j=i+1;j<length;j++)
			{
				temp=arr[i]*arr[j];
				if(temp!=arr[i] && temp!=arr[j])
					result.add(temp);
					
			}
			total*=arr[i];
		}
		result.add(total);
		System.out.println(result);
	}

}
