package connectingFolksWeb;

import java.util.Scanner;

public class UserIdHome 
{

	
	public void userAccount()
	{
		System.out.println();
		System.out.println("........Connecting Folks.........");
		System.out.println();
		Scanner input=new Scanner(System.in);
		
		System.out.println(" 1.Create Account \n 2. Login Account \n 3.Go To HomePage");
		System.out.print("=> ");
	    int page_retry_count = 0;
		try {
	    	int ch=input.nextInt();
			switch (ch) {
			case 1: {
				   page_retry_count=0;
	               new LogInPage().create_New_Account();
				break;
			}
			case 2:{
				   page_retry_count=0;
				   new LogInPage().login_Account();
				break;
			}
			case 3:{
				MainPage mainObj=new MainPage();
				mainObj.homePage();

							
	           		break;
			}
		   }

	
		} catch (Exception e) {
            		
            page_retry_count++;
            if(page_retry_count==3) 
            {   System.out.println();
         	   System.out.println("                [many more attempt]   !!");
         	   System.out.println();
               System.exit(0);
             }
             System.out.println();
             System.out.println("   *Enter valid input ..");
		        System.out.println();
		    userAccount();   
		}
}
		
	}

