# Java Injection

+ [Back](../README.md)

## Resource Injection

+ It's enables you to inject any resource available in the JNDI namespace

### [Example](examples/ResourceInjection.groovy)

## Dependency Injection

+ It's enables you to define managed objects (aka manages beans)
    that you can later inject by assigning a scope to a regular class

### [Example](examples/DependencyInjection.groovy)

## Differences

|               -                     | Resource Injection | Dependency Injection|
|               -                     | ------------------ | ------------------- |
| Can Inject JNDI Resources Directly  |        yes         |         no          |
| Can Inject Regular Classes Directly |        no          |         yes         |
| Resolves By                         |   Resource name    |        Type         |
| Typesafe                            |        no          |         yes         |
