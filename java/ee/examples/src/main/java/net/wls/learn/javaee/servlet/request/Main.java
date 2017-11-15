package net.wls.learn.javaee.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class Main extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        resp.getWriter().println("<h1>Attributes:</h1>");
        Enumeration<String> attributes = req.getAttributeNames();
        while (attributes.hasMoreElements()) {
            String attributeName = attributes.nextElement();
            resp.getWriter().println("<p>" + attributeName + ": " + req.getAttribute(attributeName) + "</p>");
        }

        resp.getWriter().println("<h1>Headers:</h1>");
        Enumeration<String> headers = req.getHeaderNames();
        while (headers.hasMoreElements()) {
            String headerName = headers.nextElement();
            resp.getWriter().println("<p>" + headerName + ": " + req.getHeader(headerName) + "</p>");
        }

        resp.getWriter().println("<h1>Other:</h1>");
        resp.getWriter().println("<p>authType: " + req.getAuthType() + "</p>");
        resp.getWriter().println("<p>contextPath: " + req.getContextPath() + "</p>");
        resp.getWriter().println("<p>method: " + req.getMethod() + "</p>");
        resp.getWriter().println("<p>pathInfo: " + req.getPathInfo() + "</p>");
        resp.getWriter().println("<p>remoteAddr: " + req.getRemoteAddr() + "</p>");
        resp.getWriter().println("<p>localAddr: " + req.getLocalAddr() + "</p>");
        resp.getWriter().println("<p>characterEncoding: " + req.getCharacterEncoding() + "</p>");
        resp.getWriter().println("<p>pathTranslated: " + req.getPathTranslated() + "</p>");

        resp.getWriter().println("<h1>Cookies:</h1>");
        for (Cookie cookie : req.getCookies()) {
            resp.getWriter().println("<ul>");
            resp.getWriter().println("<li>name: " + cookie.getName() + "<li>");
            resp.getWriter().println("<li>value: " + cookie.getValue() + "<li>");
            resp.getWriter().println("<li>comment: " + cookie.getComment() + "<li>");
            resp.getWriter().println("<li>path: " + cookie.getPath() + "<li>");
            resp.getWriter().println("<li>domain: " + cookie.getDomain() + "<li>");
            resp.getWriter().println("<li>maxAge: " + cookie.getMaxAge() + "<li>");
            resp.getWriter().println("<li>secure: " + cookie.getSecure() + "<li>");
            resp.getWriter().println("<li>version: " + cookie.getVersion() + "<li>");
            resp.getWriter().println("</ul>");
        }

    }
}
