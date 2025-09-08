package com.devseniorc4.HiguitaR.model;

import java.time.LocalDateTime;


public class HistoryAction {

    private String actDescription;
    private LocalDateTime actTime;


    public HistoryAction(String actDescription, User user) {
        this.actDescription = actDescription;
        this.actTime = LocalDateTime.now();
    }

    public String getActDescription() {return actDescription;}

    public void setActDescription(String actDescription) {this.actDescription = actDescription;}

    public LocalDateTime getActTime() {return this.actTime;}


    @Override
    public String toString() {
        return "HistoryAction{" +
                "actDescription='" + actDescription + '\'' +
                ", actTime=" + actTime +
                '}';
    }
}
