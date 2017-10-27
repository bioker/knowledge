package net.wls.test.servlet.error;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "errorHandler", urlPatterns = {"/errorHandler"})
public class ErrorHandlerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processError(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processError(req, resp);
    }

    private void processError(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Throwable throwable = (Throwable) req
                .getAttribute("javax.servlet.error.exception");
        String message = "Unknown";
        if (throwable != null) {
            message = throwable.getMessage();
        }
        Integer statusCode = (Integer) req
                .getAttribute("javax.servlet.error.status_code");
        String servletName = (String) req
                .getAttribute("javax.servlet.error.servlet_name");
        if (servletName == null) {
            servletName = "Unknown";
        }
        String requestUri = (String) req
                .getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null) {
            requestUri = "Unknown";
        }
        resp.setHeader("Content-Type", "text/html");
        resp.getWriter().println("<h1>Internal Error</h1>");
        log("print error information");
        resp.getWriter().println("<h2>throwable message: " + message + "</h2>");
        resp.getWriter().println("<h2>status code: " + statusCode + "</h2>");
        resp.getWriter().println("<h2>servlet name: " + servletName + "</h2>");
        resp.getWriter().println("<h2>request uri: " + requestUri + "</h2>");
        log("print error information complete");
    }
}
