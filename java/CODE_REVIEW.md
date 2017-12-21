# Java Code Review

## Common

+ [ ] Intention revealing names
+ [ ] Use domain oriented names
+ [ ] Small classes and methods
+ [ ] Avoid duplication
+ [ ] Avoid implicit behavior or explain it
+ [ ] One style code formatting
+ [ ] Exceptions instead return codes
+ [ ] Avoid null returning

## General

+ [ ] Make class final and immutable when it possible
+ [ ] Minimize local variables scope
+ [ ] Refer to object by interfaces 
    (List instead of ArrayList for example)
+ [ ] Avoid finalizers
+ [ ] Override hashCode and equals only together
+ [ ] Use enum instead of int constants
+ [ ] Synchronize access to shared mutable data
+ [ ] Use executors and tasks with threads
+ [ ] Take configuration parameters out of application code
+ [ ] Create Unit tests

## Security

+ [ ] Restricted privileges for application
+ [ ] Minimal necessary access level for classes, methods and fields
+ [ ] Client input validation about size and content
+ [ ] Release resources (Streams, Connections and etc)
+ [ ] Don't let sensitive information be uncovered while exception occurs 
    (file paths, system, configuration)
+ [ ] Don't log security information
+ [ ] Avoid dynamic SQL, use PreparedStatement
+ [ ] Use wrappers for native methods (don't make it public)
+ [ ] Avoid using static non final fields
+ [ ] Avoid serialization for security data classes

## Performance

+ [ ] Keep synchronized blocks small
+ [ ] Beware the performance of string concatenation
+ [ ] Reuse objects when it possible 
    (with flyweight pattern for example)
+ [ ] Avoid storing references to short lived objects
    in long lived ones
+ [ ] Avoid bad SQL, RegExp and etc expressions

## Exceptions

+ [ ] Use checked exceptions for recoverable conditions
    and runtime exceptions for programming errors
+ [ ] Don't ignore exceptions
