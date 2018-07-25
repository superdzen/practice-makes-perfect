package com.superdzen.mvcjdbc;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {

    private StudentDbUtil studentDbUtil;

    @Resource(name = "jdbc/web_student_tracker")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        // create our student db util and pass it to the conn pool/datasource
        try {
            studentDbUtil = new StudentDbUtil(dataSource);
        } catch (Exception exc) {
            throw new ServletException();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // list the students in MVC fashion
        try {
            // read the command parameter
            String theCommand = request.getParameter("command");

            // route to the appropriate method
            if (theCommand == null) {
                theCommand = "LIST";
            }
            switch (theCommand) {
                case "LIST":
                    listStudents(request, response);
                    break;
                case "LOAD":
                    loadStudent(request, response);
                    break;
                case "UPDATE":
                    updateStudent(request, response);
                    break;
                case "DELETE":
                    deleteStudent(request, response);
                    break;
                default:
                    listStudents(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // read the command parameter
            String theCommand = req.getParameter("command");

            // route to the appropriate method
            if (theCommand == null) {
                theCommand = "LIST";
            }
            switch (theCommand) {
                case "ADD":
                    addStudent(req, resp);
                    break;
                default:
                    listStudents(req, resp);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // read student id from form date
        String theStudentId = request.getParameter("studentId");

        // perform delete on database
        studentDbUtil.deleteStudent(theStudentId);

        // sent them back to the "list student" page
        listStudents(request, response);
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // read student info from form date
        int id = Integer.parseInt(request.getParameter("studentId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        // create a new student object
        Student theStudent = new Student(id, firstName, lastName, email);

        // perform update on database
        studentDbUtil.updateStudent(theStudent);

        // sent them back to the "list student" page
        listStudents(request, response);
    }

    private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // read student id from from data
        String theStudentId = request.getParameter("studentId");

        // get student from database
        Student theStudent = studentDbUtil.getStudent(theStudentId);

        // place student in the request attribute
        request.setAttribute("THE_STUDENT", theStudent);

        // send to JSP page: mvcjdbc-update-student.jsp
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/mvcjdbc-update-student-form.jsp");
        dispatcher.forward(request, response);
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // read  student info from from data
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        // create a new student object
        Student newStudent = new Student(firstName, lastName, email);

        // add the student to the database
        studentDbUtil.insertStudent(newStudent);

        // send back to main page (the student list)
        response.sendRedirect(request.getContextPath() + "/StudentControllerServlet?command=LIST");
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // get students from db util
        List<Student> students = studentDbUtil.getStudents();

        // add students to the request
        request.setAttribute("STUDENT_LIST", students);

        // send to JSP page (view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("mvcjdbc-list-students.jsp");
        dispatcher.forward(request, response);
    }


}
