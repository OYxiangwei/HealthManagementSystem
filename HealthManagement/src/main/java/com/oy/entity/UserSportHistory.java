package com.oy.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Date;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class UserSportHistory {
    private int id;
    private int userId;
    private Sport sport;
    private int sportTime;
    private Date collectDate;

    public UserSportHistory() {
    }

    public UserSportHistory(int userId, Sport sport, int sportTime, Date collectDate) {
        this.userId = userId;
        this.sport = sport;
        this.sportTime = sportTime;
        this.collectDate = collectDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public int getSportTime() {
        return sportTime;
    }

    public void setSportTime(int sportTime) {
        this.sportTime = sportTime;
    }

    public Date getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
    }

    @Override
    public String toString() {
        return "UserSportHistory{" +
                "id=" + id +
                ", userId=" + userId +
                ", sport=" + sport +
                ", sportTime=" + sportTime +
                ", collectDate=" + collectDate +
                '}';
    }
}
