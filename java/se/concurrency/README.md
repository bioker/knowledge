# Java Concurrency

+ [Back](../README.md)

## Basics

### Process 

+ Has it's own 
    + System resources
    + Memory space
+ Communicate with Inter Process Communication (IPC)
    + Pipes
    + Sockets
+ Contains at least one thread

### Threads

+ Creation requires fewer resources than Process
+ Share memory space with other threads in process

## Thread Objects

+ In Java Thread can be created with
    + Thread class object instantiate
    + Passing task to executor

### Defining and Starting a Thread

+ Implement Runnable interface
+ Extend Thread class
+ [Examples](examples/DefineAndStart.groovy)

### Pausing Execution

+ Thread can be paused by `Thread.sleep()`
+ Thread can be interrupted while paused
+ [Example](examples/Sleep.groovy)

## Synchronization
## Thread transitions
