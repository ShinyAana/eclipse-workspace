package com.interviewsite247.l2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PrintDistinctNums {

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter array  size");
		int n = input.nextInt();

		int[] arr = new int[n];
		System.out.println("Enter array  value");
		for (int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
		}
		int[] freq=new int[arr.length];
		int count=0,visited=-1,k=0;
		
		for(int i=0;i<n;i++)
		{
			count=1;
			for(int j=i+1;j<n;j++)
			{
				if(arr[i]==arr[j])
				{
					count++;
					freq[j]=visited;
				}
			}
			if(freq[i]!=visited)
			{
				freq[i]=count;
				//k++;
			}
		}
		System.out.println(Arrays.toString(freq));

		System.out.println(Arrays.toString(arr));

		
		boolean isdistinct=false;
		  for(int i=0;i<n;i++)
		  {
			  if(freq[i]==1)
			  {
				  isdistinct=true;
				  System.out.print(arr[i] + " ");
				    
			  }
			  
			}
		  if(isdistinct==false)
			  System.out.println("{}");
			  
			
		  
		  
		 	}
		

	}

		