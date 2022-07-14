package mockInterview;

import java.util.ArrayList;
import java.util.Arrays;

public class Check {

	public static void main(String[] args)
	{
		
		ArrayList<Integer> operands=new ArrayList<>(Arrays.asList(4,1,5,3));
		System.out.println(operands);
		ArrayList
		String checkExp="4+3-5-1";
		for(int i=0;i<checkExp.length();i+=2)
		{
			if(operands.contains(checkExp.charAt(i)))
					{
				operands.remove(checkExp.charAt(i));
					}
			else
			{
				System.out.println("Build a valid Expression");
			}
		}
		if(!operands.isEmpty())
		{
	System.out.println("Don't use operands twice");
		}
		else
		{
			System.out.println("Valid");
		}
		
	}

}
