package com.socialmedia.facebook.model;
public class Story {
    private int userId;
    private String userStoryMessage;
    private String userStoryBackgroundColor;
    private String userStoryMessageColor;
    private String userStoryCreatedTime;
    private String userStoryExpiryTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserStoryMessage() {
        return userStoryMessage;
    }

    public void setUserStoryMessage(String userStoryMessage) {
        this.userStoryMessage = userStoryMessage;
    }

    public String getUserStoryBackgroundColor() {
        return userStoryBackgroundColor;
    }

    public void setUserStoryBackgroundColor(String userStoryBackgroundColor) {
        this.userStoryBackgroundColor = userStoryBackgroundColor;
    }

    public String getUserStoryMessageColor() {
        return userStoryMessageColor;
    }

    public void setUserStoryMessageColor(String userStoryMessageColor) {
        this.userStoryMessageColor = userStoryMessageColor;
    }

    public String getUserStoryCreatedTime() {
        return userStoryCreatedTime;
    }

    public void setUserStoryCreatedTime(String userStoryCreatedTime) {
        this.userStoryCreatedTime = userStoryCreatedTime;
    }

    public String getUserStoryExpiryTime() {
        return userStoryExpiryTime;
    }

    public void setUserStoryExpiryTime(String userStoryExpiryTime) {
        this.userStoryExpiryTime = userStoryExpiryTime;
    }
}
