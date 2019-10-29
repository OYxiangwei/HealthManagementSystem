package com.oy.entity;


import java.sql.Date;

public class User {
    private int id;
    private String name;
    private int gender;
    private int age;
    private String phone;
    private Date createTime;
    private int job;
    private String address;

    public User() {
    }

    public User(String name, int gender, int age, String phone, Date createTime, int job, String address) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.createTime = createTime;
        this.job = job;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getJob() {
        return job;
    }

    public void setJob(int job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                ", job=" + job +
                ", address='" + address + '\'' +
                '}';
    }
}
