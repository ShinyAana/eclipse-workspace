package extra;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveElement {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of an array");
		int length = sc.nextInt();
		int[] arr = new int[length];
		
		System.out.println("Enter the array elements");
		for(int i=0;i<length;i++)
		{
			arr[i]=sc.nextInt();
		}
		System.out.println("Enter remove element");
		int remove=sc.nextInt();
		if(arr[0]==remove)
			arr[0]=1;
		for(int i=1;i<length;i++)
		{
			if(arr[i]==remove)
			{
				
			for(int j=i;j>0;j--)
				{
				arr[j]=arr[j-1];
				}
				}
		}
		//Arrays.sort(arr);
		System.out.println("Rearranged array :" + Arrays.toString(arr));
	}

}
