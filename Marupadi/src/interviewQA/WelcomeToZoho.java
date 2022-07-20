package interviewQA;

import java.util.Scanner;

public class WelcomeToZoho {

	public static void main(String[] args)
	{
	Scanner in=new Scanner(System.in);
	System.out.println("Enter the String input ");
	String str=in.next();
	char[] ch=str.toCharArray();
	System.out.println("Enter thr string to search");
	String findIndex=in.next();
	int chLen=findIndex.length();
	char[] chFind=findIndex.toCharArray();
	int len=str.length();
	int d=1;
	while(d*d<len)
		d++;
	char[][] word=new char[d][d];
	int k=0;
	for(int i=0;i<d;i++)
	{
		for(int j=0;j<d;j++)
		{
			if(k<len)
			{
			word[i][j]=ch[k++];
			}
			else
			{
				word[i][j]=' ';
			}
			System.out.print(word[i][j] + " ");
		}
		System.out.println();
	}
	boolean isFound=true;
	int count=0;
	for(int i=0;i<d;i++)
	{
	k=0;
		for(int j=0;j<d;j++)
		{
			if(word[i][j]== chFind[k])
			{
				k=1;isFound=true;count=0;
				while(k<chLen && j<d)
				{
					count++;
					if(chFind[k]!=word[i][++j])
					{
						isFound=false;
						break;
					} 
					k++;
				}
				if(isFound)
				{
					System.out.print((i + " " + (j-count)) + " "+ (i + " " + j ));
					System.out.println();
				}
				
			}
			
		}
	}
	//isFound=true;
	count=0;
	int k1=0;
	try
	{
	for(int i=0;i<d;i++)
	{
	k1=0;
		for(int j=0;j<d;j++)
		{
			if(word[i][j]== chFind[k1])
			{
				k1=1;isFound=true;count=0;
				while(k1<chLen && i<d)
				{
					count++;
					if(chFind[k1]!=word[++i][j])
					{
						isFound=false;
						break;
					} 
					k1++;
				}
				if(isFound)
				{
					System.out.print(((i-count) + " " + j) + " "+ (i + " " + j ));
					System.out.println();
				}
				
			}
			
		}
	}
	}
	catch(Exception e)
	{
		System.out.println();
		System.out.println("Exceed matrix length ");
	}
	}
}