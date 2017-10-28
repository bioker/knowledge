<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page import="java.util.Date" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
        <title>Index JSP Page</title>
    </head>
    <body>
        <%-- out object example --%>
        <h4>Hi There</h4>
        <strong>Out object class name</strong>:<%=out.getClass().getName() %>
        <br><br>
        <strong>Current Time is</strong>: <% out.print(new Date()); %>
        <br><br>

        <%-- request object example --%>
        <strong>Request object class name</strong>:<%=request.getClass().getName() %>
        <br><br>
        <strong>Request User-Agent</strong>: <%=request.getHeader("User-Agent") %>
        <br><br>

        <%-- response object example --%>
        <strong>Response object class name</strong>:<%=response.getClass().getName() %>
        <br><br>
        <%response.addCookie(new Cookie("Test","Value")); %>

        <%-- config object example --%>
        <strong>Config object class name</strong>:<%=config.getClass().getName() %>
        <br><br>
        <strong>User init param value</strong>:<%=config.getInitParameter("User") %>
        <br><br>

        <%-- application object example --%>
        <strong>Application object class name</strong>:<%=application.getClass().getName() %>
        <br><br>
        <strong>User context param value</strong>:<%=application.getInitParameter("User") %>
        <br><br>

        <%-- session object example --%>
        <strong>Session object class name</strong>:<%=session.getClass().getName() %>
        <br><br>
        <strong>User Session ID</strong>:<%=session.getId() %>
        <br><br>

        <%-- pageContext object example --%>
        <% pageContext.setAttribute("Test", "Test Value"); %>
        <strong>PageContext object class name</strong>:<%=pageContext.getClass().getName() %>
        <br><br>
        <strong>PageContext attribute</strong>: {Name="Test",Value="<%=pageContext.getAttribute("Test") %>"}
        <br><br>

        <%-- page object example --%>
        <strong>Page object class name</strong>:<%=page.getClass().getName() %>

    </body>
</html>
