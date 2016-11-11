package edu.javacourse.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ThirdServlet", urlPatterns = {"/third"})
public class ThirdServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getSession(false).invalidate();
        response.setContentType("text/html");
        response.getWriter().append("<h1>Session is removed - you can check it</h1>");
    }
}
