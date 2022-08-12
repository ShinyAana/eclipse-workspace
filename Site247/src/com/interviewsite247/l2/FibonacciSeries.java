package com.interviewsite247.l2;

import java.util.Scanner;

public class FibonacciSeries {
	public static void main(String[] args) {
		FibonacciSeries object = new FibonacciSeries();
		object.startProcess();
	}

	private void startProcess()
	{
		Scanner input=new Scanner(System.in);
		boolean iscontinue=true;
		while(iscontinue)
		{
		System.out.println("Enter the number to generate fibonacci series");
		int n=input.nextInt();
		int a, b, c, count = 0;
		a = 1;
		b = 1;
        System.out.print(a +" " + b+  " ");
		for (int i = 3; i <= n; ++i) {
			c = a + b;
			System.out.print(c + " ");
			a = b;
			b = c;
		}
		System.out.println();
		System.out.println("Do you want to continue y/n");
		char ch=input.next().charAt(0);
		if(ch=='n')
			iscontinue=false;
		}
			
	
	}

}
