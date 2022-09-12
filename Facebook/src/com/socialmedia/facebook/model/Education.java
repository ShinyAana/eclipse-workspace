package com.socialmedia.facebook.model;
public class Education {
    private int userId;
    private String userInstitution;
    private String userInstitutionJoinedDate;
    private String userInstitutionReleivedDate;
    private String userStudiesBackground;
    private String userInstitutionCity;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserInstitution() {
        return userInstitution;
    }

    public void setUserInstitution(String userInstitution) {
        this.userInstitution = userInstitution;
    }

    public String getUserInstitutionJoinedDate() {
        return userInstitutionJoinedDate;
    }

    public void setUserInstitutionJoinedDate(String userInstitutionJoinedDate) {
        this.userInstitutionJoinedDate = userInstitutionJoinedDate;
    }

    public String getUserInstitutionReleivedDate() {
        return userInstitutionReleivedDate;
    }

    public void setUserInstitutionReleivedDate(String userInstitutionReleivedDate) {
        this.userInstitutionReleivedDate = userInstitutionReleivedDate;
    }

    public String getUserStudiesBackground() {
        return userStudiesBackground;
    }

    public void setUserStudiesBackground(String userStudiesBackground) {
        this.userStudiesBackground = userStudiesBackground;
    }

    public String getUserInstitutionCity() {
        return userInstitutionCity;
    }

    public void setUserInstitutionCity(String userInstitutionCity) {
        this.userInstitutionCity = userInstitutionCity;
    }
}
