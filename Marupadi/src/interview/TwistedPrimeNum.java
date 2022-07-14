package interview;

import java.util.Scanner;

public class TwistedPrimeNum {

	public static void main(String[] args)
	{
		TwistedPrimeNum obj=new TwistedPrimeNum();
		obj.checkTwistedPrime();
	}

	private void checkTwistedPrime()
	{
	Scanner input=new Scanner(System.in);
	System.out.println("Enter The Number");
	int num=input.nextInt();
	int reverse=reverseNum(num);
	
	boolean checkNum=isPrime(num);
	boolean checkRev=isPrime(reverse);
	if(checkNum==true && checkRev==true)
	{
		System.out.println("The number is twisted prime");
	}
	else
	{
		System.out.println("The number is not twisted prime");
	}
	}

	private boolean isPrime(int num)
	{
		int count=0;
		for(int i=2;i<=num;i++)
		{
			count=0;
			for(int j=1;j<=i;j++)
			{
				if(i%j==0)
				{
				count++;
				}
			
			}
		}
			if(count==2)
			{
					return true;
		     }
			else
			{
			
		return false;
			}
	}


	private int reverseNum(int num)
	{
		int temp=0,check=0;
		while(num>0)
		{
			temp=num%10;
			check=(check*10)+temp;
			num=num/10;
		}
		return check;
	}

}
