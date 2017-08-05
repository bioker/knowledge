import javax.annotation.Resource
import javax.sql.DataSource
import javax.servlet.http.HttpServlet

class MyServletFieldBasedInjection extends HttpServlet {

    @Resource(name="java:comp/DefaultDataSource")
    private DataSource dataSource

    //...

}

class MyServletMethodBasedInjection extends HttpServlet {

    private DataSource dataSource

    //...

    @Resource(name="java:comp/DefaultDataSource")
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource
    }

}
