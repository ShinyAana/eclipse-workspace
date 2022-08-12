package com.interviewsite247.l2;

import java.util.Scanner;

public class CharDelete {

	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter input String");
		String str=input.nextLine();
		//String str1=str.replace(" , 0)
		System.out.println("Enter character to remove");
		char ch=input.next().charAt(0);
		char upper=Character.toUpperCase(ch);
		String result="";
		//StringBuilder sb=new StringBuilder(str);
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)==ch||str.charAt(i)==upper)
			{
				continue;
			}
			else 
				result+=str.charAt(i);
		}
		
		System.out.println(result);
		
	}

}
