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

## What is Message-Driven Bean

+ Allow process messages asynchronously
+ Like Event Listener but receives JMS messages instead of events
+ Can process JMS messages or other kind of messages

### Differents with Session Bean

+ Most visible difference is that clients do not access message-driven
    bean through interfaces. Message-driven bean has only a bean class

+ In several respects, it like a stateless session bean
    + Retain no data or conversational state for specific client
    + All instances are equivalent, allowing the EJB container 
        to assign a message to any instance and process requests
        concurrently
    + Can process messages from multiple clients

+ The instance variables of bean can contain some state across
    the handling of client messages, such as
    + JMS API connection
    + Database connection
    + Reference to an EJB

+ Client components do not locate message-driven beans and invoke
    them directly, instead a client accesses bean by sending messages
    to the message destination (MessageListener) which you assign
    during deployment to application server

+ Characteristics of message-driven bean
    + They execute upon receipt of single client message
    + They are invoked asynchronously
    + They are relativetly short-lived
    + They do not represent data in database, but it can access 
        and update this data
    + They can be transaction-aware
    + They are stateless

+ When message arrives the container call onMessage method of
    message-driven bean. The onMessage method cast the message to one
    of the five JMS message types and handes it.

+ All operations within the onMessage method is part of single transaction

### When to use Message-Driven Beans

+ For processing messages asynchronously, don't use session beans for it
