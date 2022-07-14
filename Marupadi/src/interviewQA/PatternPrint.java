package interviewQA;

import java.util.Scanner;

public class PatternPrint {

	public static void main(String[] args)
	{
	Scanner in=new Scanner(System.in);
	System.out.println("Enter the odd length string");
	String str=in.nextLine();
	int i,j;
	int len=str.length();
	
	for(i=0;i<len;i++)
	{
		int k=len-i-1;
		for(j=0;j<len;j++)
		{
			if(j==i || j==k)
			{
				System.out.print(str.charAt(j));
			}
			else
			{
				System.out.print(" ");
			}
			 
		}
		System.out.println();
	}
	}

}
