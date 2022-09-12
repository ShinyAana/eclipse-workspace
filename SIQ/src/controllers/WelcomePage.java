package com.demoapp.controllers;

import java.util.Scanner;

public class WelcomePage {
	public void displayManageEngineChoices() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("1. Add Entity");
		System.out.println("2. View Entities");
		System.out.println("3. Search");
		System.out.println("4. Delete Entity");
		System.out.println("5. Exit");

		System.out.print("Enter your manage-engine choice: ");
		int current_user_manage_engine_choice = scanner.nextInt();

		if (current_user_manage_engine_choice == 1) {
			new Entity().displayAddEntityOptions();
		} else if (current_user_manage_engine_choice == 2) {
			new Entity().displayViewEntityOptions();
		} else if (current_user_manage_engine_choice == 3) {
			new Entity().doSearch();
		} else if (current_user_manage_engine_choice == 4) {
			new Entity().deleteEntity();
		} else if (current_user_manage_engine_choice == 5) {
			System.out.println("Bye - Bye ..!!");
			System.exit(0);
		} else {
			System.out.println("In-valid manage-engine choice...");
			displayManageEngineChoices();
		}
	}
}