package org.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionBuilder implements ConnectionBuilder{

    public DbConnectionBuilder(){
        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        String url =  "jdbc:postgresql://localhost:5432/dealDB";
        String login = "omegalul";
        String password = "newpassword";
        return DriverManager.getConnection(url, login, password);
    }
}