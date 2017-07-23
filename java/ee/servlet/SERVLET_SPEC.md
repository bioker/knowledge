# Java EE Servlet 3.1 Specification

## Overview

### What is Servlet

+ Java based web component which generate dynamic content
+ Placed in special container - web server extension
+ Interact with clients with request/response paradigm

### What is Servlet Container

+ Web server extension
+ Decode MIME based requests
+ Format MIME based responses
+ Can be build into host Web server
+ Can be build into or installed to application server
+ Support HTTP protocol for request and responses
+ Can support HTTPS protocol

### An Example Algorithm

+ Client (e.g. a Web Browser) makes an HTTP request to Web Server
+ Web server received request and handed off to the servlet container
+ Servlet container determines which servlet in invoke by servlet
    configuration
+ Servlet uses the request object for getting data and all of needed
    information about request
+ Servlet performs logic it was programmed with and put all data and
    additional information to response object
+ Servlet container determine that request is proccessed and send response
    to Web server for returning to client

### Comparing Servlets with Other Technologies

+ Servlets is something like Common Gateway Interface (CGI) and Apache Modules
+ Advantages over other server extensions
    + Generally much faster than CGI because a different process model is used
    + Use standard API that is supported by many Web servers
    + All advatages of the Java programming
    + Access to the large set of APIs for the Java platform

### Relationship to Java Platform, Enterprise Edition

### Compatibility with 2.5 Specification version
