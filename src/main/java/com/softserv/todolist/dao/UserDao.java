package com.softserv.todolist.dao;

import com.softserv.todolist.entity.User;

import java.sql.*;

public enum UserDao {
    INSTANCE;

    public int saveUser(User user){
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "Insert into user (name, age, address, password, login) values (" +
                "?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setString(4, PasswordEncoder.INSTANCE.sha256(user.getPassword()));
            preparedStatement.setString(5, user.getLogin());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public User getUserById(int id) {
        User user = null;
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "Select * from User WHERE userID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            user = getUserByResultSet(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }



        return user;
    }

    public User getUserByLoginAndPassword(String login, String password){
        User user = null;
        PreparedStatement preparedStatement;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "Select * from User WHERE login = ? and password = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, PasswordEncoder.INSTANCE.sha256(password));
            user = getUserByResultSet(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean userValidate(String login, String password){
        User user = getUserByLoginAndPassword(login, password);
        if(user == null){
            return false;
        }else {
            return true;
        }
    }


    private User getUserByResultSet(PreparedStatement preparedStatement){
        User user = new User();
        ResultSet resultSet;
        try {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setUserId(resultSet.getInt("userID"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setAddress(resultSet.getString("address"));
                user.setPassword(resultSet.getString("password"));
                user.setLogin(resultSet.getString("login"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}