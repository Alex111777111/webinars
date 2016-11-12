package edu.javacourse.servlet;

import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UploadServlet", urlPatterns = {"/UploadServlet"}, asyncSupported=true)
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AsyncContext context = request.startAsync();
        // set up async listener
        context.addListener(new AsyncListener() {
            public void onComplete(AsyncEvent event) throws IOException {
                event.getSuppliedResponse().getOutputStream().print("Complete");

            }

            public void onError(AsyncEvent event) {
                System.out.println(event.getThrowable());
            }

            public void onStartAsync(AsyncEvent event) {
            }

            public void onTimeout(AsyncEvent event) {
                System.out.println("my asyncListener.onTimeout");
            }
        });
        ServletInputStream input = request.getInputStream();
        ReadListener readListener = new ReadListenerImpl(input, response, context);
        input.setReadListener(readListener);
    }
}
