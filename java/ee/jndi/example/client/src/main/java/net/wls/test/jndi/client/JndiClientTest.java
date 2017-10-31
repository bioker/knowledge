package net.wls.test.jndi.client;

import net.wls.test.jndi.dao.TestModel;
import net.wls.test.jndi.dao.TestModelDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "jndiClientTest", urlPatterns = {"/jndi_client_test"})
public class JndiClientTest extends HttpServlet {

    private TestModelDAOImpl testModelDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        testModelDAO = applicationContext.getBean(TestModelDAOImpl.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html");
        resp.getWriter().println("<h1>testModels:</h1>");
        List<TestModel> testModelList = testModelDAO.findAll();
        if (testModelList == null) {
            throw new NullPointerException("test model list is null");
        }
        if (testModelList.isEmpty()) {
            resp.getWriter().println("<h2>Test model is empty</h2>");
        }
        for (TestModel testModel : testModelList) {
            resp.getWriter().println("<h2>TestModel:</h2>");
            resp.getWriter().println("<h3>id:</h3>" + testModel.getId());
            resp.getWriter().println("<h3>name:</h3>" + testModel.getName());
        }
    }
}
