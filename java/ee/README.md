# Java EE

+ [Back](../README.md)

## Java EE purposes

+ Get some information from remote machine or vice versa (Basic network)
+ Work with some database (JDBC)
+ Provide service via Web server (Servlets and JSP)
+ Execute methods of java objects on remote machine
+ Integrate with another languages (Web Services)
+ Isolate business logic from connectivity issues - 
    database connection, transactions, security (EJB)

## Java EE Web Application request handling

+ *Client* send *Http request*
+ Java Web application transform *Http request* to *HttpSerlvetRequest*
+ Java Web application *Web components* process *HttpServletRequest*
    + *Web components* can be
        + Java Servlet
        + Java Server Faces web page
        + Web Service
        + Java Server Page
+ *Web components* can use *Database* and *Java Beans* 
+ *Java Beans* also can use *Database*
+ *Web components* prepare *HttpServletResponse* for answer to client
+ Java Web application transform *HttpServletResponse* to *Http response*
+ *Client* recieve *Http response*


## [Injection](injection/README.md)
## [Packaging](package/README.md)
## [Java Networking](net/README.md)
## [Java Database Connectivity](jdbc/README.md)
## [Servlets](servlet/README.md)
## [Java Server Pages](jsp/README.md)
## [Java Remote Method Invocation](rmi/README.md)
## [Enterprise Java Beans](ejb/README.md)
## [Java Persistance API](jpa/README.md)
## [Web Services](webservices/README.md)
## [Tomcat](tomcat/README.md)
## [Spring](spring/README.md)
## [Hibernate](hibernate/README.md)
