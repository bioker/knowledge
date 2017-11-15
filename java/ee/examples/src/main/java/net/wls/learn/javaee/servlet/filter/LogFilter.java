package net.wls.learn.javaee.servlet.filter;

import javax.servlet.*;
import java.io.IOException;

public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LogFilter initialization");
        String testParam = filterConfig.getInitParameter("testParam");
        System.out.println("test parameter: " + testParam);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String ipAddress = request.getRemoteAddr();
        System.out.println("ip address: " + ipAddress);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("LogFilter destroying");
    }
}
