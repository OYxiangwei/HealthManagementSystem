package com.oy.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Date;

public class UserIndex {
    private int id;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int userId;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int indexType;
    private int indexContent;
    private Date collectDate;

    public UserIndex() {
    }

    public UserIndex(int userId, int indexType, int indexContent, Date collectDate) {
        this.userId = userId;
        this.indexType = indexType;
        this.indexContent = indexContent;
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

    public int getIndexType() {
        return indexType;
    }

    public void setIndexType(int indexType) {
        this.indexType = indexType;
    }

    public int getIndexContent() {
        return indexContent;
    }

    public void setIndexContent(int indexContent) {
        this.indexContent = indexContent;
    }

    public Date getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
    }

    @Override
    public String toString() {
        return "UserIndex{" +
                "id=" + id +
                ", userId=" + userId +
                ", indexType=" + indexType +
                ", indexContent=" + indexContent +
                ", collectDate=" + collectDate +
                '}';
    }
}
