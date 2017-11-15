package net.wls.learn.javaee.servlet.exception;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorHandler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer statusCode = (Integer) req.getAttribute("javax.servlet.error.status_code");
        Class exceptionClass = (Class) req.getAttribute("javax.servlet.error.exception_type");
        Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception");
        String errorMessage = (String) req.getAttribute("javax.servlet.error.message");
        String requestUri = (String) req.getAttribute("javax.servlet.error.request_uri");
        String servletName = (String) req.getAttribute("javax.servlet.error.servlet_name");

        resp.getWriter().println("<h1>Error info:</h1>");
        resp.getWriter().println("<p>statusCode: " + statusCode + "</p>");
        resp.getWriter().println("<p>exceptionClass: " + exceptionClass + "</p>");
        resp.getWriter().println("<p>statusCode: " + statusCode + "</p>");
        resp.getWriter().println("<p>statusCode: " + statusCode + "</p>");
        resp.getWriter().println("<p>statusCode: " + statusCode + "</p>");
        resp.getWriter().println("<p>statusCode: " + statusCode + "</p>");
        resp.getWriter().println("<p>statusCode: " + statusCode + "</p>");
    }
}