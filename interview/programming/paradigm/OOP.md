# Object Oriented Programming

+ [Back](../PARADIGM.md)

## Terms

### Object

> Material entity with some state and pre-defined behavior.

### Class

> Non-material definition of an object. Describes what object consists of and how it behaves.

### Field

> The attribute of an object. Describes some part of object's state.

### Method

> The one of interfaces to interact with an object. Describes what client can do with it.

## Principles

### Abstraction 

> The process of excluding non-important properties from some object and focusing on
> essential characteristics related to a task. Helps to form the right class definition.

### Encapsulation 

> The process of hiding the complexity of an implementation. Providing the clear and
> understandable interface for a client. Helps to create right method definition.

### Inheritance 

> The possibility for a class to have an ancestor. The descendant class will have same
> properties and behavior as the ancestor. Helps to form the right classes hierarchy.

### Polymorphism 

> The possibility for different classes, that share a single interface, be treated with
> similar way. Allows to change the processing logic at runtime.

## Techniques

### Method Overloading (the form of Polymorphism) 

> There are several methods with the same name and
> different parameters. The compiler can determine what exactly method will be invoked based on the
> type of parameters.

### Method Overriding (the form of Polymorphism) 

> When the class that shares some interface (inherit
> some class) overrides the base behavior. The logic of processing can be changed at runtime with this
> technique by using the different type of implementations. 

## Relationships

### Inheritance 

> The object of one class is descendant of an object of another class.

### Association 

> The object of one class can be related with one or more objects of another class.

### Aggregation 

> The object of one class can own object of another class but their lifecycles are
> independent.

### Composition 

> The object of one class can own object of another class and this dependent class can
> exist only with the owner.
