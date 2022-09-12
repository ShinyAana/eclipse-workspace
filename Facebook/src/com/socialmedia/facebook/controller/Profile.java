package com.socialmedia.facebook.controller;
import java.sql.SQLException;
import java.util.Scanner;

import com.socialmedia.facebook.FacebookDriver;
import com.socialmedia.facebook.view.PostAndNews;
import com.socialmedia.facebook.view.Moment;
import com.socialmedia.facebook.view.Partner;

public class Profile {
    public static void displayProfile(int currentUserId) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Update Profile");
        System.out.println("2. Friends");
        System.out.println("3. Post");
        System.out.println("4. Story");
        System.out.println("5. Back");
        System.out.println("6. Sign Out");

        System.out.print("Enter your profile choice: ");
        int currentUserProfileChoice = scanner.nextInt();

        if (currentUserProfileChoice == 1) {
            new OptionalForm().createOptionalCredentials(currentUserId);
        } else if (currentUserProfileChoice == 2) {
            new Partner().displayMyPartners(currentUserId);
        } else if (currentUserProfileChoice == 3) {
            new PostAndNews().displayMemoriesAndNews(currentUserId, true);
        } else if (currentUserProfileChoice == 4) {
            new Moment().displayMoments(currentUserId, true);
        } else if (currentUserProfileChoice == 5) {
            Router.displayRouters(currentUserId);
        } else if (currentUserProfileChoice == 6) {
            FacebookDriver.facebookManageEngine();
        } else {
            System.out.println("In-valid profile choice...");
        }
    }
}
