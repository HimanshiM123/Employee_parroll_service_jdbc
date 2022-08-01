package com.bridgelabz.database;

import java.sql.*;

public class MySqlDB {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_servicedb", "root", "Himanshi@12345");
            Statement statement = con.createStatement();
            System.out.println("Connection done!");
            String query = "SELECT SUM(salary), AVG(salary), MAX(salary), MIN(salary) FROM employee_payroll WHERE gender = 'F' GROUP BY gender;";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.println("Sum of all basic salary: " + rs.getDouble("SUM(salary)") + "\n" + "Average of all basic salary: " + rs.getDouble("AVG(salary)") + "\n" + "MIN of all basic salary: " + rs.getDouble("MIN(salary)") + "\n" + "MAX of all basic salary: " +
                        rs.getDouble("MAX(salary)"));
            }
            statement.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("exception" + e);
        }
    }
}

