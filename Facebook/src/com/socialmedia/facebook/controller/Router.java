package com.socialmedia.facebook.controller;
import java.sql.SQLException;
import java.util.Scanner;

import com.socialmedia.facebook.FacebookDriver;

public class Router {
    public static void displayRouters(int currentUserId) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Profile");
        System.out.println("2. Entertainment");
        System.out.println("3. Back");

        System.out.print("Enter your choice: ");
        int currentUserRouterChoice = scanner.nextInt();

        if(currentUserRouterChoice == 1) {
            Profile.displayProfile(currentUserId);
        } else if (currentUserRouterChoice == 2) {
            new Entertainment();
            Entertainment.displayEntertainment(currentUserId);
        } else if (currentUserRouterChoice == 3) {
            FacebookDriver.facebookManageEngine();
        } else {
            System.out.println("In-valid router choice..!!");
        }
    }
}
