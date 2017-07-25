# Java Virtual Machine

## Stack Memory

+ Java Stack memory is used for execution of a thread. They
    contain method specific values that are short-lived and
    references to other objects in the heap that are getting
    referred from the method.

+ Stack memory is always referenced in LIFO (Last-In-First-Out)
    order. Whenever a method is invoked, a new block is created
    in the stack memory for the method to hold local primitive
    values and reference to other objects in the method.

+ As soon as method ends, the block becomes unused and become
    available for next method. Stack memory size is very less
    compared to Heap memory.

### Conclusion

+ Stack memory is different for each thread
+ Stack memory contains primitive variables which created
    into method, also it contains references to objects in
    heap memory which used in method
+ Stack memory works by LIFO principle
+ Stack memory is less than heap memory

## Heap Memory

+ Java Heap space is used by java runtime to allocate memory
    to Objects and JRE classes. Whenever we create any object,
    it’s always created in the Heap space.

+ Garbage Collection runs on the heap memory to free the memory
    used by objects that doesn’t have any reference. Any object
    created in the heap space has global access and can be
    referenced from anywhere of the application.

### Part of heap memory

+ Eden - place, where new created objects will be located
+ Survivor - place, where place objects, which stayed after first
    garbage collection
+ Tenured -
+ Permanent -

### Conclusion

+ Heap memory is used for objects which created by new operator
+ Heap memory is one for all threads in application
+ Heap memory is cleaned by Garbage Collector

## Garbage Collector
### Minor garbage collection
### Major garbage collection
### Full garbage collection
## Class loading
