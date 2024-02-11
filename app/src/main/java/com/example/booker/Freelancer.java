package com.example.booker;

public class Freelancer {
    String username , name , location , description ;
    String skill;
    int phoneNo , age , rate;

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Freelancer(String username, String name, String skill, String location, int age, int phoneNo, String description , int rate ) {
        this.username = username;
        this.name = name;
        this.location = location;
        this.description = description;
        this.skill = skill;
        this.phoneNo = phoneNo;
        this.age = age;
        this.rate = rate;
    }

    public Freelancer(){ }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSkills() {
        return skill;
    }

    public void setSkills(String skills) {
        this.skill = skills;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
