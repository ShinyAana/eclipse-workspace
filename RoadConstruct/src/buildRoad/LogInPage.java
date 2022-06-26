package buildRoad;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;

public class LogInPage
{
private String name;
private String password;
private String phoneNo;
private String email;
public enum UserType{Government,Minister,Public};
UserType enUser;

private boolean success;
public LogInPage(String name,String password,String phoneNo,String email,UserType enUser)
{
	this.name=name;
	this.password=password;
	this.phoneNo=phoneNo;
	this.email=email;
	this.enUser=enUser;
	
}
public LogInPage()
{
	
}

	public boolean createUser()
	{
		try {
		Connection con=null;
		String sql="INSERT INTO  user (UserName,Password,PhoneNo,Email,UserType) VALUES(?,?,?,?,?)";
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/roadconstruction?characterEncoding=latin1","root","PriyaAna");
		PreparedStatement ps;
		ps = con.prepareStatement(sql);
        con.setAutoCommit(false);
		ps.setString(1,this.name);
		ps.setString(2,this.password);
		ps.setString(3,this.phoneNo);
		ps.setString(4,this.email);
		ps.setString(5,this.enUser.name());
		success=ps.execute();
		con.commit();
		ps.close();
		con.close();
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
		
		
	}
	public void accountCreation() 
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter user Name    : ");
		String userName = input.nextLine();
		System.out.println("Enter Password     : ");
		String passWord = input.next();
		System.out.println("Enter Phone number : ");
		String phoneNo = input.next();
		System.out.println("Enter Email id     : ");
		String eMail = input.next();
		UserType userType=UserType.Public;
		LogInPage LogInobject=new LogInPage(userName,passWord,phoneNo,eMail,userType);
		boolean result=LogInobject.createUser();
		if(!result)
		{
			System.out.println("Account created successfully");
		}
		else
		{
			UserHome homeObject=new UserHome();
			System.out.println("Try Again");
			homeObject.userAccount();
			
		}
		
	}

	

