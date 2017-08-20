# EJB Overview

+ [Back](../ORACLE_DOC.md)

## What is an EJB

+ EJB is a server-side component that encapsulates
    the business logic an application

### Benefits

+ Concentration on business logic while implementation
+ Thin client code
+ Portable components and good secondary use

### When to use

+ Application must be scalable
+ Transaction mechanism is needed
+ Application has many clients

### Types

+ Session
    + Performs a task for a client
+ Message-driven
    + Listener for a particular messaging type

## What is a Session Bean

+ Session bean encapsulates business logic that can be
    invoked programmatically by a client over local, remote
    or web service
+ Session bean is not persistent (data is not saved to a database)

### Types

+ Stateful
+ Stateless
+ Singleton

### Stateful Session Beans

+ Represent the state of a unique client session
+ Has only one client

### Stateless Session Beans

+ Represent the state of an invoke
+ Used for scalability
+ Can implement a web service

### Singleton Session Beans

+ One for the application
+ Live while application is running

### When to use

+ Stateful Session Beans
    + Interaction between the bean and client
    + There is necessary to hold information about client
        across session
    + Mediates between the client and other components of the
        application
+ Stateless Session Beans
    + Information about client isn't necessary
    + Generic task for all clients
    + Web Service implementation
+ Singleton Session Beans
    + State needs to be shared across the application
    + Share between multiple threads concurrently
    + Perform task upon application startup and shutdown
    + Web Service implementation
