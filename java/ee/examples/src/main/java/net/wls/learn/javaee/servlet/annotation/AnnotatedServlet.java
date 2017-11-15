package net.wls.learn.javaee.servlet.annotation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "AnnotatedServlet",
        urlPatterns = {"/annotated_servlet"},
        initParams = {
                @WebInitParam(name = "message", value = "Annotation Parameter Message Value")
        }
)
public class AnnotatedServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Hello from annotated servlet!</h1>");
        resp.getWriter().println("<h1>Message is - " + getInitParameter("message") + "</h1>");
    }
}
