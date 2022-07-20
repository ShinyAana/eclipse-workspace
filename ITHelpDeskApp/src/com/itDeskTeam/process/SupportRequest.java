package com.itDeskTeam.process;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SupportRequest {
	public int requestId;
	public int userId;
	public Date dateOFMsg;
	public String subject;
	public String description;

	public enum TicketStatus {
		Open, InProgress, Closed, Archived, Trashed
	};

	public String supportTechnicianName;
	TicketStatus status;

	public SupportRequest(int requestId, int userId, Date dateOFMsg, String subject, String description,
			TicketStatus status, String supportTechnicianName) {
		this.requestId = requestId;
		this.userId = userId;
		this.dateOFMsg = dateOFMsg;
		this.subject = subject;
		this.description = description;
		this.status = status;
		this.supportTechnicianName = supportTechnicianName;
	}

	public SupportRequest() {

	}

	public void newSupportRequest(int checkId, String checkName) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Subject of your request");
		String subject = input.nextLine();
		System.out.println("Describe your problem not exceeding 200 words");
		String description = input.nextLine();
		System.out.println("Enter support technician name \n1.Wilson \n2.Suji");
		String techName = input.next();
		int requestId = (int) (Math.random() * 100 + 100);
		Date msgDate = getCurrentDate();
		TicketStatus tStatus = status.Open;
		SupportRequest createRequest = new SupportRequest(requestId, checkId, msgDate, subject, description, tStatus,
				techName);
		// boolean result=createRequest.insertDetails();
		boolean success = true;
		try {
			Connection con = null;
			String sql = "INSERT INTO RequestDetails(RequestId,UserId,DateOFMsg,Subject,Description,Status,SupportTechnicianName) VALUES(?,?,?,?,?,?,?)";

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ithelpdesk?characterEncoding=latin1", "root",
					"PriyaAna");
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			con.setAutoCommit(false);
			ps.setInt(1, requestId);
			ps.setInt(2, checkId);
			ps.setDate(3, msgDate);

			ps.setString(4, subject);
			ps.setString(5, description);
			ps.setString(6, tStatus.name());
			ps.setString(7, techName);
			success = ps.execute();
			con.commit();
			ps.close();
			con.close();
			System.out.println("Request rised successfully");
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	public void viewSupportRequest(int checkId, String checkName) {
		try {

			boolean flag = false;
			Connection con = null;
			ResultSet rs = null;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ithelpdesk?characterEncoding=latin1", "root",
					"PriyaAna");
			PreparedStatement statement = con.prepareStatement("select * from RequestDetails where userId = ?");
			statement.setInt(1, checkId);
			rs = statement.executeQuery();
			System.out.println("Message details are ");
			while (rs.next()) {
				System.out.println("<Request Id               :>    " + rs.getInt(1));
				System.out.println("<Date Of Msg              :>    " + rs.getDate(3));

				System.out.println("<Subject                  :>    " + rs.getString(4));
				System.out.println("<Description              :>    " + rs.getString(5));
				System.out.println("<Status                   :>    " + rs.getString(6));
				System.out.println("<Support Technician name  :>    " + rs.getString(7));
				System.out.println();
				System.out.println();
				System.out.println();

			}
			rs.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateSupportRequest(int checkId, String checkName) {
		Scanner input = new Scanner(System.in);

		System.out.println();
		System.out.println("Enter updated subject ");
		String Subject = input.nextLine();
		System.out.println("Enter the request id you want to change details ");
		int req = input.nextInt();
		System.out.println();

		try {

			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ithelpdesk?characterEncoding=latin1", "root",
					"PriyaAna");
			PreparedStatement statement = con
					.prepareStatement("UPDATE RequestDetails SET Subject= ? where RequestId= ?");
			statement.setString(1, Subject);

			statement.setInt(2, req);
			int rs = statement.executeUpdate();
			System.out.println("Updated Successfully");
			System.out.println(rs);
			statement.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listSupportRequest(int checkId, String checkName) {
		try {

			boolean flag = false;
			Connection con = null;
			ResultSet rs = null;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ithelpdesk?characterEncoding=latin1", "root",
					"PriyaAna");
			PreparedStatement statement = con.prepareStatement("select * from RequestDetails");
			rs = statement.executeQuery();
			while (rs.next()) {
				System.out.println("<Request Id               :>    " + rs.getInt(1));
				System.out.println("<User Id                  :>    " + rs.getInt(2));
				System.out.println("<Date Of Msg              :>    " + rs.getDate(3));

				System.out.println("<Subject                  :>    " + rs.getString(4));
				System.out.println("<Description              :>    " + rs.getString(5));
				System.out.println("<Status                   :>    " + rs.getString(6));
				System.out.println("<Support Technician name  :>    " + rs.getString(7));

				System.out.println();
				System.out.println();
				System.out.println();

			}
			rs.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void changeSupportTechnician(int checkId, String checkName) {
		// TODO Auto-generated method stub

	}

	public void viewNewSupportRequest(int checkId, String checkName) {
		System.out.println("Tickets rised in your name");
		try {

			boolean flag = false;
			Connection con = null;
			ResultSet rs = null;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ithelpdesk?characterEncoding=latin1", "root",
					"PriyaAna");
			PreparedStatement statement = con
					.prepareStatement("select * from RequestDetails where SupportTechnicianName = ?");
			statement.setString(1, checkName);
			rs = statement.executeQuery();
			while (rs.next()) {
				System.out.println("<Request Id               :>    " + rs.getInt(1));
				System.out.println("<User Id                  :>    " + rs.getInt(2));
				System.out.println("<Date Of Msg              :>    " + rs.getDate(3));

				System.out.println("<Subject                  :>    " + rs.getString(4));
				System.out.println("<Description              :>    " + rs.getString(5));
				System.out.println("<Status                   :>    " + rs.getString(6));
				System.out.println();
				System.out.println();
				System.out.println();

			}
			rs.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateTicketStatus(int checkId, String checkName) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the request id you want to change status ");
		int requestId = input.nextInt();
		System.out.println("Enter ticket status \n1.In Progress \n2.Closed \n3.Archived \n4.Trashed");
		int choice = input.nextInt();
		TicketStatus tStatus = null;
		switch (choice) {
		case 1:
			tStatus = status.InProgress;
			break;
		case 2:
			tStatus = status.Closed;
			break;
		case 3:
			tStatus = status.Archived;
			break;
		case 4:
			tStatus = status.Trashed;
			break;
		default:
			System.out.println("Enter a valid choice");
			break;

		}
		try {
			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ithelpdesk?characterEncoding=latin1", "root",
					"PriyaAna");
			PreparedStatement statement = con
					.prepareStatement("UPDATE RequestDetails SET Status= ? where RequestId= ?");
			statement.setString(1, tStatus.name());
			statement.setInt(2, requestId);
			int rs = statement.executeUpdate();
			System.out.println("Updated Successfully");
			System.out.println(rs);
			statement.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void viewDeletedSupportTickets(int checkId, String checkName) {
		try {
			TicketStatus tStatus = status.Trashed;

			boolean flag = false;
			Connection con = null;
			ResultSet rs = null;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ithelpdesk?characterEncoding=latin1", "root",
					"PriyaAna");
			PreparedStatement statement = con.prepareStatement("select * from RequestDetails where Status = ?");
			statement.setString(1, tStatus.name());
			rs = statement.executeQuery();
			while (rs.next()) {
				System.out.println("<Request Id               :>    " + rs.getInt(1));
				System.out.println("<User Id                  :>    " + rs.getInt(2));
				System.out.println("<Date Of Msg              :>    " + rs.getDate(3));
				System.out.println("<Subject                  :>    " + rs.getString(4));
				System.out.println("<Description              :>    " + rs.getString(5));
				System.out.println("<Status                   :>    " + rs.getString(6));
				System.out.println();
				System.out.println();
				System.out.println();

			}
			rs.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void viewArchivedSupportTickets(int checkId, String checkName) {
		try {
			TicketStatus tStatus = status.Archived;

			boolean flag = false;
			Connection con = null;
			ResultSet rs = null;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ithelpdesk?characterEncoding=latin1", "root",
					"PriyaAna");
			PreparedStatement statement = con.prepareStatement("select * from RequestDetails where Status = ?");
			statement.setString(1, tStatus.name());
			rs = statement.executeQuery();
			while (rs.next()) {
				System.out.println("<Request Id               :>    " + rs.getInt(1));
				System.out.println("<User Id                  :>    " + rs.getInt(2));
				System.out.println("<Date Of Msg              :>    " + rs.getDate(3));
				System.out.println("<Subject                  :>    " + rs.getString(4));
				System.out.println("<Description              :>    " + rs.getString(5));
				System.out.println("<Status                   :>    " + rs.getString(6));
				System.out.println();
				System.out.println();
				System.out.println();

			}
			rs.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ticketCarryForward(int checkId, String checkName) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the technician name you want to carry forward");
		String name = input.next();
		System.out.println("Request id you want to farward");
		int id = input.nextInt();
		try {
			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ithelpdesk?characterEncoding=latin1", "root",
					"PriyaAna");
			PreparedStatement statement = con
					.prepareStatement("UPDATE RequestDetails SET SupportTechnicianName= ? where RequestId= ?");
			statement.setString(1, name);
			statement.setInt(2, requestId);
			int rs = statement.executeUpdate();
			System.out.println("Updated Successfully");
			System.out.println(rs);
			statement.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateDesSupportRequest(int checkId, String checkName) {
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println();
		System.out.println("Enter updated Description ");
		String des = input.nextLine();
		System.out.println("Enter the request id you want to change details ");
		int req = input.nextInt();

		try {

			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ithelpdesk?characterEncoding=latin1", "root",
					"PriyaAna");
			PreparedStatement statement = con
					.prepareStatement("UPDATE RequestDetails SET Description= ? where RequestId= ?");
			statement.setString(1, des);

			statement.setInt(2, req);
			int rs = statement.executeUpdate();
			System.out.println("Updated Successfully");
			System.out.println(rs);
			statement.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendMessage(int checkId, String checkName) 
	{
		/*
		 * int messageId = (int) (Math.random() * 100 + 100);
		 * 
		 * Scanner input=new Scanner(System.in);
		 * System.out.println("Enter the technician name"); String
		 * techName=input.next(); System.out.println("Enter the message"); String
		 * sendMsg=input.nextLine();
		 * 
		 * System.out.println("Enter sender name"); String sendname=input.nextLine();
		 * System.out.println("Enter request id"); int req=input.nextInt();
		 * 
		 * try { Connection con = null; String sql =
		 * "INSERT INTO messageBox(MessageId,RequestId,SenderName,ReceiverName,SentMessage,receiveMessage) VALUES(?,?,?,?,?,?)"
		 * ;
		 * 
		 * con = DriverManager.getConnection(
		 * "jdbc:mysql://localhost:3306/ithelpdesk?characterEncoding=latin1", "root",
		 * "PriyaAna"); PreparedStatement ps; ps = con.prepareStatement(sql);
		 * con.setAutoCommit(false); ps.setInt(1, messageId); ps.setInt(2, checkId);
		 * ps.setDate(3, msgDate);
		 * 
		 * ps.setString(4, subject); ps.setString(5, description); ps.setString(6,
		 * tStatus.name()); ps.setString(7, techName); success = ps.execute();
		 * con.commit(); ps.close(); con.close();
		 * System.out.println("Request rised successfully"); }
		 * 
		 * catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * 
		 */	}

}
