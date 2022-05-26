package extra;
import java.io.*;
import java.util.*;

public class printPatternZ {

	public static void main(String[] args) 
	{
	Scanner in=new Scanner(System.in);
	System.out.println("Enter the word to print in Z format ");
	String str=in.nextLine();
	char[] strChar=str.toCharArray();
	int n=str.length();
	if(n%3==1)
	{
		for(int r=0;r<=n/3;r++)
		{
			for(int c=0;c<=n/3;c++)
			{
				if(r==0||r==n/3||(r+c)==n/3)
				{
					System.out.print(strChar[r+r+c] + " ");
				}
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}
	else
		System.out.println("Can't form Z pattern ");
	
	
	
	}

}
