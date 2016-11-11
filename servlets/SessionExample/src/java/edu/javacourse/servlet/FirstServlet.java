package edu.javacourse.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FirstServlet", urlPatterns = {"/first", "/session"})
public class FirstServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String param = request.getParameter("parameter");        
        request.getSession().setAttribute("PARAMETER", param);
        
        response.setContentType("text/html");
        response.getWriter().append("<h1>You entered parameter:" + param + "</h1>");
    }
}
