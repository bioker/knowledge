package net.wls.learn.javaee.servlet.formdata;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetUrl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>First Parameter:</h1>");
        resp.getWriter().println("<h2>" + req.getParameter("first") + "</h2>");
        resp.getWriter().println("<h1>Second Parameter:</h1>");
        resp.getWriter().println("<h2>" + req.getParameter("second") + "</h2>");
    }

}
