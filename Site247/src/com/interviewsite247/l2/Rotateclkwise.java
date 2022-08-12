package com.interviewsite247.l2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Rotateclkwise {

	public static void main(String[] args)
	{
	Scanner input=new Scanner(System.in);
	
	System.out.println("Enter n value");
	int n=input.nextInt();
	int[][] mat=new int[n][n];
	
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			mat[i][j]=input.nextInt();
		}
	}
	int[][] result=new int[n][n];
	int rowlow=0;
	int rowup=mat.length;
	int collow=0;
	int colup=mat[0].length;
	ArrayList<Integer> al =new ArrayList<>();
	while(rowlow<=rowup && collow<=colup)
	{
		for(int i=collow;i<colup;i++)
		{
			result[rowlow][i]=mat[rowlow][i];
		}
		rowlow++;
		for(int i=rowlow;i<rowup;i++)
		{
			result[i][colup]=mat[i][colup];
		}
		colup--;
		for(int i=colup;i>0;i--)
		{
			result[i][colup]=mat[rowup][i];
		}
		rowup--;
		for(int i=rowup;i>0;i--)
		{
			result[i][collow]=mat[i][collow];
		}
		collow++;
		
	}
	System.out.println(Arrays.toString(result));
	
	
	}
	}

