package com.softserv.todolist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/usertest?usessl=false";
    private static final String USER = "root";
    private static final String PASS = "123456";
    private static DBConnection dbConnection;
    private Connection connection = null;

    public static DBConnection getInstance() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
            return dbConnection;
        } else {

            return dbConnection;
        }
    }

    private DBConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }
}
