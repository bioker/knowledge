package net.wls.test.servlet.dispatch;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dispatchTestServlet", urlPatterns = {"/dispatchTestServlet"})
public class DispatchTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/testServlet2").include(req, resp);
        resp.addHeader("Content-Type", "text/html");
        resp.getWriter().print("<h1>Test Servlet</h1>");
    }
}
