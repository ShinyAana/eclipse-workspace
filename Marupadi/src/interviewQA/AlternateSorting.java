package interviewQA;

import java.util.Scanner;

public class AlternateSorting {

	public static void main(String[] args)
	{
		AlternateSorting obj=new AlternateSorting();
		obj.sorting();
	}

	private void sorting() 
	{
	Scanner input=new Scanner(System.in);
	int[] arr= {1,2,3,4,5,6,7};
	int n=arr.length;
	int[] temp=new int[n];
	boolean flag=true;
	int small=0,large=n-1;
	for(int i=0;i<n;i++)
	{
		if(flag)
		{
			temp[i]=arr[large--];
		}
		else
		{
			temp[i]=arr[small++];
		}
		flag=!flag;
	}
	System.out.println("Array after alternate sorting ");
	for(int i:temp)
	{
	System.out.print(i + " ");
	}

}
}
