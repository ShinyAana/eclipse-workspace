package com.socialmedia.facebook.controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.socialmedia.facebook.MySqlConnector;

public class Collegue {
    Statement statement;
    ResultSet usersResultSet;

    public void makePartners(int currentUserId) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        
        try {
            statement = MySqlConnector.getInstance().createStatement();
            usersResultSet = statement.executeQuery("select * from Users");

            while (usersResultSet.next()) {
                if (usersResultSet.getInt(1) != currentUserId) {
                    System.out.println(usersResultSet.getString(2));

                    System.out.print("Add friend?(true / false): ");
                    boolean currentUserFriendRequestChoice = scanner.nextBoolean();

                    if (currentUserFriendRequestChoice) {
                        try {
                            statement = MySqlConnector.getInstance().createStatement();
                            String insertStatement = "Insert into Friends(currentUserId, currentUserFriendId, currentUserFriendRequest, currentUserFriendBlockedId)"
                                    + "values('"
                                    + currentUserId + "','"
                                    + usersResultSet.getInt(1) + "','" + 0 + "','"
                                    + 0 + "')";
                            statement.execute(insertStatement);
                            System.out.println("Successfully Added to your friends list..!!");
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }                       
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        Entertainment.displayEntertainment(currentUserId);
    }
}
