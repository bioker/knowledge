# Java Servlet

+ [Back](../JAVA.md)
+ [Source](http://javastudy.ru/interview/jee-servlet-api-questions)

## What is servlet

+ Servlet is request-response processor

## Web project structure

+ src/main/java
+ src/main/resources
+ src/main/filters
+ src/main/webapp
+ src/test/java
+ src/test/resources
+ src/test/filters
+ src/it
+ src/assembly
+ src/site
+ LICENCE.txt
+ NOTICE.txt
+ README.txt

## What is servlets container

+ Program for servlets maintenance
+ Most known implementations
    + Apache Tomcat
    + Jetty

## What purposes has servlets container

+ It can work as standalone web server
+ Web pages provider for other web servers (Apache for example)
+ It can be integrated into application server (JBoss, Glassfish for example)
+ Client authentication and authorization with sessions

## What you know about servlet filters

+ Servlet filter is used for request preparation 
    before it will be passed to servlet
+ Features
    + To intercept servlet initialization before it begins
    + Determine request content before servlet initialization
    + Change request headers and data
    + Change response headers and data
+ Lifecycle
    + `void init(FilterConfig config)` - one time
    + `void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)`
        - every request
    + `void destroy()` - one time

## For what we need Listeners

+ For session or context initialization interception
+ For session or context destroy interception
+ For session or context attributes changes interception

## How to process exceptions in servlets

+ Redirect to spectial page with code below

```
<error-page>
    <error-code>404</error-code>
    <location>/AppExceptionHandler</location>
</error-page>

<error-page>
    <exception-type>javax.servlet.ServletException</exception-type>
    <location>/AppExceptionHandler</location>
</error-page>
```

## What is assembly descriptor

+ Config file in artifact which is used by servlets container
    for servlets setup

## How to launch servlet on application startup

+ Use `loadOnStartup` annotation or `load-on-startup` tag

```
<servlet>
    <servlet-name>foo</servlet-name>
    <servlet-class>com.foo.servlets.Foo</servlet-class>
    <load-on-startup>5</load-on-startup>
</servlet>
```

+ Parameter has int type, if value is smaller than 0 then servlet will
    be started on user request, else, servlet will be start on startup
    in order of queue with priority which set by parameter value

## What is servlet config

+ This is object which is created for each servlet 
    and stores configuration parameters
+ Config parameters can be passed by init 
    tags in web.xml or WebInitParam annotation

## What is servlet context

+ This is singleton for all servlets
+ There is can be stored parameters for several servlets
+ Parameters can be set by context-param tags in web.xml

## Differences between ServletConfig and ServletContext

+ Config is created for each servlet meanwhile 
    Context is single for application
+ Config is servelt configuration meanwhile
    Context is application configuration
+ Config parameters can't be set meanwhile
    Context allows it

## Whait is request dispatcher

+ It's interface which provide facility of dispatching the request
    to another resource (html, jsp or servlet)
+ Methods
    + `public void forward(ServletRequest request, ServletResponse response)`
        + Forward processing to another resource
    + `public void include(ServletRequest request, ServletResponse response)`
        + Includes the response from another resource to current
