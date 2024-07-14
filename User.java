package com.example.oopproject;
import java.util.ArrayList;
import java.util.List;

class User {
    private String username;
    private ArrayList<Media> watchedHistory;

    private String comments;

    public User() {

    }

    public User(String name) {
        this.username = name;
        this.watchedHistory = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserName() {
        return username;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public ArrayList<Media> getWatchedHistory() {
        return watchedHistory;
    }

    public void setWatchedHistory(ArrayList<Media> watchedHistory) {
        this.watchedHistory = watchedHistory;
    }

    public void addToWatchedHistory(Media media) {
        watchedHistory.add(media);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", watchedHistory=" + watchedHistory +
                ", comments='" + comments + '\'' +
                '}';
    }
}

