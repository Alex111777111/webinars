package edu.gemini.filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckFilterServlet extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet CheckFilterServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet CheckFilterServlet at " + request.getContextPath() + "</h1>");
        out.println("</body>");
        out.println("</html>");

        // При открытии строки фильтры уже не смогут писать в поток вывода
        //out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
