package com.superdzen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {

        String jdbcURL = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
        String user = "hbstudent";
        String password = "hbstudent";

        System.out.println("Testing connection to DB " + jdbcURL);
        try (Connection connection = DriverManager.getConnection(jdbcURL, user, password);) {
            System.out.println("Connection established.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
