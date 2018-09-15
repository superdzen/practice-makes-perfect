package com.superdzen.testjdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/TestJdbcServlet")
public class TestJdbcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = "springuser";
        String password = "springuser";
        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";

        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            PrintWriter printWriter = resp.getWriter();

            printWriter.print("Connection to " + jdbcUrl);

            Class.forName(driver);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);

            printWriter.println(" ... Success!");

            myConn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ServletException();
        }

    }
}
