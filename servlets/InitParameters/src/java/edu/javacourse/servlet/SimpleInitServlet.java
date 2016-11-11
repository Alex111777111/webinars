package edu.javacourse.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleInitServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String parameter1 = getServletConfig().getInitParameter("Parameter1");
        String parameter2 = getServletConfig().getInitParameter("Parameter2");
        
        response.setContentType("text/html");
        response.getWriter().append("<stronng>" + parameter1 + ", " + parameter2 + "</strong>");
    }

}
