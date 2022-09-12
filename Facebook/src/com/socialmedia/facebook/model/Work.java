package com.socialmedia.facebook.model;
public class Work {
    private int userId;
    private String userOrganization;
    private String userDesignation;
    private String userCity;
    private String userWorkDescription;
    private String userWorkJoinedDate;
    private String userReleivingDate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserOrganization() {
        return userOrganization;
    }

    public void setUserOrganization(String userOrganization) {
        this.userOrganization = userOrganization;
    }

    public String getUserDesignation() {
        return userDesignation;
    }

    public void setUserDesignation(String userDesignation) {
        this.userDesignation = userDesignation;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserWorkDescription() {
        return userWorkDescription;
    }

    public void setUserWorkDescription(String userWorkDescription) {
        this.userWorkDescription = userWorkDescription;
    }

    public String getUserWorkJoinedDate() {
        return userWorkJoinedDate;
    }

    public void setUserWorkJoinedDate(String userWorkJoinedDate) {
        this.userWorkJoinedDate = userWorkJoinedDate;
    }

    public String getUserReleivingDate() {
        return userReleivingDate;
    }

    public void setUserReleivingDate(String userReleivingDate) {
        this.userReleivingDate = userReleivingDate;
    }
}
