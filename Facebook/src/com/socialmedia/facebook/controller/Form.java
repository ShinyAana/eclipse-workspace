package com.socialmedia.facebook.controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Scanner;

import com.socialmedia.facebook.MySqlConnector;
import com.socialmedia.facebook.model.UserCredential;
class InValidEmailIdException extends Exception
{
public InValidEmailIdException(String id)
{
	super(id);
}
}
class InValidPasswordException extends Exception
{
	public InValidPasswordException(String msg)
	{
		super(msg);
	}
}
class InValidPhoneNumException extends Exception
{
	public InValidPhoneNumException(String msg)
	{
		super(msg);
	}
}
public class Form {
    static int currentUserId = 1;
    Statement statement;
    ResultSet resultSet;

    public void signUp()  {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String currentUserFirstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String currentUserLastName = scanner.nextLine();

        System.out.print("Enter your email - id: ");
        String currentUserEmailId = scanner.nextLine().toLowerCase();
        boolean emailIdValidationChecker = new Validation().emailIdValidationChecker(currentUserEmailId);

        if (emailIdValidationChecker) {
            try {
                statement = MySqlConnector.getInstance().createStatement();
                resultSet = statement.executeQuery("select * from Users");

                while (resultSet.next()) {
                    if (resultSet.getString(4).equals(currentUserEmailId)) {
                        System.out.println("This email-id is already taken...");
                        signUp();
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        System.out.print("Enter your phone number along with country code: ");
        String currentUserPhoneNumber = scanner.nextLine();
        boolean phoneNumberValidationChecker = new Validation().phoneNumberValidationChecker(currentUserPhoneNumber);

        if (phoneNumberValidationChecker && currentUserPhoneNumber.length() >= 10
                && currentUserPhoneNumber.length() <= 15) {
            try {
                statement = MySqlConnector.getInstance().createStatement();
                resultSet = statement.executeQuery("select * from Users");
try
{
                while (resultSet.next()) {
                    if (resultSet.getString(5).equals(currentUserPhoneNumber)) {
                       throw new InValidPhoneNumException("This phone number is in use...");
                    }
                }
}
                catch(InValidPhoneNumException e)
                {
                	System.out.println(e);
                   
                }
                
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        System.out.println("Enter your password: ");
        String currentUserPassword = scanner.nextLine();

        int currentUserPasswordLength = currentUserPassword.length();

        int count = 0;
        if (currentUserPasswordLength == currentUserPassword.replaceAll("[0-9]", "").length())
            count++;
        if (currentUserPasswordLength == currentUserPassword.replaceAll("[a-z]", "").length())
            count++;
        if (currentUserPasswordLength == currentUserPassword.replaceAll("[A-Z]", "").length())
            count++;
        if (currentUserPasswordLength == currentUserPassword.replaceAll("[-!@#$%^&*()+]", "").length())
            count++;

        int i = currentUserPasswordLength + count;
        count += i < 6 ? 6 - i : 0;

        if (count != 0) {
            System.out.println("Your password is not strong...");
            System.out.println(
                    "It should contain one lower case, one upper case, one number, one special character & minimum of length 6...");
            System.out.print("Are you willing to continue? (true / false): ");
            boolean currentUserPasswordAgreemnetChoice = scanner.nextBoolean();
            scanner.nextLine();
            if (!currentUserPasswordAgreemnetChoice) {
                signUp();
            }
        }

        System.out.print("Enter your date of birth as (yyyy-mm-dd hh:mm:ss): ");
        String currentUserDateOfBirth = scanner.nextLine();

        UserCredential userCredentials = new UserCredential();

        try {
            statement = MySqlConnector.getInstance().createStatement();
            resultSet = statement.executeQuery("select * from Users");

            while (resultSet.next()) {
                if (resultSet.getInt(1) == currentUserId) {
                    currentUserId++;
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        finally
        {
        	try {
				MySqlConnector.connectorCloser();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	//statement=null;
        	//resultSet=null;
        }

        userCredentials.setUserId(currentUserId++);
        userCredentials.setUserFirstName(currentUserFirstName);
        userCredentials.setUserLastName(currentUserLastName);
        userCredentials.setUserEmailId(currentUserEmailId);
        userCredentials.setUserPhoneNumber(currentUserPhoneNumber);
        userCredentials.setUserPassword(currentUserPassword);
        userCredentials.setUserDateOfBirth(currentUserDateOfBirth);
        executeInsertUserCredentialsStatment(userCredentials);
        try {
			Router.displayRouters(userCredentials.getUserId());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void signIn() {
        Scanner scanner = new Scanner(System.in);
        boolean currentUserValidation = true;

        try {
            System.out.print("Enter your email-id: ");
            String currentUserEmailId = scanner.nextLine().toLowerCase();

            statement = MySqlConnector.getInstance().createStatement();
            resultSet = statement.executeQuery("select * from Users");
            try
            {

            while (resultSet.next()) {
                if (resultSet.getString(4).equals(currentUserEmailId))
                {
                	try
                	{
                		
                    System.out.print("Enter your password: ");
                    String currentUserPassword = scanner.nextLine();
                    if (resultSet.getString(6).equals(currentUserPassword)) {
                        System.out.println("Successfully logged in...");
                        System.out.println("^^^^^ Welcome back { " + resultSet.getString(2) + " } ^^^^^");
                        currentUserValidation = false;
                        Router.displayRouters(resultSet.getInt(1));
                    }
                    else
                    {
                    	throw new InValidPasswordException("Password wrong");
                    }
                	}
                	catch(InValidPasswordException e)
                	{
                		System.out.println(e);
                		//e.printStackTrace();
                		return;
                	}
                   
                               }
                else
                {
                	throw new InValidEmailIdException("Email id not present in database");
                }
                
            }
            }
        catch(InValidEmailIdException e)
        {
        	System.out.println(e);
        	e.printStackTrace();
            return;
        }


            if (currentUserValidation) 
            {
                System.out.println("Not yet signed in...");
                System.out.print("Are you wish to sign-in? (true / false): ");
                if(scanner.hasNextBoolean())
                {
                boolean currentUserSignUpChoice = scanner.nextBoolean();
                if (currentUserSignUpChoice) {
                    signUp();
                }
                }
                else
                {
                	System.out.println("Enter valid boolen input true/false");
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        finally
        {
        	try {
				MySqlConnector.connectorCloser();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

    private void executeInsertUserCredentialsStatment(UserCredential userCredentials) {
        try {
            statement = MySqlConnector.getInstance().createStatement();
            Timestamp timestamp = Timestamp.valueOf(userCredentials.getUserDateOfBirth());

            String insertStatement = "Insert into Users(currentUserId, currentUserFirstName, currentUserLastName, currentUserEmailId, currentUserPhoneNumber, currentUserPassword, currentUserDateOfBirth)"
                    + "values('" + userCredentials.getUserId() + "','"
                    + userCredentials.getUserFirstName() + "','"
                    + userCredentials.getUserLastName() + "','" + userCredentials.getUserEmailId() + "','"
                    + userCredentials.getUserPhoneNumber() + "','" + userCredentials.getUserPassword() + "','"
                    + timestamp
                    + "')";
            statement.execute(insertStatement);
            System.out.println("Your account is now on live...");
            System.out.println("Your id is: " + userCredentials.getUserId());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
