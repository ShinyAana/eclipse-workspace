package com.socialmedia.facebook.controller;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.socialmedia.facebook.MySqlConnector;
import com.socialmedia.facebook.view.Moment;

public class Status {
    Statement statement;

    public void createStory(int currentUserId) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your mood: ");
        String currentUserStatusMessage = scanner.nextLine();

        System.out.print("Enter your current story background colour: ");
        String currentUserStoryBackgroundColour = scanner.nextLine();

        System.out.print("Enter your current story message colour: ");
        String currentUserStoryMessageColour = scanner.nextLine();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentUserStoryCreatedTime = now.format(format);

        LocalDateTime newDate = now.plusMinutes(2);
        String currentUserStoryEndTime = newDate.format(format);

        try {
            statement = MySqlConnector.getInstance().createStatement();

            String insertStatement = "Insert into Stories(currentUserId, currentUserStoryMessage, currentUserStoryBackground, currentUserStoryMessageColor, currentUserStoryCreatedTime, currentUserStoryExpiredTime, currentUserStoryExists)"
                    + "values('"
                    + currentUserId + "','"
                    + currentUserStatusMessage + "','" + currentUserStoryBackgroundColour + "','"
                    + currentUserStoryMessageColour + "','"
                    + currentUserStoryCreatedTime + "','" + currentUserStoryEndTime + "','" + 0 + "')";
            statement.execute(insertStatement);

            System.out.println("Post uploaded successfully..!!");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        new Moment().displayMoments(currentUserId);
    }
}
