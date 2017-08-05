# Java Web Application packaging

+ [Back](../README.md)

## Types of Java application files

+ JAR
+ WAR
+ EAR

## EAR

+ Contains Java EE modules and, optionally,
    deployment descriptor
+ Deployment descriptor is an xml file
    describes the deployment settings of
    application, module or component
+ Deployment descriptor can be replaced
    by using annotations, but if it present,
    then it override annotations settings

### Structure

+ META-INF
    + Deployment descriptors
+ Web Module
+ Application Client Module
+ Resource Adapter Module
+ EJB Module

## Deployment descriptor

### Types

+ Java EE deployment descriptor
    + Defined by a Java EE specification and
        can be used with any Java EE compilant
        implementation
+ Runtime deployment descriptor
    + Implementation specific
    + Example
        + glassfish-application.xml

## Java EE module

+ Consist of one or more Java EE components and,
    optionally, component descriptors

### Types

+ EJB module
    + Contains 
        + EJB classes
    + Packed to .jar file
+ Web module
    + Contains
        + Servlet classes
        + Web files (HTML, JS, CSS, Image)
    + Packed to .war file
+ Application client module
    + Contains
        + Classes
    + Packed to .jar file
+ Resource adapter module
    + Contains
        + Java interfaces
        + Classes
        + Native Libraries
    + Packed to .rar file (Resource adapter archive)

## [EJB Packaging](EJB.md)
## [WAR Packaging](WAR.md)
## [Resources Packaging](RAR.md)
