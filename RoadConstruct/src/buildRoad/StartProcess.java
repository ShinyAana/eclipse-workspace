package buildRoad;

import java.util.Scanner;



public class StartProcess {

	public static void main(String[] args)
	{
		StartProcess mainObj=new StartProcess();
		mainObj.startMenu();
	}

	public void startMenu()
	{
		Scanner input=new Scanner(System.in);
		boolean isTrue=true;
		while(isTrue)
		{
		System.out.println("+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*");
		System.out.println("          Welcome To Road Construction Road Construction Public Grievance Page");
		System.out.println("+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+*_+");
		
		System.out.println();
		System.out.println();
		
		System.out.println("Connecting through");
		System.out.println("1. Admin(Government)");
		System.out.println("2. Manager");
		System.out.println("3. Public");
		System.out.println("4. Exit");
		
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
			
			case 3:new UserHome().userAccount();
	               break;
	               
			case 4:System.exit(0);
	               break;
			         
			default: System.out.println("Enter valid choice ");
			
			}
		}
		else
			System.out.println("Enter valid input");
	}
	
	}

}
