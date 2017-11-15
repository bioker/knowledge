package net.wls.learn.javaee.servlet.hello;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Main extends HttpServlet {

    private String message;

    @Override
    public void init() throws ServletException {
        System.out.println("init method invoked");
        message = "Hello World!";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet method invoked");

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<h1>" + message + "</h1>");
    }

    @Override
    public void destroy() {
        System.out.println("destroy method invoked");
    }
}
