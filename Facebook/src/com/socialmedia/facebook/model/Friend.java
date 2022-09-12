package com.socialmedia.facebook.model;
public class Friend {
    private int userId;
    private int userFriendId;
    private boolean userFriendRequestCheck;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserFriendId() {
        return userFriendId;
    }

    public void setUserFriendId(int userFriendId) {
        this.userFriendId = userFriendId;
    }

    public boolean isUserFriendRequestCheck() {
        return userFriendRequestCheck;
    }

    public void setUserFriendRequestCheck(boolean userFriendRequestCheck) {
        this.userFriendRequestCheck = userFriendRequestCheck;
    }
}
