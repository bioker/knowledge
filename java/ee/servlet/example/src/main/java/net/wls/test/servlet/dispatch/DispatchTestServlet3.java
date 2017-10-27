package net.wls.test.servlet.dispatch;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dispatchTestServlet3", urlPatterns = {"/dispatchTestServlet3"})
public class DispatchTestServlet3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/dispatchTestServlet4").forward(req, resp);
        resp.addHeader("Content-Type", "text/html");
        resp.getWriter().print("<h1>Test Servlet3</h1>");
    }
}
