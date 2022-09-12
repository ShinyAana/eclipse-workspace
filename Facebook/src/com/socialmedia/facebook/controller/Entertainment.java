package com.socialmedia.facebook.controller;
import java.sql.SQLException;
import java.util.Scanner;

import com.socialmedia.facebook.FacebookDriver;

public class Entertainment {
    public static void displayEntertainment(int currentUserId) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Add Story");
        System.out.println("2. Add Posts");
        System.out.println("3. Add Friends");
        System.out.println("4. Back");
        System.out.println("5. Sign Out");

        System.out.print("Enter your entertainment choice: ");
        int currentUserEntertainmentChoice = scanner.nextInt();

        if (currentUserEntertainmentChoice == 1) {
            new Status().createStory(currentUserId);
        } else if (currentUserEntertainmentChoice == 2) {
            new Feed().createFeed(currentUserId);
        } else if (currentUserEntertainmentChoice == 3) {
            new Collegue().makePartners(currentUserId);
        } else if (currentUserEntertainmentChoice == 4) {
            Router.displayRouters(currentUserId);
        } else if (currentUserEntertainmentChoice == 5) {
            FacebookDriver.facebookManageEngine();
        } else {
            System.out.println("In-valid entertainment choice...");
        }
    }
}
