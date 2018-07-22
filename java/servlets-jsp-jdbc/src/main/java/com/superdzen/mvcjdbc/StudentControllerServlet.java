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
            listStudents(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
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
