package com.bridgelabz.database;

import java.sql.*;

public class MySqlDB {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_servicedb", "root", "Himanshi@12345");
            Statement statement = con.createStatement();
            System.out.println("Connection done!");
            String query = "select * from employee_payroll;";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getString("gender") + " | " + rs.getString("phone_number") + " | "
                        + rs.getString("address") + " | " + rs.getString("department") + " | " + rs.getDouble("salary") + " | " + rs.getDouble("deduction") + " | "
                        + rs.getDouble("taxablePay") + " | " + rs.getDouble("netPay") + " | " + rs.getDouble("incomeTax") + " | " + rs.getDate("start"));
            }
            statement.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("exception" + e);
        }
    }
}

