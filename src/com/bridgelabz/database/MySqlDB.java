package com.bridgelabz.database;

import java.sql.*;

public class MySqlDB {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_servicedb", "root", "Himanshi@12345");
            Statement statement = con.createStatement();
            System.out.println("Connection done!");
            statement.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e){
            System.out.println("exception" + e);
        }
    }
}
