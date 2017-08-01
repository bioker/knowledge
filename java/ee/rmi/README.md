# Java Remote Method Invocation

## Description

+ RMI is an API for invocation of object methods which is
    runned on another JVM

+ RMI using two objects *stub* and *skeleton*

## Stub object

+ Stub is a client side representation of object which must be invoked
+ Stub is request initiator
+ How stub is works (algorithm)
    + Connection with another JVM initialization
    + Marshalling and sending parameters
    + Result waiting
    + Reading and unmarshalling result
    + Result returning

## Stub object

+ Skeleton is a server side representation of object which must be invoked
+ Skeleton recieve incoming requests
+ How stub is works (algorithm)
    + Incoming parameter reading
    + Actual method invocation
    + Result marshalling and sending back to client

## [Example](example/README.md)
