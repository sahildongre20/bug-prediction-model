package com.accio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    static Connection connection = null;
    public static Connection getConnection(){
        if(connection!=null){
            return connection;
        }
        String user = "root";
        String pwd = "admin";
        String db = "jdbc:mysql://localhost:3306/searchengineapp";
        return getConnection(db,user,pwd);
    }
    private static Connection getConnection(String db, String user,String pwd){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(db, user, pwd);
        }
        catch (SQLException | ClassNotFoundException sqlException){
            sqlException.printStackTrace();
        }
        return connection;
    }
}