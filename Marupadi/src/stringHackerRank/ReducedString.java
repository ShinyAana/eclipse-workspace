package stringHackerRank;

import java.util.Scanner;

public class ReducedString 
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner input=new Scanner(System.in);
		//String s=input.next();
		StringBuilder sb=new StringBuilder("aaabc");
		boolean flag=true;
		while(true)
		{
			flag=false;
		for(int i=0;i<sb.length()-1;i++)
		{
			if(sb.charAt(i)==sb.charAt(i+1));
			{
				sb.delete(i, i+2);
				flag=true;
			}
		}
		}
	}

	}
