package extra;
//package com.BalaSan;

import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PrimeNumbers().printPrimeNum();
	}

	private void printPrimeNum() {
		// TODO Auto-generated method stub     
		int num = 2;
		int flag = 0;
		do
		{
			flag = 0;
			int mid = num/2;
			for(int i=2;i<=mid;i++)
			{
				if(num%i == 0)
				{
					flag = 1;
					break; 
				}
			}
			if(num == 10)System.out.println();
			if(num == 100)System.out.println();
			if(num == 1000)System.out.println();
			
			if(flag == 0) 
			{
				System.out.print(num+" "); 
			}
			num++;
		}while(num < 10000);
	}

}
