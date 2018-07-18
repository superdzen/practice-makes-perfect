package com.superdzen.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/TestParamServlet")
public class TestParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Step 1: set content type
        resp.setContentType("text/html");

        // Step 2: get PrintWriter
        PrintWriter out = resp.getWriter();

        // Step 3: read configuration params
        ServletContext context = getServletContext();
        String param_name1 = context.getInitParameter("param-name1");
        String param_name2 = context.getInitParameter("param-name2");

        // Step 4: generate HTML content

        out.println("<html><body>");
        out.println("param_name1 : " + param_name1);
        out.println("<br/>");
        out.println("param_name2 : " + param_name2);
        out.println("</body></html");
    }
}
