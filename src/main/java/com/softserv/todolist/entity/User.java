package com.softserv.todolist.entity;


public class User {
    private int userId;
    private String name;
    private int age;
    private String address;
    private String password;
    private String login;
    private String role;

    public User(String name, int age, String address, String password, String login, String role) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.password = password;
        this.login = login;
        this.role = role;
    }

    public User(String name, int age, String address, String password, String login) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.password = password;
        this.login = login;
    }

    public User() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
