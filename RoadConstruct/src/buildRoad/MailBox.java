package buildRoad;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;
public class MailBox extends LogInPage
{
	//LocalDate date = LocalDate.now();

private int messageId;
private int userId;
private String sender;
private String receiver;
private Date msgDate;
private String roadLocation;
private String msgBody;
private String status;
private String roadId;
private boolean success;


public MailBox(int messageId,int userId,String sender,String receiver,Date msgDate,String roadLocation,String msgBody,String status,String roadId)
{
	this.messageId=messageId;
	this.userId=userId;
	this.sender=sender;
	this.receiver=receiver;
	this.msgDate=msgDate;
	this.roadLocation=roadLocation;
	this.msgBody=msgBody;
	this.status=status;
	this.roadId=roadId;
}
public MailBox()
{
	
}
public boolean createMail()
{
	try {
	Connection con=null;
	String sql="INSERT INTO MessageBox(MessageId,UserId,Sender,Receiver,DateOFMsg,RoadLocation,MessageBody,StatusOfMsg,RoadId) VALUES(?,?,?,?,?,?,?,?,?)";
	
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/roadconstruction?characterEncoding=latin1","root","PriyaAna");
	PreparedStatement ps;
	ps = con.prepareStatement(sql);
    con.setAutoCommit(false);
	ps.setInt(1,this.messageId);
	ps.setInt(2,this.userId);
	ps.setString(3,this.sender);
	ps.setString(4,this.receiver);
	ps.setDate(5, this.msgDate);
	ps.setString(6, this.roadLocation);
	ps.setString(7, this.msgBody);
	ps.setString(8, this.status);
	ps.setString(9, this.roadId);
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
private static java.sql.Date getCurrentDate() {
    java.util.Date today = new java.util.Date();
    return new java.sql.Date(today.getTime());
}

public void sendPetition(int checkId, String checkName)
{
	Scanner input=new Scanner(System.in);
	int messageId=(int) (Math.random() * 100 + 100);
	int userId=checkId;
	String sender=checkName;
	System.out.println("To Address       : ");
	String receiver = input.nextLine();
	Date msgDate=getCurrentDate();
	System.out.println("Road Location    : ");
	String roadLocation = input.nextLine();
	System.out.println("Message Body     : ");
	String msgBody = input.nextLine();
	String status=null;
	String roadId=null;
	MailBox mailObject=new MailBox(messageId,userId,sender,receiver,msgDate,roadLocation,msgBody,status,roadId);
	boolean result=mailObject.createMail();
	if(!result)
	{
		System.out.println("Message sent successfully");
	}
	else
	{
		UserHome homeObject=new UserHome();
		System.out.println("Try Again");
		homeObject.userAccount();
		
	}
	
	
	
}
public void viewReceivedMessage(int checkId, String checkName)
{
	try {
		
	boolean flag=false;
	Connection con=null;
	ResultSet rs=null;
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/roadconstruction?characterEncoding=latin1","root","PriyaAna");
	PreparedStatement statement = con.prepareStatement("select * from MessageBox where Receiver = ?");    
	statement.setString(1, checkName);    
	rs = statement.executeQuery();
	System.out.println("Message details are ");
	while(rs.next())
	{
		System.out.println("<Message Id    :>    "+rs.getInt(1));
		System.out.println("<Sent By       :>    "+rs.getString(3));
		System.out.println("<Received By   :>    "+rs.getString(4));
		System.out.println("<Date Of Msg   :>    "+rs.getDate(5));
		System.out.println("<Road Location :>    "+rs.getString(6));
		System.out.println("<Message Body  :>    "+rs.getString(7));
		System.out.println("<Message Status:>    "+rs.getString(8));
		System.out.println("<Road Id       :>    "+rs.getString(9));
		
	}
	rs.close();
	con.close();
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void sendApproval(int checkId, String checkName)  
{
	try
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter Message id you want to approve");
		int approveId=input.nextInt();
		String approveMsg="Approved";
		
		Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/roadconstruction?characterEncoding=latin1","root","PriyaAna");
		PreparedStatement statement = con.prepareStatement("UPDATE MessageBox SET StatusOfMsg= ? where MessageId= ?");    
		statement.setString(1, approveMsg);  
		statement.setInt(2, approveId);    
		int rs = statement.executeUpdate();
		System.out.println("Updated Successfully");
		
		
		
    //String url              = "jdbc:mysql://localhost:3306/alien?useSSL=false";
   // String uname            = "root";
   // String pass             = "ma123";
       //Connection con = DriverManager.getConnection(url, uname, pass);
   
    System.out.println(rs);
    statement.close();
    con.close();
    LogInPage obj=new LogInPage();
    obj.governmentOptions(checkId, checkName);
    	
	}
	 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
}
public void viewSentMessage(int checkId, String checkName)
{
	try {
		
		boolean flag=false;
		Connection con=null;
		ResultSet rs=null;
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/roadconstruction?characterEncoding=latin1","root","PriyaAna");
		PreparedStatement statement = con.prepareStatement("select * from MessageBox where UserId = ?");    
		statement.setInt(1, checkId);    
		rs = statement.executeQuery();
		System.out.println("Message details are ");
		while(rs.next())
		{
			System.out.println("<Message Id    :>    "+rs.getInt(1));
			System.out.println("<Sent By       :>    "+rs.getString(3));
			System.out.println("<Received By   :>    "+rs.getString(4));
			System.out.println("<Date Of Msg   :>    "+rs.getDate(5));
			System.out.println("<Road Location :>    "+rs.getString(6));
			System.out.println("<Message Body  :>    "+rs.getString(7));
			System.out.println("<Message Status:>    "+rs.getString(8));
			System.out.println("<Road Id       :>    "+rs.getString(9));
			
		}
		rs.close();
		con.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
public void assignRoadId(int checkId, String checkName) 
{
	try
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter Message id you want to approve");
		int approveId=input.nextInt();
		System.out.println();
		System.out.println("Enter road id to assign");
		String approveRoadId=input.next();
		
		Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/roadconstruction?characterEncoding=latin1","root","PriyaAna");
		PreparedStatement statement = con.prepareStatement("UPDATE MessageBox SET RoadId= ? where MessageId= ?");    
		statement.setString(1, approveRoadId);  
		statement.setInt(2, approveId);    
		int rs = statement.executeUpdate();
		System.out.println("Road id Assigned Successfully");
		 System.out.println(rs);
		    statement.close();
		    con.close();
		    LogInPage obj=new LogInPage();
		    obj.governmentOptions(checkId, checkName);
		    	
			}
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	
}



	
}
