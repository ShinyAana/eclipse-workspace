package com.socialmedia.facebook;
import java.sql.SQLException;
import java.util.Scanner;

import com.socialmedia.facebook.controller.Form;

public class FacebookDriver {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("---------------------------------------------------------");
        System.out.println("***** Welcome to the book of billions of faces ..!! *****");
        System.out.println("---------------------------------------------------------");

        facebookManageEngine();
    }

    public static void facebookManageEngine() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1. Sign-Up");
            System.out.println("2. Sign-In");
            System.out.println("3. Exit");

            System.out.print("Enter your facebook manage-engine choice: ");
            int facebookManageEngineChoice = scanner.nextInt();

            if (facebookManageEngineChoice == 1) {
                new Form().signUp();
            } else if (facebookManageEngineChoice == 2) {
                new Form().signIn();
            } else if (facebookManageEngineChoice == 3) {
                try {
					MySqlConnector.connectorCloser();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                System.exit(0);
            } else {
                System.out.println("In-valid facebook manage-engine choice...");
            }
        } while (true);
    }
}
