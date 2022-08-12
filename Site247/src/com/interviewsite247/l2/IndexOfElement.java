package com.interviewsite247.l2;

import java.util.Scanner;

public class IndexOfElement {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		boolean iscontinue=true;
		while(iscontinue)
		{
		
		System.out.println("Enter array  size");
		int n = input.nextInt();
		int[] array = new int[n];
		
		System.out.println("Enter array  value");
		for (int i = 0; i < n; i++) {
			array[i] = input.nextInt();
		}
		System.out.println("Enter the element to print index");
		int search=input.nextInt();
		boolean isFound=false;
		for(int i=0;i<n;i++)
		{
			if(array[i]==search)
			{
				System.out.println(i);
				isFound=true;
			}
			else
				continue;
		}
		if(isFound==false)
			System.out.println("-1");
		System.out.println();
		System.out.println("Do you want to continue y/n");
		char ch=input.next().charAt(0);
		if(ch=='n')
			iscontinue=false;
		}
		

	}

}
