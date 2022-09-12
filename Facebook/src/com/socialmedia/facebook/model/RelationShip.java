package com.socialmedia.facebook.model;
public class RelationShip {
    private int userId;
    private String userRelationShipStatus;
    private int userPartnerId;
    private String userRelationshipStartDate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserRelationShipStatus() {
        return userRelationShipStatus;
    }

    public void setUserRelationShipStatus(String userRelationShipStatus) {
        this.userRelationShipStatus = userRelationShipStatus;
    }

    public int getUserPartnerId() {
        return userPartnerId;
    }

    public void setUserPartnerId(int userPartnerId) {
        this.userPartnerId = userPartnerId;
    }

    public String getUserRelationshipStartDate() {
        return userRelationshipStartDate;
    }

    public void setUserRelationshipStartDate(String userRelationshipStartDate) {
        this.userRelationshipStartDate = userRelationshipStartDate;
    }
}
