package com.demoapp.controllers;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.demoApp.Starter.MySqlConnector;
import com.demoapp.modals.Contact;
import com.demoapp.modals.Lead;
import com.demoapp.views.UserDealing;
import com.demoapp.views.UserDetail;

public class Entity {
	public void displayAddEntityOptions() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("----- Entity Choices: -----");

		while (true) {
			System.out.println("1. Lead");
			System.out.println("2. Contact");
			System.out.println("3. Customers");
			System.out.println("4. Back");

			System.out.print("Enter your add entity option: ");
			int current_user_add_entity_option = scanner.nextInt();

			if (current_user_add_entity_option == 1) {
				addLead();
			} else if (current_user_add_entity_option == 2) {
				addContact();
			} else if (current_user_add_entity_option == 3) {
				addCustomer();
			} else if (current_user_add_entity_option == 4) {
				new WelcomePage().displayManageEngineChoices();
			} else {
				System.out.println("In-valid add entity choice...");
				displayAddEntityOptions();
			}
		}
	}

	private void addLead() {
		Scanner scanner = new Scanner(System.in);
		int current_user_id = 0;

		System.out.print("Enter your name [Minimum -> 3 Chatacters to Maximum -> 50 Characters]: ");
		String current_user_name = scanner.nextLine();

		try {
			Statement statement = MySqlConnector.getInstance().createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Leads");

			while (resultSet.next()) {
				if (resultSet.getInt(1) == current_user_id) {
					current_user_id++;
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		Lead lead = new Lead();
		lead.setUser_id(current_user_id++);
		lead.setUser_name(current_user_name);
		lead.setIs_user_a_lead(0);
		createLeadCredentials(lead);
	}

	private void createLeadCredentials(Lead lead) {
		try {
			Statement statement = MySqlConnector.getInstance().createStatement();

			String insertStatement = "Insert into Leads(user_id, user_name, is_user_a_lead)" + "values('" + lead.getUser_id() + "','"
					+ lead.getUser_name() + "','"
							+ 0 + "')";
			statement.execute(insertStatement);

			System.out.println("Added as lead...");
			System.out.println("Your id is: " + lead.getUser_id());
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void addContact() {
		Scanner scanner = new Scanner(System.in);
		int current_user_id = 0;

		System.out.print("Enter your name [Minimum -> 3 Chatacters to Maximum -> 50 Characters]: ");
		String current_user_name = scanner.nextLine();

		System.out.print("Enter your email-id: ");
		String current_user_email_id = scanner.nextLine().toLowerCase();
		
		System.out.print("Enter your phone number without county code: ");
		String current_user_phone_number = scanner.nextLine();
		
		try {
			Statement statement = MySqlConnector.getInstance().createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Contacts");

			while (resultSet.next()) {
				if (resultSet.getInt(1) == current_user_id) {
					current_user_id++;
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		Contact contacts = new Contact();
		contacts.setUser_id(current_user_id++);
		contacts.setUser_name(current_user_name);
		contacts.setUser_email_id(current_user_email_id);
		contacts.setUser_phone_number(current_user_phone_number);
		contacts.setIs_user_a_customer(0);
		contacts.setIs_user_a_customer(0);
		createContactCredentials(contacts);
	}

	private void createContactCredentials(Contact contacts) {
		try {
			Statement statement = MySqlConnector.getInstance().createStatement();

			String insertStatement = "Insert into Contacts(user_id, user_name, user_email_id, user_phone_number, is_user_a_customer, is_user_in_contact_book)"
					+ "values('" + contacts.getUser_id() + "','" + contacts.getUser_name() + "','"
					+ contacts.getUser_email_id() + "','" + contacts.getUser_phone_number() + "','"
					+ contacts.getIs_user_a_customer() + "','"
							+ 0 + "')";
			statement.execute(insertStatement);
			System.out.println("Added as contact...");
			System.out.println("Your id is: " + contacts.getUser_id());
			displayAddEntityOptions();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void addCustomer() {
		Scanner scanner = new Scanner(System.in);
		
		boolean check_for_user = true;
		System.out.println("1. Add by email-id");
		System.out.println("2. Add by contact-id");

		System.out.print("Enter your add customer choice ");
		int current_user_add_customer_choice = scanner.nextInt();

		scanner.nextLine();

		if (current_user_add_customer_choice == 1) {
			System.out.print("Enter your email-id: ");
			String current_user_email_id = scanner.nextLine().toLowerCase();

			try {
				Statement statement = MySqlConnector.getInstance().createStatement();
				ResultSet resultSet = statement.executeQuery("select * from Contacts");

				while (resultSet.next()) {					
					if (resultSet.getString(3).equals(current_user_email_id) && resultSet.getInt(5) == 0) {
						String updateStatement = "UPDATE Contacts SET is_user_a_customer = " + 1 + " WHERE user_email_id = '" + current_user_email_id + "'";
						statement.execute(updateStatement);
						check_for_user = false;
						System.out.println("Successfully added as a customer...");
						break;
					} else if(resultSet.getString(3).equals(current_user_email_id) && resultSet.getInt(5) == 1) {
						check_for_user = false;
						System.out.println("Already added as a customer...");
						break;
					}
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			
			if(check_for_user) {
				System.out.println("No contact found for this email-id...");
			}
		} else if (current_user_add_customer_choice == 2) {
			System.out.print("Enter your contact-id: ");
			int current_user_contact_id = scanner.nextInt();

			try {
				Statement statement = MySqlConnector.getInstance().createStatement();
				ResultSet resultSet = statement.executeQuery("select * from Contacts");

				while (resultSet.next()) {					
					if (resultSet.getInt(1) == current_user_contact_id && resultSet.getInt(5) == 0) {
						String updateStatement = "UPDATE Contacts SET is_user_a_customer = 1 WHERE user_id = " + current_user_contact_id;
						statement.execute(updateStatement);
						check_for_user = false;
						System.out.println("Successfully added as a customer...");
						break;
					} else if(resultSet.getInt(1) == current_user_contact_id && resultSet.getInt(5) == 1) {
						check_for_user = false;
						System.out.println("Already added as a customer...");
						break;
					}
				}
				
				if(check_for_user) {
					System.out.println("No contact found for this contact-id...");
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		} else {
			System.out.println("In-valid add-customer choice...");
			addCustomer();
		}
	}

	public void displayViewEntityOptions() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("----- View Entities: -----");

		while (true) {
			System.out.println("1. Lead");
			System.out.println("2. Contact");
			System.out.println("3. Customers");
			System.out.println("4. Back");

			System.out.print("Enter your add entity option: ");
			int current_user_view_entity_option = scanner.nextInt();

			if (current_user_view_entity_option == 1) {
				new UserDetail().displayAllLeads();
			} else if (current_user_view_entity_option == 2) {
				new UserDetail().displayAllContacts();
			} else if (current_user_view_entity_option == 3) {
				new UserDetail().displayAllCustomers();
			} else if (current_user_view_entity_option == 4) {
				new WelcomePage().displayManageEngineChoices();
			} else {
				System.out.println("In-valid view entity choice...");
				displayViewEntityOptions();
			}
		}
	}

	public void doSearch() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter your keyword: ");
		String current_user_keyword = scanner.nextLine();
		
		Statement lead_statement = MySqlConnector.getInstance().createStatement();
		ResultSet lead_resultSet = lead_statement.executeQuery("SELECT * FROM Leads WHERE user_id LIKE '%" + current_user_keyword + "%' OR user_name LIKE '%" + current_user_keyword + "%';");

		System.out.println("----- From Leads -----");
		
		while (lead_resultSet.next()) {
			System.out.println(lead_resultSet.getString(2));
		}
		
		System.out.println("----------------------");
		
		Statement contact_statement = MySqlConnector.getInstance().createStatement();
		ResultSet contact_resultSet = contact_statement.executeQuery("SELECT * FROM Contacts WHERE user_id LIKE '%" + current_user_keyword + "%' OR user_name LIKE '%" + current_user_keyword + "%' OR user_email_id LIKE '%" + current_user_keyword + "%' OR user_phone_number LIKE '%" + current_user_keyword + "%';");

		System.out.println("----- From Contacts -----");
		
		while (contact_resultSet.next()) {	
			System.out.print(contact_resultSet.getString(2) + " ");
			System.out.print(contact_resultSet.getString(3) + " ");
			System.out.println(contact_resultSet.getString(4));
		}
		
		new WelcomePage().displayManageEngineChoices();
	}
	
	public void deleteEntity() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1. Lead");
		System.out.println("2. Contacts");
		System.out.println("3. Customers");
		System.out.println("4. Back");
		
		System.out.print("Enter your delete entity choice: ");
		int current_user_delete_entity_choice = scanner.nextInt();
		
		if(current_user_delete_entity_choice == 1) {
			deleteLead();
		} else if(current_user_delete_entity_choice == 2) {
			deleteContacts();
		} else if(current_user_delete_entity_choice == 3) {
			deleteCustomers();
		} else if(current_user_delete_entity_choice == 4) {
			new WelcomePage().displayManageEngineChoices();
		} else {
			System.out.println("In-valid delete entity choice...");
			deleteEntity();
		}
		
		new WelcomePage().displayManageEngineChoices();
	}

	private void deleteCustomers() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your contact-id: ");
		int current_user_contact_id = scanner.nextInt();
		
		try {
			Statement statement = MySqlConnector.getInstance().createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Contacts");

			while (resultSet.next()) {					
				if (resultSet.getInt(1) == current_user_contact_id && resultSet.getInt(5) == 1) {
					String updateStatement = "UPDATE Contacts SET is_user_a_customer = 0 WHERE user_id = " + current_user_contact_id;
					statement.execute(updateStatement);
					System.out.println("Successfully removed from customer...");
					break;
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void deleteContacts() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your contact-id: ");
		int current_user_contact_id = scanner.nextInt();
		
		try {
			Statement statement = MySqlConnector.getInstance().createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Contacts");

			while (resultSet.next()) {					
				if (resultSet.getInt(1) == current_user_contact_id && resultSet.getInt(6) == 0) {
					String updateStatement = "UPDATE Contacts SET is_user_in_contact_book = 1 WHERE user_id = " + current_user_contact_id;
					statement.execute(updateStatement);
					System.out.println("Successfully removed from contact book...");
					break;
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void deleteLead() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your contact-id: ");
		int current_user_lead_id = scanner.nextInt();
		
		try {
			Statement statement = MySqlConnector.getInstance().createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Leads");

			while (resultSet.next()) {					
				if (resultSet.getInt(1) == current_user_lead_id && resultSet.getInt(3) == 0) {
					String updateStatement = "UPDATE Leads SET is_user_a_lead = 1 WHERE user_id = " + current_user_lead_id;
					statement.execute(updateStatement);
					System.out.println("Successfully removed from leads...");
					break;
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}