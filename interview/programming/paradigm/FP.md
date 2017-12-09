# Functional Programming

## Examples of Languages

+ Lisp
+ Haskell
+ Clojure

## Pure Function / Side Effect

+ If in process of function execution 
    some outer data is used (global vars for example) 
    it makes function dirty (with Side Effect)
+ Real pure function always returns the same 
    result for the same input data
+ It can be helpful for 
    + Parallelling of application
    + Testing
    + Combination of functions
    + Debugging
    + Caching
+ It can be hard for
    + Non pure task cases (I/O for example)
    + State oriented task cases (Object Oriented domain model)

## First Class Functions

+ Function can be used as variable
    + It can be stored in variable or data structure
    + It can be passed as parameter to another function
    + It can be gotten as result of function execution

## Higher Order Function

+ Function that does at least one of the following
    + Takes one of more functions as arguments
    + Return a function as its result

## Lambda

+ An anonymous function that can be treated like a value

## Closure

+ An available value of variable in parent function 
    scope even if parent function is complete
