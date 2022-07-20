package mentorSathishSan;

import java.util.Scanner;

public class IntToRoman {

	public static void main(String[] args)
	{
	Scanner in=new Scanner(System.in);
	System.out.println("Enter Integer value");
	int num=in.nextInt();
	int[] values= {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	String[] roman= {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	StringBuilder result=new StringBuilder();
	for(int i=0;i<values.length;i++)
	{
		while(num>=values[i])
		{
			num=num-values[i];
			result.append(roman[i]);
			
		}
	}
	System.out.println(result.toString());
	}

}
