<%@ page import="java.sql.*"%>
<%
String name=request.getParameter("uname");

String pass=request.getParameter("password");

String mNo=request.getParameter("mobilenumber");

String eMail=request.getParameter("email");

try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/loginform?characterEncoding=latin1","root","PriyaAna");  

	//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform","root","PriyaAna");
	Statement st=con.createStatement();
	st.executeUpdate("insert into logindetails(uname,password,mobilenumber,email) values('"+name+"','"+pass+"','"+mNo+"','"+eMail+"')");
	response.sendRedirect("save.html");
	
}
catch(Exception e)
{
	e.printStackTrace();
	response.sendRedirect("error.html");
}

 %>