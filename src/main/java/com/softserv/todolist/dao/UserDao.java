package com.softserv.todolist.dao;

import com.softserv.todolist.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public enum UserDao {
    INSTANCE;

    public int saveUser(User user){
        PreparedStatement preparedStatement;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "Insert INTO user (name, age, address, password, login, role) values (" +
                "?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setString(4, PasswordEncoder.INSTANCE.sha256(user.getPassword()));
            preparedStatement.setString(5, user.getLogin());
            preparedStatement.setString(6, "Role_user");
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void removeUserById(int id){
        PreparedStatement preparedStatement;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM user WHERE userID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public User getUserById(int id) {
        User user = null;
        PreparedStatement preparedStatement;
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

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        Statement statement;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM User;";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userID"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setAddress(resultSet.getString("address"));
                user.setLogin(resultSet.getString("login"));
                user.setRole(resultSet.getString("role"));
                users.add(user);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return users;
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
                user.setRole(resultSet.getString("role"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}