# EJB Packaging

+ [Back](README.md)

+ EJB JAR is portable and can be used for various
    applications
+ EJB JAR can be deployed within EAR file
+ EJB JAR can be deployed as standalone module

## EJB JAR structure

+ META-INF
    + ejb-jar.xml
    + glassfish-ejb-jar.xml
    + MANIFEST.MF
+ Class files

## EJB JAR with WAR file

+ EJB JAR can be deployed within WAR file
    + Java classes in WEB-INF/classes
    + JAR file in WEB-INF/lib
+ WAR with EJB do not require ejb-jar.xml
    + If ejb-jar.xml is needed then it must be
        located in the WEB-INF
+ EJB JAR and classes into WAR file can be used
    only in this WAR
