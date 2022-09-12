package com.socialmedia.facebook.model;
public class Post {
    private int userId;
    private String userPost;
    private String userPostCreatedTime;
    private int totalUserPostLikes;
    private int totalUserPostComments;
    private int totalUserPostShared;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserPost() {
        return userPost;
    }

    public void setUserPost(String userPost) {
        this.userPost = userPost;
    }

    public String getUserPostCreatedTime() {
        return userPostCreatedTime;
    }

    public void setUserPostCreatedTime(String userPostCreatedTime) {
        this.userPostCreatedTime = userPostCreatedTime;
    }

    public int getTotalUserPostLikes() {
        return totalUserPostLikes;
    }

    public void setTotalUserPostLikes(int totalUserPostLikes) {
        this.totalUserPostLikes = totalUserPostLikes;
    }

    public int getTotalUserPostComments() {
        return totalUserPostComments;
    }

    public void setTotalUserPostComments(int totalUserPostComments) {
        this.totalUserPostComments = totalUserPostComments;
    }

    public int getTotalUserPostShared() {
        return totalUserPostShared;
    }

    public void setTotalUserPostShared(int totalUserPostShared) {
        this.totalUserPostShared = totalUserPostShared;
    }
}
