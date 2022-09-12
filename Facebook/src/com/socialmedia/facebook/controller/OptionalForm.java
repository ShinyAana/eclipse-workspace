package com.socialmedia.facebook.controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Scanner;

import com.socialmedia.facebook.MySqlConnector;
import com.socialmedia.facebook.model.Address;
import com.socialmedia.facebook.model.Education;
import com.socialmedia.facebook.model.RelationShip;
import com.socialmedia.facebook.model.Work;

public class OptionalForm {
    Statement statement;
    ResultSet resultSet;

    public void createOptionalCredentials(int currentUserId) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Work");
        System.out.println("2. Education");
        System.out.println("3. Relationship");
        System.out.println("4. Address");

        System.out.print("Enter your creator choice: ");
        int currentUserCreatorChoice = scanner.nextInt();

        if (currentUserCreatorChoice == 1) {
            createWorkProfile(currentUserId);
        } else if (currentUserCreatorChoice == 2) {
            createEducationProfile(currentUserId);
        } else if (currentUserCreatorChoice == 3) {
            createRelationShipProfile(currentUserId);
        } else if (currentUserCreatorChoice == 4) {
            createAddressProfile(currentUserId);
        } else {
            System.out.println("Invalid creator choice...");
            Profile.displayProfile(currentUserId);
        }
    }

    private void createAddressProfile(int currentUserId) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your city: ");
        String currentUserPresentAddress = scanner.nextLine();

        System.out.print("Enter your present address moved on date as (yyyy-mm-dd hh:mm:ss): ");
        String currentUserPresentAddressMovedOnDate = scanner.nextLine();

        System.out.print("Enter your present address releving date as (yyyy-mm-dd hh:mm:ss): ");
        String currentUserPresentAddressReleivingDate = scanner.nextLine();

        Address address = new Address();
        address.setUserId(currentUserId);
        address.setUserCurrentCity(currentUserPresentAddress);
        address.setUserCurrentCityMovedInDate(currentUserPresentAddressMovedOnDate);
        address.setUserCurrentCityMovedOutDate(currentUserPresentAddressReleivingDate);

        executeAddressDetails(address);
        createOptionalCredentials(currentUserId);
    }

    private void createRelationShipProfile(int currentUserId) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your relationship status: ");
        String currentSUerRelationShipStatus = scanner.nextLine();

        int currentUserPartnerId = currentUserId;

        if (currentSUerRelationShipStatus.equals("love") || currentSUerRelationShipStatus.equals("marriage")) {
            try {
                statement = MySqlConnector.getInstance().createStatement();
                resultSet = statement.executeQuery("select * from Users");

                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1));
                    System.out.print("Is this your partner? (true / false): ");
                    boolean currentUserRelationShipPartnerChoice = scanner.nextBoolean();
                    scanner.nextLine();

                    if (currentUserRelationShipPartnerChoice) {
                        currentUserPartnerId = resultSet.getInt(1);
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.print("Enter your relationship start date as (yyyy-mm-dd hh:mm:ss): ");
            String currentSUerRelationShipStartDate = scanner.nextLine();
            Timestamp.valueOf(currentSUerRelationShipStartDate);

            RelationShip relationShip = new RelationShip();
            relationShip.setUserId(currentUserId);
            relationShip.setUserRelationShipStatus(currentSUerRelationShipStatus);
            relationShip.setUserPartnerId(currentUserPartnerId);
            relationShip.setUserRelationshipStartDate(currentSUerRelationShipStartDate);

            executeRelationShipDetails(relationShip);
        } else {
            Timestamp timestamp = Timestamp.from(Instant.now());

            RelationShip relationShip = new RelationShip();
            relationShip.setUserId(currentUserId);
            relationShip.setUserRelationShipStatus(currentSUerRelationShipStatus);
            relationShip.setUserPartnerId(currentUserPartnerId);
            relationShip.setUserRelationshipStartDate(timestamp.toString());

            executeRelationShipDetails(relationShip);
        }

        createOptionalCredentials(currentUserId);
    }

    private void createEducationProfile(int currentUserId) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your institution: ");
        String currentUserInstitution = scanner.nextLine();

        System.out.print("Enter your institution city: ");
        String currentUserInstitutionCity = scanner.nextLine();

        System.out.print("Enter your education description: ");
        String currentUserEducationDescription = scanner.nextLine();

        System.out.print("Enter your institution joining date as (yyyy-mm-dd hh:mm:ss): ");
        String currentUserInstitutionJoiningDate = scanner.nextLine();

        System.out.print("Enter your institution releving date as (yyyy-mm-dd hh:mm:ss): ");
        String currentUserInstitutionRelevingDate = scanner.nextLine();

        Education education = new Education();
        education.setUserId(currentUserId);
        education.setUserInstitution(currentUserInstitution);
        education.setUserInstitutionCity(currentUserInstitutionCity);
        education.setUserStudiesBackground(currentUserEducationDescription);
        education.setUserInstitutionJoinedDate(currentUserInstitutionJoiningDate);
        education.setUserInstitutionReleivedDate(currentUserInstitutionRelevingDate);

        executeEducationDetails(education);
        createOptionalCredentials(currentUserId);
    }

    private void createWorkProfile(int currentUserId) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your organization: ");
        String currentUSerOrganization = scanner.nextLine();

        System.out.print("Enter your designation: ");
        String currentUserDesignation = scanner.nextLine();

        System.out.print("Enter your work city: ");
        String currentUserWorkCity = scanner.nextLine();

        System.out.print("Enter your work description: ");
        String currentUserWorkDescription = scanner.nextLine();

        System.out.print("Enter your work joining date as (yyyy-mm-dd hh:mm:ss): ");
        String currentUserWorkJoiningDate = scanner.nextLine();

        System.out.print("Enter your work releiving date as (yyyy-mm-dd hh:mm:ss): ");
        String currentUserWorkReleivingDate = scanner.nextLine();

        Work work = new Work();
        work.setUserId(currentUserId);
        work.setUserOrganization(currentUSerOrganization);
        work.setUserDesignation(currentUserDesignation);
        work.setUserCity(currentUserWorkCity);
        work.setUserWorkDescription(currentUserWorkDescription);
        work.setUserWorkJoinedDate(currentUserWorkJoiningDate);
        work.setUserReleivingDate(currentUserWorkReleivingDate);

        executeWorkDetails(work);
        createOptionalCredentials(currentUserId);
    }

    private void executeAddressDetails(Address address) {
        try {
            statement = MySqlConnector.getInstance().createStatement();
            Timestamp timestamp = Timestamp.valueOf(address.getUserCurrentCityMovedInDate());
            Timestamp timestamp1 = Timestamp.valueOf(address.getUserCurrentCityMovedOutDate());

            String insertStatement = "Insert into Address(currentUserId, currentUserLivingCity, currentUserCityFromDate, currentUserCityToDate)"
                    + "values('"
                    + address.getUserId() + "','"
                    + address.getUserCurrentCity() + "','" + timestamp + "','"
                    + timestamp1
                    + "')";
            statement.execute(insertStatement);
            System.out.println("Successfully updated address details...");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void executeRelationShipDetails(RelationShip relationShip) {
        try {
            statement = MySqlConnector.getInstance().createStatement();
            Timestamp timestamp = Timestamp.valueOf(relationShip.getUserRelationshipStartDate());

            String insertStatement = "Insert into Relationships(currentUserId, currentUserRelationshipStatus, currentUserReationshipPartnerId, currentUserRelationShipFromDate)"
                    + "values('"
                    + relationShip.getUserId() + "','"
                    + relationShip.getUserRelationShipStatus() + "','" + relationShip.getUserPartnerId() + "','"
                    + timestamp
                    + "')";
            statement.execute(insertStatement);
            System.out.println("Successfully updated relationship details...");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void executeEducationDetails(Education education) {
        try {
            statement = MySqlConnector.getInstance().createStatement();
            Timestamp timestamp = Timestamp.valueOf(education.getUserInstitutionJoinedDate());
            Timestamp timestamp1 = Timestamp.valueOf(education.getUserInstitutionReleivedDate());

            String insertStatement = "Insert into Education(currentUserId, currentUserInstitution, currentUserEducationCity, currentuserEducationDescription, currentUserEducationFromDate, currentUserEducationToDate)"
                    + "values('"
                    + education.getUserId() + "','"
                    + education.getUserInstitution() + "','" + education.getUserInstitutionCity() + "','"
                    + education.getUserStudiesBackground() + "','"
                    + timestamp + "','"
                    + timestamp1
                    + "')";
            statement.execute(insertStatement);
            System.out.println("Successfully updated education details...");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void executeWorkDetails(Work work) {
        try {
            statement = MySqlConnector.getInstance().createStatement();
            Timestamp timestamp = Timestamp.valueOf(work.getUserWorkJoinedDate());
            Timestamp timestamp1 = Timestamp.valueOf(work.getUserReleivingDate());

            String insertStatement = "Insert into Works(currentUserId, currentUserOrganization, currentUserDesignation, currentUserWorkCity, currentUserWorkDescription, currentUserWorkJoiningDate, currentUserRelevingDate)"
                    + "values('"
                    + work.getUserId() + "','"
                    + work.getUserOrganization() + "','" + work.getUserDesignation() + "','"
                    + work.getUserCity() + "','" + work.getUserWorkDescription() + "','"
                    + timestamp + "','"
                    + timestamp1
                    + "')";
            statement.execute(insertStatement);
            System.out.println("Successfully updated work details...");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
