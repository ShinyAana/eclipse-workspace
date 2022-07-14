package com.library.mngt;

import java.util.Scanner;

public class ApplicationStart
{

	public static void main(String[] args)
	{
		ApplicationStart startObj=new ApplicationStart();
		startObj.startProcess();
	}

	private void startProcess() 
	{
		boolean isExit=false;
		while(isExit)
		{
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
            System.out.println("Press 1 to Add new Book.");
            System.out.println(
                "Press 2 to Upgrade Quantity of a Book.");
            System.out.println("Press 3 to Search a Book.");
            System.out.println("Press 4 to Show All Books.");
            System.out.println("Press 5 to Register Student.");
            System.out.println(
                "Press 6 to Show All Registered Students.");
            System.out.println("Press 7 to Check Out Book. ");
            System.out.println("Press 8 to Check In Book");
            System.out.println("Press 0 to Exit Application.");
            
            System.out.println(
                "-------------------------------------------------------------------------------------------------------");
	Scanner input=new Scanner(System.in);
	System.out.println("Enter your choice");
	int choice=input.nextInt();
	Books bookObj=new Books();
	switch(choice)
	{
	case 1:
		bookObj.
	}
	
	
	}

}
