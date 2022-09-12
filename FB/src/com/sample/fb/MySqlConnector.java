package com.sample.fb;
//package com.socialmedia.facebook;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnector {
    private static Connection connection = null;

    public static Connection getInstance() {
        try {
            String url = "jdbc:mysql://localhost:3306/facebook";
            String userName = "root";
            String userPassword = "PriyaAna";

            try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            connection = DriverManager.getConnection(url, userName, userPassword);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return connection;
    }

    public static void connectorCloser() throws SQLException {
    	if(connection==null)
    	{
    		System.out.println("Connection not yet established");
    		System.exit(0);
    	}
        if (!connection.isClosed()) {
            connection.close();
        }
    }
}

