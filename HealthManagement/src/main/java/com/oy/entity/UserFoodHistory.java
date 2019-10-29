package com.oy.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Date;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class UserFoodHistory {
    private int id;
    private int userId;
    private Food food;
    private int foodQuantity;
    private Date collectDate;

    public UserFoodHistory() {
    }

    public UserFoodHistory(int userId, Food food, int foodQuantity, Date collectDate) {
        this.userId = userId;
        this.food = food;
        this.foodQuantity = foodQuantity;
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

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public Date getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
    }

    @Override
    public String toString() {
        return "UserFoodHistory{" +
                "id=" + id +
                ", userId=" + userId +
                ", food=" + food +
                ", foodQuantity=" + foodQuantity +
                ", collectDate=" + collectDate +
                '}';
    }
}
