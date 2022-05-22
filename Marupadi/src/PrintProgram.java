import java.io.*;
import java.util.*;
public class PrintProgram {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the odd length string");
		String str=in.nextLine();
		int i,j;
		int n=str.length();
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				if(i==j || (i+j)==(n-1))
				 System.out.print(str.charAt(i));
				else
				System.out.print(" ");
			}
			System.out.println();
		}
		

	}

}
