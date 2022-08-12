package com.interviewsite247.l2;

import java.util.ArrayList;
import java.util.Scanner;

public class LongestSubArray {

	public static void main(String[] args) 
	{
	Scanner input=new Scanner(System.in);
	System.out.println("Enter array  size");
	int n = input.nextInt();

	int[] arr = new int[n];
	System.out.println("Enter array  value");
	for (int i = 0; i < n; i++) {
		arr[i] = input.nextInt();
	}
	ArrayList<ArrayList<Integer>> al=new ArrayList<>();
	for(int i=0;i<n;i++)
	{
		for(int j=i+1;j<n;j++)
		{
			
		}
	}

	}

}
