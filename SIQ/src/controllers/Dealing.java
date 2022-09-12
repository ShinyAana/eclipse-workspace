package com.demoapp.controllers;

import java.sql.Statement;
import java.util.Scanner;

import com.demoApp.Starter.MySqlConnector;
import com.demoapp.views.UserDealing;
import com.demoapp.views.UserDetail;

public class Dealing {
	public void displayDealingChoices(int current_user_id) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("1. Add Deals");
		System.out.println("2. View Deals");
		System.out.println("3. Delete Deal");
		System.out.println("4. Back");

		System.out.print("Enter your dealing choice: ");
		int current_user_dealing_choice = scanner.nextInt();

		if (current_user_dealing_choice == 1) {
			addDealing(current_user_id);
		} else if (current_user_dealing_choice == 2) {
			new UserDealing().displayCustomerDealing();
		} else if (current_user_dealing_choice == 3) {
			deleteDealing(current_user_id);
		} else if (current_user_dealing_choice == 4) {
			new Entity().displayViewEntityOptions();
		} else {
			System.out.println("In-valid dealing choice...");
			displayDealingChoices(current_user_id);
		}
	}

	private void addDealing(int current_user_id) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter your estimated sales: ");
		double current_user_estimated_sales_amount = scanner.nextDouble();
		
		try {
			Statement statement = MySqlConnector.getInstance().createStatement();

			String insertStatement = "Insert into Deals(user_id, user_estimated_sales_amount)" + "values('" + current_user_id + "','"
					+ current_user_estimated_sales_amount + "')";
			statement.execute(insertStatement);

			System.out.println("Your deal is added successfully...");
			new UserDealing().displayCustomerDealing();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void deleteDealing(int current_user_id) {
		Scanner scanner = new Scanner(System.in);
		new UserDealing().displayCustomerDealing();
		
		System.out.print("Enter your sales-id: ");
		int current_user_estimated_sales_id = scanner.nextInt();
		
		try {
            Statement statement = MySqlConnector.getInstance().createStatement();
            
            String delteStatement = "DELETE FROM Deals" + " WHERE user_estimated_sales_id = " + current_user_estimated_sales_id;
            statement.executeUpdate(delteStatement);
            
            System.out.println("Successfully deleted your deal..!!");
            new UserDealing().displayCustomerDealing();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
	}
}