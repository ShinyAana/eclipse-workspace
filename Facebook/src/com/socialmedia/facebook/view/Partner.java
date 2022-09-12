package com.socialmedia.facebook.view;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.socialmedia.facebook.MySqlConnector;
import com.socialmedia.facebook.controller.Profile;

public class Partner {
    Statement statement;
    ResultSet resultSet;
    
    public void displayMyPartners(int currentUserId) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Friends");
        System.out.println("2. Blocked people");
        System.out.println("3. Revoke friend");

        System.out.print("Enter your partnership choice: ");
        int currentUserPartnershipChoice = scanner.nextInt();

        if (currentUserPartnershipChoice == 1) {
            try {
                statement = MySqlConnector.getInstance().createStatement();
                resultSet = statement.executeQuery("select * from Friends");

                while (resultSet.next()) {
                    if (resultSet.getInt(4) == 0 && resultSet.getInt(1) == currentUserId && resultSet
                            .getInt(2) != currentUserId) {
                        int currentUserFriendId = resultSet.getInt(2);

                        try {
                            statement = MySqlConnector.getInstance().createStatement();
                            ResultSet usersResultSet = statement.executeQuery("select * from Users");

                            while (usersResultSet.next()) {
                                if (usersResultSet.getInt(1) == currentUserFriendId) {
                                    System.out.println(usersResultSet.getString(2));

                                    System.out.print("You want to block your friend? (true / false): ");
                                    boolean currentUserPartnerBlockChoice = scanner.nextBoolean();

                                    if (currentUserPartnerBlockChoice) {
                                        try {
                                            statement = MySqlConnector.getInstance().createStatement();
                                            String updateStatement = "UPDATE Friends "
                                                    + "SET currentUserFriendBlockedId = 1 WHERE currentUserFriendId = "
                                                    + currentUserFriendId;
                                            statement.execute(updateStatement);
                                            System.out.println("Your friend is blocked...");
                                        } catch (Exception exception) {
                                            exception.printStackTrace();
                                        }
                                    }
                                }
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if (currentUserPartnershipChoice == 2) {
            try {
                statement = MySqlConnector.getInstance().createStatement();
                resultSet = statement.executeQuery("select * from Friends");

                while (resultSet.next()) {
                    if (resultSet.getInt(4) == 1 && resultSet.getInt(2) != currentUserId && resultSet
                            .getInt(1) == currentUserId) {
                        int currentUserFriendId = resultSet.getInt(2);

                        try {
                            statement = MySqlConnector.getInstance().createStatement();
                            ResultSet usersResultSet = statement.executeQuery("select * from Users");

                            while (usersResultSet.next()) {
                                if (usersResultSet.getInt(1) == currentUserFriendId) {
                                    System.out.println(usersResultSet.getString(2));

                                    System.out.print("You want to unblock your friend? (true / false): ");
                                    boolean currentUserPartnerUnblockChoice = scanner.nextBoolean();
                                    scanner.nextLine();

                                    if (currentUserPartnerUnblockChoice) {
                                        try {
                                            statement = MySqlConnector.getInstance().createStatement();
                                            try {
                                                statement = MySqlConnector.getInstance().createStatement();
                                                String updateStatement = "UPDATE Friends "
                                                        + "SET currentUserFriendBlockedId = " + 0 + " WHERE currentUserFriendId = "
                                                        + currentUserFriendId;
                                                statement.executeUpdate(updateStatement);
                                                System.out.println("Your friend is unblocked...");
                                            } catch (Exception exception) {
                                                exception.printStackTrace();
                                            }
                                        } catch (Exception exception) {
                                            exception.printStackTrace();
                                        }
                                    }
                                }
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if (currentUserPartnershipChoice == 3) {
            try {
                statement = MySqlConnector.getInstance().createStatement();
                resultSet = statement.executeQuery("select * from Friends");

                while (resultSet.next()) {
                    if (resultSet.getInt(3) == 0 && resultSet.getInt(1) == currentUserId && resultSet
                            .getInt(2) != currentUserId) {
                        int currentUserFriendId = resultSet.getInt(2);

                        try {
                            statement = MySqlConnector.getInstance().createStatement();
                            ResultSet usersResultSet = statement.executeQuery("select * from Users");

                            while (usersResultSet.next()) {
                                if (usersResultSet.getInt(1) == currentUserFriendId) {
                                    System.out.println(usersResultSet.getString(2));

                                    System.out.print("You want to cancel the request? (true / false): ");
                                    boolean currentUserPartnerBlockChoice = scanner.nextBoolean();

                                    if (currentUserPartnerBlockChoice) {
                                        try {
                                            statement = MySqlConnector.getInstance().createStatement();
                                            String delteStatement = "DELETE FROM Friends" + " WHERE currentUserFriendId = " + currentUserFriendId;
                                            statement.executeUpdate(delteStatement);
                                            System.out.println("Successfully cancelled your friend request..!!");
                                        } catch (Exception exception) {
                                            exception.printStackTrace();
                                        }
                                    }
                                }
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        
        Profile.displayProfile(currentUserId);
    }
}
