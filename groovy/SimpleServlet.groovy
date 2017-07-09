#!/usr/bin/env groovy
@Grab(group='org.eclipse.jetty', module='jetty-server', version='9.2.11.v20150529')
@Grab(group='org.eclipse.jetty', module='jetty-servlet', version='9.2.11.v20150529')

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.ServletContextHandler
import org.eclipse.jetty.http.HttpStatus

import java.io.IOException
import java.util.Scanner

import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class ExampleServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                        throws ServletException, IOException {
                Scanner scanner = new Scanner(System.in)
                println 'enter response: '
                String response = scanner.nextLine();
                resp.setStatus(HttpStatus.OK_200)
                resp.getWriter().println(response)
        }
}

Server server = new Server(9900)
ServletContextHandler handler = new ServletContextHandler(server, "/example")
handler.addServlet(ExampleServlet.class, "/")
server.start()

println 'start'
