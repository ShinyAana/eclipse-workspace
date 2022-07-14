package interviewQA;

import java.util.Scanner;

public class CharPrint {

	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the string");
		String exp=input.next();
		String num="";
		char letter=' ';
		for(char ch:exp.toCharArray())
		{
			if(!(ch>='0' && ch<='9'))
			{
				if(num!="")
				{
					int n=Integer.parseInt(num);
					for(int i=0;i<n;i++)
					{
						System.out.print(letter);
					}
				}
				letter=ch;
				num="";
			}
			else
			{
				num+=ch;
			}
		}
		int n=Integer.parseInt(num);
		for(int i=0;i<n;i++)
		{
			System.out.print(letter);
		}
		

	}
}


