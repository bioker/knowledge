# JSP

+ [Back](../JAVA.md)
+ [Source](http://javastudy.ru/interview/jee-jsp-questions-answers/)

## What is JSP

+ It's a static content with java code injection

## Lifecycle

+ Translation
    + JSP file parsing and java servlet code generation
+ Compilation
    + Compile result java servlet
+ Class Loading
    + Load result java servlet class
+ Instantiation
+ Initialization
+ Request processing
+ Destroy

## Comments

+ `<--This comment will be seen by client-->`
+ `<%--This comment won't be seen by client-->`

## Java code injection

+ Scriptlet
    + Used for java code execution
    + `<%...%>`
+ Expression
    + Used for out print
    + `<%=...%>`
+ Declaration
    + Used for methods and fields declaration
    + `<%!...%>`

## JSP fields

+ `out`
+ `request`
+ `response`
+ `config`
+ `application`
+ `session`
+ `javax.servlet.jsp.PageContext pageContext`
+ `page`
+ `exception`
    + Available only if page is error handler

## PageContext

+ Used for attributes storing in different scopes
    and for passing requests to another resource

## Why script elements is not prefer to use in JSP

+ JSP is view object and thus you don't need to make
    some business logic implementation here
+ We need to pass parameters to JSP with attributes and use JSP EL, JSTL
