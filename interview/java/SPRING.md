# Spring

+ [Back](../JAVA.md)
+ [Questions Source](http://javastudy.ru/interview/jee-spring-questions-answers/)

## Spring is

+ Framework to make:
    + Java modules with low cohesion
    + Popular frameworks and library integration simple
+ Based on:
    + Inversion of Control principle
        + Hollywood Principle - Don't call us we'll call you 
        + Each program module knows as less as it can about other ones
        + In best case all will depend from abstractions
        + Control of program flow is delegated to special module - IoC container
    + Dependency Injection
        + Implementation of IoC
        + Each module has dependencies, Spring control injection 
            of these dependencies at runtime

## Spring advantages

+ Independent components of application
+ Ready solutions for common tasks in Java applications development
+ Good integration with other frameworks and libraries

## Dependency Injection in Spring

+ Based on two key concepts
    + JavaBeans
    + Interfaces
+ Types of Injection
    + Constructor
    + Setter

## Most important Spring modules

+ Core
+ Data Modules
    + JDBC
    + ORM
+ Transactions
+ MVC
+ Security
+ Test

## Aspect Oriented Programming

+ Approach to implement logic which must be placed in many places in application
+ Some examples of necessity for AOP
    + Logging
    + Authorization
    + Exception handling

### Key terms

#### JoinPoint

+ Places in code where additional logic can be inserted

#### Advice

+ Code to perform in JointPoint before or after

#### PointCut

+ Set of JoinPoints for performing some Advice

#### Aspect

+ Combination of Advice and PointCut
+ It give us the information where and what logic must be inserted

#### Weaving

+ Process of Advices insertion to JoinPoints
+ Can be performed by two ways
    + At compilation
    + At class loading

#### Target

+ Object which workflow is changed by AOP

#### Introduction

+ Methods or fields addition to some object without 
    necessity to implement some interface

## Spring AOP

+ Support only Proxy-based AOP
+ Can use only one JoinPoint type - Method Invocation
+ Can work only with Spring Beans

## What is Spring IoC Container

+ Preferred way to use IoC Container is Dependency Injection (DI)
+ We use DI when define what dependency is necessary in some 
    component and Spring will add it at component creation

## What is Spring Bean

+ Any application component which is controlled by Spring IoC Container

## What purposes perform a beans configuration

+ Defenition of
    + Spring Beans
    + Interceptors
    + View resolvers
    + Localization
    + etc

## How Class can become to Spring Bean

+ With xml defenition of this class
+ By Annotations
    + @Component
    + @Service
    + @Repository
    + @Controller
+ It can be returned as Bean in Java Based Configuration

## Spring Bean Scopes

+ Singleton
    + Default Type - one object for all invokes
    + Need to be careful with public methods - state is sharing between threads
+ Prototype
    + New instance for each invoke
+ Request
    + New instance for each HTTP Request
+ Session
    + New instance for each HTTP Session
+ Global-session
    + Used for global beans in Portlet apps

## Spring Bean Life cycle

+ Initialization
    + If you need to implement some additional logic, use
        + Method `init()` or @PostConstruct annotation
        + Change method setup in xml config
+ Work
+ Destroy
    + If you need to implement some additional logic, use
        + Method `destroy()` or @PreDestroy annotation
        + Change method setup in xml config

## Spring Beans Wiring

+ Types
    + byName
    + byType
    + byConstructor
    + @Autowired and @Qualifier

## Spring Bean Annotations

+ @Component
    + General type of Spring Bean
+ @Controller
    + Spring MVC component for http requests handling
    + Usually used with @RequestMapping
+ @Repository
    + Data processing component (DAO)
+ @Service
    + Like @Component but means that is business logic component

## ApplicationContext creation

+ Three ways (classes)
    + AnnotationConfigApplicationContext - Java based configuration
    + ClassPathXmlApplicationContext - xml based configuration from classpath
    + FileSystemXmlApplicationContext - xml based configuration from file system

## Spring MVC

### DispatcherServlet

+ Used for redirect HTTP request to specific Controller
+ Each servlet has its own WebApplicationContext instance 
    wich contains configuration for
    + Controllers
    + View resolvers
    + i18n
    + Authorization
    + etc
+ Bean configuration for WebApplicationContext can be pointed in web.xml
    as parameter - contextConfigLocation
    + It can contains several configurations separated by comma

### ContextLoaderListener

+ Listener for WebApplicationContext
+ Used for ApplicationContext and ServletContext binding

### Controller

+ Receive request
+ Handle request data and collect response data
+ Determine what view to use
+ Response model and view (or just view name)

### View Resolver

+ Use specific view processor by received name
+ There is many implementations of processor
+ It can be configured by beans configuration

### Exceptions Handling

+ Key interface is `HandlerExceptionResolver`
+ Default resolver for exception is `DefaultHandlerExceptionResolver`
+ Controller can contains its own exception handling logic
    + Contains method with @ExceptionHandler annotation

### Localization

+ Different messages stored in special resource bundles
+ Bundles can be gotten by ResourceBundleMessageSource 
    or ReloadableResourceBundleMessageSource configuration
+ For locale determination there is need to define LocaleResolver in configuration

### RESTful application

+ Use @RestController instead of @Controller
+ Use Jackson library to transform request data to object 
    and result object to response data
    + For using Objects as requests and response
        + @RequestBody for arguments in request mapping method
        + @ResponseBody for type of returned value
    + For additional parameters (not in http body)
        + @PathVariable - part of url path for using as value, 
            example of definition (in @RequestMapping pattern): `/someController/processRequest/{someVariable}`
        + @RequestParam - http parameter in url, like `/url?someParam=someValue`
        + @RequestHeader - http request header value

### Spring MVC Interceptors

+ It's analogy of servlet filter
+ It intercepts requests from client and process it