	public void loginAccount()
	{
		try {
			
		Scanner input=new Scanner(System.in);
		System.out.println("Enter user Name    : ");
		String userName = input.nextLine();
		System.out.println("Enter Password     : ");
		String passWord = input.next();
		//System.out.println("Enter your user type(Government/Minister/Public    : ");
		//String userType = input.next();
		
		boolean flag=false;
		Connection con=null;
		ResultSet rs=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/roadconstruction?characterEncoding=latin1","root","PriyaAna");
		PreparedStatement statement = con.prepareStatement("select * from user where username = ?");    
		statement.setString(1, userName);    
		rs = statement.executeQuery();
		String checkType = null;
		String checkName = null;
		String checkPassword = null;
		int checkId=0;
		while(rs.next())
		{
		checkId=rs.getInt(1);	
		checkName=rs.getString(2);
		checkPassword=rs.getString(3);
		checkType=rs.getString(6);
		if(userName.equals(checkName) && passWord.equals(checkPassword))
		{
			flag=true;
			break;
		}
		}
		if(flag==true)
		{
			LogInPage logobj=new LogInPage();
			MailBox mailObj=new MailBox();
			System.out.println("Valid user");
			if(checkType.equals("Government"))
			{
				logobj.governmentOptions(checkId,checkName);
		    }
			if(checkType.equals("Minister"))
			{
				logobj.ministerOptions(checkId,checkName);
				
			}
			if(checkType.equals("Public"))
			{
				logobj.publicOptions(checkId,checkName);
			}

			
		}
		else
		{
			System.out.println("Invalid username or password .....Try Again");
			UserHome homeObject=new UserHome();
			homeObject.userAccount();
			
		}
		rs.close();
		con.close();
		
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void publicOptions(int checkId, String checkName)
	{
		MailBox mailObj=new MailBox();
		Scanner input=new Scanner(System.in);
		
		System.out.println();
		System.out.println("+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_*_+_*_+_*_+_*_+_*_+_*_+_*");
		System.out.println("          Welcome To Road Construction Road Construction Public Grievance Page \n       You are Logged in as Public");
		System.out.println("+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+*_+_*_+_*_+_*_+_*_+_*_+_*_+_*");
		
		System.out.println();
		System.out.println();
		
		System.out.println("Enter your action");
		System.out.println("1. Send Petition");
		System.out.println("2. View Sent Petition");
		System.out.println("3. View Received Messages");
		System.out.println("4. Exit");
		System.out.println();
		
		String choice=input.next();
		if(choice.length()==1 && Character.isDigit(choice.charAt(0)))
		{
			byte ch=Byte.parseByte(choice);
			switch(ch)
			{
			
			case 1:
				    mailObj.sendPetition(checkId,checkName);
			        break;
			        
			case 2: mailObj.viewSentMessage(checkId,checkName);
	        break;
	
			
			case 3: mailObj.viewReceivedMessage(checkId,checkName);
			        break;
			
			case 4:StartProcess mainObj = new StartProcess();
			       mainObj.startMenu();

			         
			default: System.out.println("Enter valid choice ");
			
			}
		}
		else
			System.out.println("Enter valid input");
	
	}
	public void ministerOptions(int checkId, String checkName)
	{
		MailBox mailObj=new MailBox();
		Scanner input=new Scanner(System.in);
		
		System.out.println();
		System.out.println("+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_*_+_*_+_*_+_*_+_*_+_*_+_*");
		System.out.println("          Welcome To Road Construction Road Construction Public Grievance Page \n       You are Logged in as TN Government PWD Minister");
		System.out.println("+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+*_+_*_+_*_+_*_+_*_+_*_+_*_+_*");
		
		System.out.println();
		System.out.println();
		
		System.out.println("Enter your action");
		System.out.println("1. Send Messages");
		System.out.println("2. View Sent Messages");
		System.out.println("3. View Received Messages");
		System.out.println("4. Exit");
		System.out.println();
		
		String choice=input.next();
		if(choice.length()==1 && Character.isDigit(choice.charAt(0)))
		{
			byte ch=Byte.parseByte(choice);
			switch(ch)
			{
			
			case 1:mailObj.sendPetition(checkId,checkName);
		        break;
			
			case 2: mailObj.viewSentMessage(checkId,checkName);
			        break;
			
			case 3:mailObj.viewReceivedMessage(checkId,checkName);
	             break;
			
			case 4:StartProcess mainObj = new StartProcess();
			       mainObj.startMenu();

			         
			default: System.out.println("Enter valid choice ");
			
			}
		}
		else
			System.out.println("Enter valid input");
	
	}
	public void governmentOptions(int checkId, String checkName)
	{
		MailBox mailObj=new MailBox();
		Scanner input=new Scanner(System.in);
		
		System.out.println();
		System.out.println("+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_*_+_*_+_*_+_*_+_*_+_*_+_*");
		System.out.println("          Welcome To Road Construction Road Construction Public Grievance Page \n       You are Logged in as TN Government(Admin)");
		System.out.println("+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+*_+_*_+_*_+_*_+_*_+_*_+_*_+_*");
		
		System.out.println();
		System.out.println();
		
		System.out.println("Enter your action");
		System.out.println("1. Send Reply to Petition");
		System.out.println("2. Send Approval");
		System.out.println("3. Assign Road id to newly approved road");
		System.out.println("4. Send Message to minister");
		System.out.println("5. View Received Petition");
		System.out.println("6. Exit");
		System.out.println();
		
		String choice=input.next();
		if(choice.length()==1 && Character.isDigit(choice.charAt(0)))
		{
			byte ch=Byte.parseByte(choice);
			switch(ch)
			{
			case 1:mailObj.sendPetition(checkId,checkName);
			       break;
		    
			case 2: 
				mailObj.sendApproval(checkId,checkName);
			        break;
			        
			case 3:mailObj.assignRoadId(checkId,checkName);
			break;
			        
			case 4:mailObj.sendPetition(checkId,checkName);
		       break;
	    
			
			case 5: mailObj.viewReceivedMessage(checkId,checkName);
			        break;
			
			case 6:StartProcess mainObj = new StartProcess();
			       mainObj.startMenu();

			         
			default: System.out.println("Enter valid choice ");
			
			}
		}
		else
			System.out.println("Enter valid input");

	
	}
	
	
}
