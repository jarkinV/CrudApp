package com.softserv.todolist.dto;


public class UserDto {
    private int userId;
    private String name;
    private int age;
    private String address;

    public UserDto() {
    }

    public UserDto(int userId, String name, int age, String address) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
