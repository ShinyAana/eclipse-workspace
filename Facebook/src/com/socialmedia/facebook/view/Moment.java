package com.socialmedia.facebook.view;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.socialmedia.facebook.MySqlConnector;
import com.socialmedia.facebook.controller.Entertainment;
import com.socialmedia.facebook.controller.Profile;
 
public class Moment {
    Statement statement;
    ResultSet resultSet;

    public void displayMoments(int currentUserId) throws ClassNotFoundException, SQLException {
        try {
            statement = MySqlConnector.getInstance().createStatement();
            resultSet = statement.executeQuery("select * from Stories");

            while (resultSet.next()) {
                if (resultSet.getInt(1) == currentUserId) {
                    int compareValue = resultSet.getTimestamp(5).compareTo(resultSet.getTimestamp(6));
                    if (compareValue < 0) {
                        System.out.println(resultSet.getString(2));
                    }
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        Entertainment.displayEntertainment(currentUserId);
    }

    public void displayMoments(int currentUserId, boolean currentUserCheck) throws ClassNotFoundException, SQLException {
        try {
            statement = MySqlConnector.getInstance().createStatement();
            resultSet = statement.executeQuery("select * from Stories");

            while (resultSet.next()) {
                if (resultSet.getInt(1) != currentUserId) {                    
                    int compareValue = resultSet.getTimestamp(5).compareTo(resultSet.getTimestamp(6));
                    if (compareValue > 0) {
                        System.out.println(resultSet.getString(2));
                    }
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        Profile.displayProfile(currentUserId);
    }
}
