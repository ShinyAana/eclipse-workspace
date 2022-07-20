package com.itDeskTeam.process;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class LogInPage 
{
int userId;
String userName;
String password;
public LogInPage(int userId,String userName,String password)
{
	this.userId=userId;
	this.userName=userName;
	this.password=password;
}
public LogInPage()
{
	
}

	public void loginAccount() 
	{
		try {
			
		Scanner input=new Scanner(System.in);
		System.out.println("Enter user id   : ");
		int userId = input.nextInt();
		System.out.println();
		System.out.println("Enter Password     : ");
		String passWord = input.next();
		boolean flag=false;
		Connection con=null;
		ResultSet rs=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ithelpdesk?characterEncoding=latin1","root","PriyaAna");
		PreparedStatement statement = con.prepareStatement("select * from user where userId = ?");    
		statement.setInt(1, userId);    
		rs = statement.executeQuery();
		int checkId = 0;
		String checkName = null;
		String checkPassword = null;
		while(rs.next())
		{
		checkId=rs.getInt(1);	
		checkName=rs.getString(2);
		checkPassword=rs.getString(3);
		if(userId==checkId && passWord.equals(checkPassword))
		{
			flag=true;
			break;
		}
		}
		if(flag==true)
		{
			LogInPage logobj=new LogInPage();
			System.out.println("Valid user");
			if(userId==121 || userId==122)
			{
				logobj.employeeOptions(checkId,checkName);
		    }
			if(userId==101 || userId==102)
			{
				logobj.technicianOptions(checkId,checkName);
				
			}
			
			
		}
		else
		{
			System.out.println("Invalid username or password .....Try Again");
			
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
	private void technicianOptions(int checkId, String checkName) 
	{
		SupportRequest techObj=new SupportRequest();
		Scanner input=new Scanner(System.in);
		boolean isExit=true;
		while(isExit)
		{
		System.out.println();
		System.out.println("+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_*_+_*_+_*_+_*_+_*_+_*_+_*");
		System.out.println("          Welcome To IT Help Desk \n                 You are Logged in as Support Technician");
		System.out.println("+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+*_+_*_+_*_+_*_+_*_+_*_+_*_+_*");
		
		System.out.println();
		System.out.println();
		
		System.out.println("Enter your action");
		System.out.println("1. View New Support Tickets on my name");
		System.out.println("2. Update status of a ticket");
		System.out.println("3. View Deleted Support Tickets");
		System.out.println("4. View Archived Tickets");
		System.out.println("7. Send message to technician");
		System.out.println("8. Delete request autometically");
		System.out.println("5. Carry forward the ticket to other Support Technician");
		System.out.println("6. Back to home");
		
		System.out.println();
		
		String choice=input.next();
		if(choice.length()==1 && Character.isDigit(choice.charAt(0)))
		{
			byte ch=Byte.parseByte(choice);
			switch(ch)
			{
			
			case 1:
				techObj.viewNewSupportRequest(checkId,checkName);
			        break;
			        
			case 2: techObj.updateTicketStatus(checkId,checkName);
	        break;
	
			
			case 3: techObj.viewDeletedSupportTickets(checkId,checkName);
			        break;
			        
			case 4: techObj.viewArchivedSupportTickets(checkId,checkName);
	        break;
	        
			case 5: techObj.ticketCarryForward(checkId,checkName);
	        break;
	
			case 7:techObj.sendMessage(checkId,checkName);
	        break;
			
			case 6:isExit=false;
			break;

			         
			default: System.out.println("Enter valid choice ");
			
			}
		}
		
		else
			System.out.println("Enter valid input");
		}
	

	}
	private void employeeOptions(int checkId, String checkName) 
	{
		SupportRequest userObj=new SupportRequest();
		
		Scanner input=new Scanner(System.in);
		boolean isExit=true;
		while(isExit)
		{
		System.out.println();
		System.out.println("+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_*_+_*_+_*_+_*_+_*_+_*_+_*");
		System.out.println("          Welcome To IT Help Desk \n                 You are Logged in as Employee");
		System.out.println("+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+_*_+*_+_*_+_*_+_*_+_*_+_*_+_*_+_*");
		
		System.out.println();
		System.out.println();
		
		System.out.println("Enter your action");
		System.out.println("1. Create New Support Request");
		System.out.println("2. View Support Request");
		System.out.println("3. Update Subject Support Request");
		System.out.println("4. Update Description Support Request");
		
		System.out.println("5. List My Requets Details");
		System.out.println("6. Change Support Technician");
		System.out.println("7. Back to home");
		
		System.out.println();
		
		String choice=input.next();
		if(choice.length()==1 && Character.isDigit(choice.charAt(0)))
		{
			byte ch=Byte.parseByte(choice);
			switch(ch)
			{
			
			case 1:
				userObj.newSupportRequest(checkId,checkName);
			        break;
			        
			case 2: userObj.viewSupportRequest(checkId,checkName);
	        break;
	
			
			case 3: userObj.updateSupportRequest(checkId,checkName);
			        break;
			        
			case 4: userObj.updateDesSupportRequest(checkId,checkName);
	        break;
	        
			case 5: userObj.listSupportRequest(checkId,checkName);
	        break;
	        
			case 6: userObj.changeSupportTechnician(checkId,checkName);
	        break;
	
	
			
			case 7:isExit=false;
			break;

			         
			default: System.out.println("Enter valid choice ");
			
			}
		}
		
		else
			System.out.println("Enter valid input");
		}
	
	}
		

}
