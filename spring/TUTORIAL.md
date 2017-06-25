# Tutorials point Spring tutorial

## Overview

### Spring benefits

+ Enterprise application development using POJOs without EJB
+ Modular fashion of framework
+ Integration with most popular libraries (ORM, Logging, Quartz, JEE...)
+ Testing is easier
+ Well designed architecture
+ Convenient exception handling throwed by JDBC, Hibernate and etc
+ Lightweight IoC containers

### Dependency Injection

+ Dependency Injection is merely one concrete example of Inversion of Control
+ Application classes should be as independent as possible of other Java classes
    to increase the possibility to reuse and testing
+ Dependency Injection helps gluing classes and keep them independent
+ When class A need to use class B it dependent by him, for using you need to do 
    injection - through constructor or method setter, this is called dependency injection

### Aspect Oriented Programming (AOP)

+ Cross-cutting concerns is functions which span multiple points of an application
+ Cross-cutting are conceptually separate from application business logic
+ There are good ways for implement logging, security, caching etc
+ Key unit of modularity in OOP is class, in AOP this is aspect
+ DI help you decoupe your application object form each other
+ AOP help you decoupe cross-cutting concerns from object that they affect
+ AOP help keep your code modularity

## Architecture

+ You can use spring modules separately without having to bring in the rest

### Core container

+ Core - include IoC and Dependency injection features
+ Bean - include BeanFactory for bean creation control
+ Context - include ApplicationContext for beans and core functional using
    together
+ Expression Language - provide powerful expression language for querying and
    manipulating an objects

### Data Access / Integration

+ JDBC - for more easier of work with jdbc
+ ORM - integration layers for object relational mapping APIs (JPA, JDO, Hibernate, etc)
+ OXM - integration layers for object xml mapping APIs (JAXB, Castor, XMLBeans, etc)
+ Messaging - for application based on messaging architecture 
+ Transaction - transaction api for classes that implement special interfaces and all your POJO

### Web

+ Web - provides basic web oriented integration features
+ Web-MVC - contains Spring MVC implementation
+ Web-Socket - two way communication between client and server
+ Web-Portlet - ...

### Miscellaneous

+ AOP - provides AOP implemtation allowing you to define method-interceptors and pointcuts
+ Aspects - integration with AspectJ
+ Instrumentation - instrumentation support and class loader implementations for certain
    application servers
+ Messaging - STOMP as WebSocket sub protocol to use in application
+ Test - integration with JUnit and TestNG
