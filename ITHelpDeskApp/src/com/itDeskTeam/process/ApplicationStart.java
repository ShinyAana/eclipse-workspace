package com.itDeskTeam.process;

import java.util.Scanner;


public class ApplicationStart {

	public static void main(String[] args) 
	{
		ApplicationStart startProcess=new ApplicationStart();
		startProcess.startMenu();
	}
	public void startMenu()
	{
		Scanner input=new Scanner(System.in);
		boolean isTrue=true;
		while(isTrue)
		{
		System.out.println("+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_*_+_*_+_*_+_*_+_*_+_*_+_*");
		System.out.println("          Welcome To IT Help Desk");
		System.out.println("+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+*_+_*_+_*_+_*_+_*_+_*_+_*_+_*");
		
		System.out.println();
		System.out.println();
		
		System.out.println("Connecting through");
		System.out.println("1. Admin(Support Technician)");
		System.out.println("2. Employee");
		System.out.println("3. Exit");
		
		String choice=input.next();
		if(choice.length()==1 && Character.isDigit(choice.charAt(0)))
		{
			byte ch=Byte.parseByte(choice);
			switch(ch)
			{
			
			case 1: new LogInPage().loginAccount();
			        break;
			
			case 2: new LogInPage().loginAccount();
			        break;
			       
			case 3:System.exit(0);
	               break;
			         
			default: System.out.println("Enter valid choice ");
			
			}
		}
		else
			System.out.println("Enter valid input");
		}
	}
	


}
