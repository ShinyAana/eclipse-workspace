package mySQLconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnectionDemo
{
	static Connection con;
	public MySQLConnectionDemo()
	{
		try{  
			//Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Student?characterEncoding=latin1","root","PriyaAna");  
		}catch(Exception e){ e.printStackTrace();}  
	}  
public void executeInsertStatment(Student s){  
		
		//here sonoo is database name, root is username and password  
		try{ 
		Statement stmt=con.createStatement();  	
		String statement="Insert into studentdetails(sId,sName,sAge,sMailId,sPhNum) values("+s.getsId()+",'"+s.getsName()+"',"+s.getsAge()+",'"+s.getEmailId()+"',"+s.getPhNumber()+")";
		stmt.execute(statement);  
		
		}catch(Exception e){ e.printStackTrace();}  
	}  
	public  void executeSelectStatment(){  
		
		//here sonoo is database name, root is username and password  
		try{ 
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from studentdetails");  
		while(rs.next())  
		System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getInt(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getLong(5));  
		}catch(Exception e){ e.printStackTrace();}  
	}  
	public void close()
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}

