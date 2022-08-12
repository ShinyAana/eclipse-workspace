package com.interviewsite247.l2;

import java.util.Scanner;

public class Polindrome {

	public static void main(String[] args) 
	{
	Scanner input=new Scanner(System.in);
	System.out.println("Enter input String");
	String stringInput=input.nextLine();
	String trimedString=stringInput.replace(" ", "").toLowerCase();
	//System.out.println(trimedString);
	boolean isPolindrome=checkPolindrome(trimedString);
	System.out.println(isPolindrome);
	
	}

	private static boolean checkPolindrome(String trimedString)
	{
	boolean checkpolin=true;
	char[] stringArray=trimedString.toCharArray();
    int stringSize=stringArray.length-1;
    if(stringSize<=2)
    	return false;
    else
    {
    for(int i=0,j=stringSize;i<stringSize/2;i++,j--)
    {
    	if(stringArray[i]!=stringArray[j])
    	{
    		checkpolin=false;
    		break;
    	}
    }
    }
    if(checkpolin)
    	return true;
    else
		return false;
	}

}
