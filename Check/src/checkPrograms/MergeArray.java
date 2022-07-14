package checkPrograms;

import java.util.Scanner;

public class MergeArray {

	public static void main(String[] args)
	{
	Scanner input=new Scanner(System.in);
	System.out.println("Enter the size of first array");
	int n=input.nextInt();
	int[] arr1=new int[n];
	for(int i=0;i<n;i++)
	{
		arr1[i]=input.nextInt();
	}
	System.out.println("Enter the size of second array");
	int m=input.nextInt();
	int[] arr2=new int[m];
	int[] result=new int[n+m];
	
	for(int j=0;j<m;j++)
	{
		arr2[j]=input.nextInt();
	}
	System.out.println("The merged array is ");
	int p=0,q=0,k=0;
	while(p<n && q<m)
	{
		if(arr1[p]<arr2[q])
		{
			result[k++]=arr1[p];
			p++;
		}
		else
		{
			result[k++]=arr2[q];
			q++;
		}
	}
	while(p<n)
	{
		result[k++]=arr1[p];
		p++;
	}
	while(q<m)
	{
		result[k++]=arr2[q];
		q++;
	}
	for(int temp=0;temp<k;temp++)
	{
		System.out.print(result[temp] + " ");
	}
	
	}

}

