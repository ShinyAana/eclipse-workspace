package connectingFolksWeb;

import java.util.Scanner;

public class MainPage
{
	MainPage()
	{
		
	}
public void homePage()
{
	
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		boolean isTrue=true;
		while(isTrue)
		{
		System.out.println("+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*");
		System.out.println("          Welcome To Connecting Folks");
		System.out.println("+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*");
		
		System.out.println();
		System.out.println();
		
		System.out.println("Connecting through...");
		System.out.println("1. User ID");
		System.out.println("2. Page ID");
		System.out.println("3. Exit");
		String choice=input.next();
		if(choice.length()==1 && Character.isDigit(choice.charAt(0)))
		{
			byte ch=Byte.parseByte(choice);
			switch(ch)
			{
			
			case 1: new UserIdHome().userAccount();
			        break;
			
			case 2: new PageIdHome().pageAccount();
			        break;
			        
			case 3:
				{//isTrue=false;
			System.exit(0);
			         break;
				}
			         
			default: System.out.println("Enter valid choice ");
			
			}
		}
		else
			System.out.println("Enter valid input");
	}
	}
public static void main(String[] args) 
{
MainPage mainObj=new MainPage();
mainObj.homePage();
}
}



