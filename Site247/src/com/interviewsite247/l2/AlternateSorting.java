package com.interviewsite247.l2;

import java.util.Arrays;
import java.util.Scanner;

public class AlternateSorting {
	public static void main(String[] args) {
		AlternateSorting object = new AlternateSorting();
		object.startProcess();
	}

	private void startProcess()
	{
		Scanner input=new Scanner(System.in);
		boolean iscontinue=true;
		while(iscontinue)
		{
		
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
		System.out.println("Elements in even position" + Arrays.toString(even));
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
		System.out.println("Elements in even position" + Arrays.toString(odd));
		
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
		System.out.println();
		System.out.println("Do you want to continue y/n");
		char ch=input.next().charAt(0);
		if(ch=='n')
			iscontinue=false;
		}
		
		}




}
