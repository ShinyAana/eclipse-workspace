package learn;

import java.util.Scanner;

public class RemoveDupStr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String to remove duplicates");
		String input =sc.next();
		StringBuilder sb = new StringBuilder(input);
		int length=sb.length();
		for(int i=0; i<length;i++)
		{
			for (int j=i+1; j<length;j++)
			{
				char char1 =sb.charAt(i);
				char char2 =sb.charAt(j);
				if(char1==char2)
				{
				 sb.deleteCharAt(j);
				 i=0; j=0;
				 length=length-1;
				}
			}
		}
	System.out.println(sb);
	}
}
