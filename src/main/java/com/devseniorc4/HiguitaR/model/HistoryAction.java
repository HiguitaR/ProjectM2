package com.devseniorc4.HiguitaR.model;

import java.time.LocalDateTime;


public class HistoryAction {

    private String actDescription;
    private LocalDateTime actTime;
    private User user;

    public HistoryAction(String actDescription, User user) {
        this.actDescription = actDescription;
        this.actTime = LocalDateTime.now();
        this.user = user;

    }

    public String getActDescription() {
        return actDescription;
    }

    public void setActDescription(String actDescription) {
        this.actDescription = actDescription;
    }

    public LocalDateTime getActTime() {
        return this.actTime;
    }

    public void setActTime() {
        this.actTime = LocalDateTime.now();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "HistoryAction{" +
                "actDescription='" + actDescription + '\'' +
                ", actTime=" + actTime +
                ", user=" + user +
                '}';
    }
}
