package edu.javacourse.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TextServlet", urlPatterns = {"/text"})
public class TextServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // ОЧЕНЬ ВАЖНЫЙ МОМЕНТ - надо заранее установить тип возвращаемой информации
        // чтобы броузер мог правильно его показывать. Здесь у нас будет возвращаться HTML
        response.setContentType("text/html;charset=UTF-8");
        // Теперь получаем поток символов для записи
        PrintWriter out = response.getWriter();
        try {
            // И пишем в него обычный HTML
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Hello</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet with TEXT for Java course</h1>");

            // Здесь мы вставляем ссылку на картинку, которую получаем с помощью сервлета HelloImage
            //out.println("<img src='image'/>");

            out.println("</body>");
            out.println("</html>");
        } finally {
            // И закрываем поток
            out.close();
        }
    }
}
