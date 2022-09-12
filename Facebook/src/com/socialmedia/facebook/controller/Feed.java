package com.socialmedia.facebook.controller;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.socialmedia.facebook.MySqlConnector;
import com.socialmedia.facebook.view.PostAndNews;

public class Feed {
    Statement statement;

    public void createFeed(int currentUserId) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your feed: ");
        String currentUserPostMessage = scanner.nextLine();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentUserStoryCreatedTime = now.format(format);

        try {
            statement = MySqlConnector.getInstance().createStatement();
            Timestamp timestamp = Timestamp.valueOf(currentUserStoryCreatedTime);

            String insertStatement = "Insert into Posts(currentUserId, currentUserPostMessage, currentUserTotalLikeForPost, currentUserTotalCommentForPost, currentUserTotalShareForPost, currentUserPostCreatedTime)" + "values('"
                    + currentUserId + "','"
                    + currentUserPostMessage + "','" + 0 + "','"
                    + 0 + "','"
                    + 0 + "','"
                    + timestamp + "')";
            statement.execute(insertStatement);
            System.out.println("Post uploaded successfully..!!");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        new PostAndNews().displayMemoriesAndNews(currentUserId);
    }
}
