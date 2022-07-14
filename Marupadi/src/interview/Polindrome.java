package interview;

import java.util.Scanner;

public class Polindrome {

	public static void main(String[] args)
	{
	Scanner input=new Scanner(System.in);
	System.out.println("Enter the number");
	int num=input.nextInt();
	int original=num;
	int temp=0,check=0;
	while(num>0)
	{
		temp=num%10;
		check=(check*10)+temp;
		num=num/10;
	}
	if(check==original)
	{
		System.out.println("Given number is polindrome");
	}
	else
	{
		System.out.println("Not a Polindrome");
	}
	
	}

}
