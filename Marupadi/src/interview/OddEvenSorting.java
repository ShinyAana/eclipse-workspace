package interview;

import java.util.Scanner;

public class OddEvenSorting {

	public static void main(String[] args)
	{
	Scanner input=new Scanner(System.in);
	System.out.println("Enter array size");
	int n=input.nextInt();
	int[] arr=new int[n];
	int[] odd=new int[100];
	int[] even=new int[100];
	int e=0,o=0;
	System.out.println("Enter array elements");
	for(int i=0;i<n;i++)
	{
		arr[i]=input.nextInt();
	}
	for(int i=0;i<n;i++)
	{
		if(i%2==0)
		{
			even[e++]=arr[i];
		}
		else
		{
			odd[o++]=arr[i];
		}
	}
	for(int i=0;i<e;i++)
	{
		for(int j=i+1;j<e;j++)
		{
			if(even[i]<even[j])
			{
				int temp=even[i];
				even[i]=even[j];
				even[j]=temp;
			}
		}
	}
	for(int i=0;i<o;i++)
	{
		for(int j=i+1;j<o;j++)
		{
			if(odd[i]>odd[j])
			{
				int temp=odd[i];
				odd[i]=odd[j];
				odd[j]=temp;
			}
		}
	}
	int i,j;
	for(i=0,j=0;i<e&&j<o;i++,j++)
		{
		System.out.print(even[i] + " " + odd[j] + " " );
		}
	while(j<o)
	{
		System.out.print(odd[j]);
		j++;
	}
	while(i<e)
	{
		System.out.print(even[i]);
		i++;
	}
	
	}

}
