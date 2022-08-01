package com.bridgelabz.database;

import java.sql.*;

public class MySqlDB {
    public static void main(String[] args) {
        double salary = 600000.00;
        int id = 4;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_servicedb", "root", "Himanshi@12345");
            Statement statement = con.createStatement();
            System.out.println("Connection done!");
            String query = "update employee_payroll set salary = ? WHERE id = ?;";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setDouble(1, salary);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            
            String query1 = "select * from employee_payroll;";
            ResultSet rs = statement.executeQuery(query1);
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

