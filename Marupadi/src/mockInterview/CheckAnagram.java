package mockInterview;

import java.util.Scanner;

public class CheckAnagram {

	public static void main(String[] args)
	{
		CheckAnagram object=new CheckAnagram();
		object.checkAnagramOrNot();
	}

	private void checkAnagramOrNot()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter string 1");
		String str1=input.next();
		System.out.println("Enter string 2");
		String str2=input.next();
		str1=str1.toLowerCase();
		str2=str2.toLowerCase();
	boolean isAnagram=testStrings(str1,str2);
	if(isAnagram==true)
	{
		System.out.println("The strings are anagram");
		
	}
	else
	{
		System.out.println("The Strings are not anagrams");
	}
	}

	private boolean testStrings(String str1, String str2) 
	{
	int[] alphaArray=new int[26];
	if(str1.length()!=str2.length())
	{
		return false;
	}
	else
	{
		for(int i=0;i<str1.length();i++)
		{
			alphaArray[str1.charAt(i)-'a']++;
		}
		for(int i=0;i<str2.length();i++)
		{
			alphaArray[str2.charAt(i)-'a']--;
		}
		int total=0;
		for(int value:alphaArray)
		{
			total+=Math.abs(value);
		}
		//System.out.println(total);
		if(total==0)
			return true;
		else
			return false;
	}
	
	}

}
