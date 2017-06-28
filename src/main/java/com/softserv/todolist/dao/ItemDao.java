package com.softserv.todolist.dao;

import com.softserv.todolist.entity.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jarki on 6/17/2017.
 */
public enum ItemDao {
    INSTANCE;

    public int saveItem(Item item) {
        PreparedStatement preparedStatement;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "Insert into item (text, state, userID) values (" +
                "?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, item.getText());
            preparedStatement.setInt(2, item.isState() ? 1 : 0);
            preparedStatement.setInt(3, item.getUserId());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Item getItemById(int id) {
        Item item = new Item();
        PreparedStatement preparedStatement;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * from item WHERE itemID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                item.setItemId(resultSet.getInt("itemId"));
                item.setText(resultSet.getString("text"));
                item.setState(resultSet.getInt("state") == 1);
                item.setUserId(resultSet.getInt("userID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    public boolean changeState(int id, boolean state) {
        int temp = 0;
        PreparedStatement preparedStatement;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql;
        if (state) {
            sql = "UPDATE item SET state ='0' WHERE itemID=?";
        } else {
            sql = "UPDATE item SET state ='1' WHERE itemID=?";
        }
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            temp = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp == 1 ? true : false;

    }

    public List<Item> getItemsByUserID(int userId) {
        List<Item> items = new ArrayList<>();
        PreparedStatement preparedStatement;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "Select * from Item WHERE userID = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Item item = new Item();
                item.setItemId(resultSet.getInt("itemId"));
                item.setText(resultSet.getString("text"));
                item.setState(resultSet.getInt("state") == 1);
                item.setUserId(resultSet.getInt("userID"));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }


    public boolean removeItemById(int id) {
        boolean result = false;
        PreparedStatement preparedStatement;
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM item WHERE itemID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate() > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
