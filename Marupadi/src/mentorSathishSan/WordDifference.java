package mentorSathishSan;
import java.io.*;
import java.util.*;

public class WordDifference {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("Enter first string ");
		String str1=input.next().toLowerCase();
		String str2=input.next().toLowerCase();
		int n=str1.length();
		String result="";
		for(int i=0;i<n;i++)
		{
			if(!(str2.contains(""+str1.charAt(i))))
					{
				result =result + str1.charAt(i);
					}
		}

	}

}
