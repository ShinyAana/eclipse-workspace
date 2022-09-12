package com.socialmedia.facebook.view;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.socialmedia.facebook.MySqlConnector;
import com.socialmedia.facebook.controller.Entertainment;
import com.socialmedia.facebook.controller.Profile;

public class PostAndNews {
    Statement statement;
    ResultSet resultSet;

    public void displayMemoriesAndNews(int currentUserId) throws ClassNotFoundException, SQLException {
        try {
            statement = MySqlConnector.getInstance().createStatement();
            resultSet = statement.executeQuery("select * from Posts");

            while (resultSet.next()) {
                if (resultSet.getInt(1) == currentUserId) {
                    System.out.println(resultSet.getString(2));
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        Entertainment.displayEntertainment(currentUserId);
    }

    public void displayMemoriesAndNews(int currentUserId, boolean currentUserCheck) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        try {
            statement = MySqlConnector.getInstance().createStatement();
            resultSet = statement.executeQuery("select * from Posts");

            while (resultSet.next()) {
                if (resultSet.getInt(1) != currentUserId) {
                    System.out.println(resultSet.getString(2));
                    System.out.print("Like a Post? (true / false): ");
                    boolean currentUserPostLikeChoice = scanner.nextBoolean();
                    System.out.print("Share a Post? (true / false): ");
                    boolean currentUserSharePost = scanner.nextBoolean();
                    System.out.print("Comment a Post? (true / false): ");
                    boolean currentUserCommentPost = scanner.nextBoolean();

                    if (currentUserPostLikeChoice && currentUserSharePost && currentUserCommentPost) {
                        try {
                            statement = MySqlConnector.getInstance().createStatement();

                            String insertStatement = "Insert into Posts(currentUserId, currentUserPostMessage, currentUserTotalLikeForPost, currentUserTotalCommentForPost, currentUserTotalShareForPost)"
                                    + "values('"
                                    + currentUserId + "','" + resultSet.getString(2) + "','" + resultSet.getInt(1)
                                    + "','"
                                    + resultSet.getInt(1) + "','"
                                    + resultSet.getInt(1) + "')";
                            statement.execute(insertStatement);
                            System.out.println("Successfully liked, shared & commented..!!");
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    } else if (currentUserPostLikeChoice) {
                        statement = MySqlConnector.getInstance().createStatement();

                        String insertStatement = "Insert into Posts(currentUserId, currentUserPostMessage, currentUserTotalLikeForPost,)"
                                + "values('"
                                + currentUserId + "','" + resultSet.getString(2) + "','" + resultSet.getInt(1) + "')";
                        statement.execute(insertStatement);
                        System.out.println("Successfully liked a post..!!");
                    } else if (currentUserSharePost) {
                        statement = MySqlConnector.getInstance().createStatement();

                        String insertStatement = "Insert into Posts(currentUserId, currentUserPostMessage, currentUserTotalCommentForPost)"
                                + "values('"
                                + currentUserId + "','" + resultSet.getString(2) + "','"
                                + resultSet.getInt(1) + "')";
                        statement.execute(insertStatement);
                        System.out.println("Successfully commented on post..!!");
                    } else if (currentUserCommentPost) {
                        statement = MySqlConnector.getInstance().createStatement();

                        String insertStatement = "Insert into Posts(currentUserId, currentUserPostMessage, currentUserTotalShareForPost)"
                                + "values('"
                                + currentUserId + "','" + resultSet.getString(2) + "','" + resultSet.getInt(1) + "')";
                        statement.execute(insertStatement);
                        System.out.println("Successfully shared a post..!!");
                    } else if (currentUserPostLikeChoice && currentUserSharePost) {
                        statement = MySqlConnector.getInstance().createStatement();

                        String insertStatement = "Insert into Posts(currentUserId, currentUserPostMessage, currentUserTotalLikeForPost, currentUserTotalShareForPost)"
                                + "values('"
                                + currentUserId + "','" + resultSet.getString(2) + "','" + resultSet.getInt(1) + "','"
                                + resultSet.getInt(1) + "')";
                        statement.execute(insertStatement);
                        System.out.println("Successfully liked and shared a post..!!");
                    } else if (currentUserPostLikeChoice && currentUserCommentPost) {
                        statement = MySqlConnector.getInstance().createStatement();

                        String insertStatement = "Insert into Posts(currentUserId, currentUserPostMessage, currentUserTotalLikeForPost, currentUserTotalCommentForPost)"
                                + "values('"
                                + currentUserId + "','" + resultSet.getString(2) + "','" + resultSet.getInt(1) + "','"
                                + resultSet.getInt(1) + "')";
                        statement.execute(insertStatement);
                        System.out.println("Successfully liked and commented on a post..!!");
                    } else if (currentUserCommentPost && currentUserSharePost) {
                        statement = MySqlConnector.getInstance().createStatement();

                        String insertStatement = "Insert into Posts(currentUserId, currentUserPostMessage, currentUserTotalCommentForPost, currentUserTotalShareForPost)"
                                + "values('"
                                + currentUserId + "','" + resultSet.getString(2) + "','" + resultSet.getInt(1) + "','"
                                + resultSet.getInt(1) + "')";
                        statement.execute(insertStatement);
                        System.out.println("Successfully shared and commented a post..!!");
                    }
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        Profile.displayProfile(currentUserId);
    }
}
