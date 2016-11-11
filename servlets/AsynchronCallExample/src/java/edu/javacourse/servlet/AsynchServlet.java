package edu.javacourse.servlet;

import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AsynchServlet", urlPatterns = {"/asynch"}, asyncSupported=true)
public class AsynchServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        final AsyncContext acontext = request.startAsync();
        acontext.start(new Runnable()
        {
            public void run() {
                String param = acontext.getRequest().getParameter("param");
                HttpServletResponse response = (HttpServletResponse) acontext.getResponse();
                try {
                    System.out.println("ASYNCH CALL IS RUNNUNG");
                    Thread.sleep(3000);
                    response.getWriter().append("<h1>Asynchronous example</h1>");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                acontext.complete();
            }
        });
    }
}