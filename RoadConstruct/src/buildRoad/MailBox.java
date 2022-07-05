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
	
	if(checkId==1)
	{
		LogInPage obj=new LogInPage();
		obj.governmentOptions(checkId, checkName);
	}
	else if(checkId==7)
	{
		LogInPage obj=new LogInPage();
		obj.ministerOptions(checkId, checkName);
	}
	else
	{
		LogInPage obj=new LogInPage();
		obj.publicOptions(checkId, checkName);
	}
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
		System.out.println();
		System.out.println();
		System.out.println();
		
	}
	rs.close();
	con.close();
	if(checkId==1)
	{
		LogInPage obj=new LogInPage();
		obj.governmentOptions(checkId, checkName);
	}
	else if(checkId==7)
	{
		LogInPage obj=new LogInPage();
		obj.ministerOptions(checkId, checkName);
	}
	else
	{
		LogInPage obj=new LogInPage();
		obj.publicOptions(checkId, checkName);
	}
	
	
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
public void estimateRoadConstructionCost(int checkId, String checkName)
{
	Scanner input=new Scanner(System.in);
	EquipmentCost object=new EquipmentCost();

System.out.println("Equipment cost details are");
object.equipmentDetails();

System.out.println("Enter the number of tractors do you want for your road construction ");
int tractor=input.nextInt();
System.out.println("Enter the number of loader do you want for your road construction ");
int loader=input.nextInt();
System.out.println("Enter the number of crusher do you want for your road construction ");
int crusher=input.nextInt();
System.out.println("Enter the number of stacker do you want for your road construction ");
int stacker=input.nextInt();
System.out.println("Enter the number of generator do you want for your road construction ");
int generator=input.nextInt();
int totalEquipmentCost=(tractor*216)+(loader*180)+(crusher*180)+(stacker*30)+(generator*40);




System.out.println("Rock Spread cost details are");
object.rockSpreadCost();

System.out.println("Enter your road length (in kilometers) to find rock spread cost");
double length=input.nextDouble();
double totalRockSpreadCost=length*7157;

System.out.println("Drainage cost details are");
object.drainageCost();

System.out.println("Enter your road length (in kilometers) to find rock spread cost");
double length1=input.nextDouble();
double totalDrainageCost=length1*918;



System.out.println("Man power details are");
object.calculateManPower();

System.out.println("Enter number of first class mason for road construction");
int mason1=input.nextInt();
System.out.println("Enter number of second class mason for road construction");
int mason2=input.nextInt();
System.out.println("Enter number of Mazdoor(Unskilled) for road construction");
int mazdoorUS=input.nextInt();
System.out.println("Enter number of Mazdoor(Skilled) for road construction");
int mazdoorS=input.nextInt();
System.out.println("Enter number of Surveyor for road construction");
int surveyor=input.nextInt();
System.out.println("Enter number of Mazdoor(Semi skilled) for road construction");
int mazdoorSS=input.nextInt();
int totalManPowerCost=(mason1*350)+(mason2*320)+(mazdoorUS*280)+(mazdoorS*320)+(surveyor*500)+(mazdoorSS*280);

object.printCost(totalEquipmentCost,totalRockSpreadCost,totalDrainageCost,totalManPowerCost);
double totalCost=totalEquipmentCost+totalRockSpreadCost+totalDrainageCost+totalManPowerCost;
System.out.println("Enter the road id ");
String roadId=input.next();
System.out.println("Assign register number to road ");
int regNo=input.nextInt();
CostDetails costObj=new CostDetails(roadId,regNo,totalEquipmentCost,totalRockSpreadCost,totalDrainageCost,totalManPowerCost,totalCost);

boolean result=costObj.addTodatabase();
if(!result)
{
	System.out.println("Inserted into DB successfully");
}
else
{
	System.out.println("Try Again");
	LogInPage obj=new LogInPage();
	obj.ministerOptions(checkId, checkName);

}

	

LogInPage obj1=new LogInPage();
obj1.ministerOptions(checkId, checkName);

}
public void viewRoadDetails(int checkId, String checkName) 
{
try {
	Scanner input=new Scanner(System.in);
		
		boolean flag=false;
		Connection con=null;
		ResultSet rs=null;
		//System.out.println("Enter Road id to see the details");
		//String roadId=input.next();
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/roadconstruction?characterEncoding=latin1","root","PriyaAna");
		PreparedStatement statement = con.prepareStatement("SELECT m.RoadId,c.RoadRegisterNumber,m.RoadLocation,c.EquipmentCost,c.RockSpreadCost,c.DrainageCost,c.ManPowerCost,c.totalcost FROM MessageBox m,CostDetails c WHERE m.RoadId=c.RoadId");    
		//statement.setString(1, roadId);    
		rs = statement.executeQuery();
		System.out.println("Road details are ");
		while(rs.next())
		{
			System.out.println("<Road Id                    :>    "+rs.getString(1));
			System.out.println("<Road Register Number       :>    "+rs.getInt(2));
			System.out.println("<Road Location              :>    "+rs.getString(3));
			System.out.println("<Equipment Cost             :>    "+rs.getInt(4));
			System.out.println("<Rock Spread Cost           :>    "+rs.getDouble(5));
			System.out.println("<Drainage Cost              :>    "+rs.getDouble(6));
			System.out.println("<Man Power Cost             :>    "+rs.getInt(7));
			System.out.println("<Total Cost                 :>    "+rs.getDouble(8));
			System.out.println();
			System.out.println();
			System.out.println("------------------------------------------------------------------------------");
			System.out.println();
			System.out.println();
			
			
		}
		rs.close();
		con.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
if(checkId==1)
{
	LogInPage obj=new LogInPage();
	obj.governmentOptions(checkId, checkName);
}
else if(checkId==7)
{
	LogInPage obj=new LogInPage();
	obj.ministerOptions(checkId, checkName);
}
else
{
	LogInPage obj=new LogInPage();
	obj.publicOptions(checkId, checkName);
}

	
}
public void sendMessageToMinister(int checkId, String checkName)
{
	// TODO Auto-generated method stub
	
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
	String status="Approved";
	System.out.println("Road Id    : ");
	
	String roadId=input.next();
	MailBox mailObject=new MailBox(messageId,userId,sender,receiver,msgDate,roadLocation,msgBody,status,roadId);
	boolean result=mailObject.createMail();
	if(!result)
	{
		System.out.println("Message sent successfully");
	
	if(checkId==1)
	{
		LogInPage obj=new LogInPage();
		obj.governmentOptions(checkId, checkName);
	}
	else if(checkId==7)
	{
		LogInPage obj=new LogInPage();
		obj.ministerOptions(checkId, checkName);
	}
	else
	{
		LogInPage obj=new LogInPage();
		obj.publicOptions(checkId, checkName);
	}
	}
	
	else
	{
		UserHome homeObject=new UserHome();
		System.out.println("Try Again");
		homeObject.userAccount();
		
	}
	

}

	
}
