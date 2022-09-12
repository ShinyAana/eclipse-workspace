package com.sample.fb;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

//import com.demoapp.controllers.Validation;

class InValidEMailException extends Exception
{
	public InValidEMailException(String msg)
	{
		super(msg);
	}
}
class InValidphNumException extends Exception
{
	public InValidphNumException(String msg)
	{
		super(msg);
	}
}

public class Form {
	static int currentUserId = 1;
    Statement statement;
    ResultSet resultSet;

    public  void signUp()  {
        Scanner scanner = new Scanner(System.in);
        String currentUserFirstName="";
        System.out.print("Enter your name: ");
        if(scanner.hasNext("[A-Za-z]*"))
        {
        currentUserFirstName = scanner.nextLine();
        }
        else
        {
        	System.out.println("Numbers not allowed use only A-Z and a-z chars");
        	signUp();
        }
        System.out.println(currentUserFirstName);
        System.out.print("Enter your email - id: ");
        String currentUserEmailId = scanner.nextLine().toLowerCase();
        boolean emailIdValidationChecker = new Validation().emailIdValidationChecker(currentUserEmailId);
        if(emailIdValidationChecker)
        {
        	try
        	{
        		statement=MySqlConnector.getInstance().createStatement();
        		resultSet=statement.executeQuery("select * from users");
        		try
        		{
        		while(resultSet.next())
        		{
        			if(resultSet.getString(4).equals(currentUserEmailId))
        			{
        				throw new InValidEMailException("Mail id already exists in database");
        			}
        		}
        		}
        		catch(InValidEMailException e)
            	{
            		System.out.println(e);
            	}
        	}
        	catch(Exception e)
        	{
        		e.printStackTrace();
        	}
        	
        }
        else
        {
        	System.out.println("Enter a valid mail id");
        }
        System.out.print("Enter your phone number along with country code: ");
        String currentUserPhoneNumber = scanner.nextLine();
        boolean phoneNumberValidationChecker = new Validation().phoneNumberValidationChecker(currentUserPhoneNumber);

        if (phoneNumberValidationChecker && currentUserPhoneNumber.length() >= 10
                && currentUserPhoneNumber.length() <= 15) 
        {
            try {
                statement = MySqlConnector.getInstance().createStatement();
                resultSet = statement.executeQuery("select * from Users");
try
{
                while (resultSet.next()) {
                    if (resultSet.getString(5).equals(currentUserPhoneNumber)) {
                       throw new InValidphNumException("This phone number is in use...");
                    }
                }
}
                catch(InValidphNumException e)
                {
                	System.out.println(e);
                   
                }
                
                }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        else
        {
        	System.out.println("Enter valid phone number");
        }
        boolean isValid=true;
        String pass="";
        do
        {
        System.out.println("Enter your password");
        pass=scanner.next();
        int validatePassword=new Validation().checkPassword(pass);
        if(validatePassword==1)
        {
        	System.out.println("Your password is strong");
        	isValid=false;
        }
        else
        {
        	System.out.println("Your password is not strong...");
            System.out.println(
                    "It should contain one lower case, one upper case, one number, one special character & minimum of length 6...");
            System.out.print("Are you willing to continue? (true / false): ");
            boolean currentUserPasswordAgreemnetChoice;
            if(scanner.hasNextBoolean())
            {
            	currentUserPasswordAgreemnetChoice = scanner.nextBoolean();
            	if(!currentUserPasswordAgreemnetChoice)
            	{
            		break;
            	}
            	else
            	{
            		isValid=true;
            	}
            }
            else
            {
            	System.out.println("Enter a valid input true/false");
            }
        }
            
        }while(isValid);
        String currentUserDateOfBirth;
        scanner.nextLine();
        
        do
        {
        System.out.print("Enter your date of birth as (yyyy-mm-dd hh:mm:ss): ");
        currentUserDateOfBirth = scanner.nextLine();
        if(currentUserDateOfBirth!=null)
        {
        	boolean isValidDate=new Validation().isValidDateTime(currentUserDateOfBirth);
        	if(isValidDate)
        	{
        		System.out.println("Valid dob");
        		isValid=false;
        	}
        	else
        	{
        		isValid=true;
        	}
        }
        else
        {
        	System.out.println("Enter valid input");
        }
        }while(isValid);
        System.out.println(currentUserFirstName);
System.out.println(currentUserEmailId);
System.out.println(currentUserPhoneNumber);
System.out.println(pass);
System.out.println(currentUserDateOfBirth);
        


    }

	public void signIn() {
		// TODO Auto-generated method stub
		
	}

}
