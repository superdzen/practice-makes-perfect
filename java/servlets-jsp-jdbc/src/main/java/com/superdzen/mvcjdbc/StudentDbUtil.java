package com.superdzen.mvcjdbc;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDbUtil {

    private DataSource dataSource;

    public StudentDbUtil(DataSource theDataSource) {
        this.dataSource = theDataSource;
    }

    public List<Student> getStudents() throws Exception {

        List<Student> students = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            // get a connection
            myConn = dataSource.getConnection();

            // create sql statement
            String sql = "select * from student order by last_name";
            myStmt = myConn.createStatement();

            // execute query
            myRs = myStmt.executeQuery(sql);

            // process result set
            while (myRs.next()) {
                // retrieve data from result set row
                int id = myRs.getInt("id");
                String firstName = myRs.getString("first_name");
                String lastName = myRs.getString("last_name");
                String email = myRs.getString("email");

                // create new student object
                Student tempStudent = new Student(id, firstName, lastName, email);

                // add it to the list ob students
                students.add(tempStudent);
            }
            return students;
        } finally {
            // close JDBC objects
            close(myRs, myStmt, myConn);
        }
    }

    private void close(ResultSet myRs, Statement myStmt, Connection myConn) {
        try {
            if (myRs != null) {
                myRs.close();
            }
            if (myStmt != null) {
                myStmt.close();
            }
            if (myConn != null) {
                myConn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertStudent(Student newStudent) {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            myConn = dataSource.getConnection();

            String sql = "INSERT INTO student "
                    + "(first_name, last_name, email) "
                    + "VALUES (?,?,?)";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setString(1, newStudent.getFirstName());
            myStmt.setString(2, newStudent.getLastName());
            myStmt.setString(3, newStudent.getEmail());

            myStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null, myStmt, myConn);
        }
    }

    public Student getStudent(String theStudentId) throws Exception {
        Student theStudent = null;

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        int studentId;

        try {
            // convert student id to int
            studentId = Integer.parseInt(theStudentId);

            // get connection to database
            myConn = dataSource.getConnection();

            // create sql to get selected student
            String sql = "select * from student where id=?";

            // create prepared statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, studentId);

            // execute statement
            myRs = myStmt.executeQuery();

            // retrieve data from result set row
            if (myRs.next()) {
                String firstName = myRs.getString("first_name");
                String lastName = myRs.getString("last_name");
                String email = myRs.getString("email");

                // use the studentId during construction
                theStudent = new Student(studentId, firstName, lastName, email);
            } else {
                throw new Exception("Could not find student id: " + studentId);
            }

            return theStudent;
        } finally {
            // clean up JDBC objects
            close(myRs, myStmt, myConn);
        }

    }

    public void updateStudent(Student theStudent) throws Exception {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // get a db connection
            myConn = dataSource.getConnection();

            // create SQL update statement
            String sql = "UPDATE student SET first_name = ?, last_name= ?, email = ? WHERE id=?";
            myStmt = myConn.prepareStatement(sql);

            // prepare statement
            myStmt.setString(1, theStudent.getFirstName());
            myStmt.setString(2, theStudent.getLastName());
            myStmt.setString(3, theStudent.getEmail());
            myStmt.setInt(4, theStudent.getId());

            // execute SQL statement
            myStmt.execute();
        } catch (SQLException exp) {
            exp.printStackTrace();
        } finally {
            close(null, myStmt, myConn);
        }
    }

    public void deleteStudent(String theStudentId) {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // get a db connection
            myConn = dataSource.getConnection();

            // create SQL update statement
            String sql = "DELETE FROM student WHERE id=?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setInt(1, Integer.parseInt(theStudentId));

            // execute SQL statement
            myStmt.execute();
        } catch (SQLException exp) {
            exp.printStackTrace();
        } finally {
            close(null, myStmt, myConn);
        }
    }
}
