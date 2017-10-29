# JPA

+ [Back](../JAVA.md)
+ [Source](http://javastudy.ru/interview/jpa-questions-answers/)

## What is JPA

+ It's specification which describe sql db 
    data manipulation through java objects
+ JPA is only specification
+ Most used implementation is Hibernate

## What is Entity

+ Persistent domain object
+ Class which can be stored in database and
    use other Entities

## Some Entity class demands

+ Must be marked by @Entity annotation or
    be described in XML JPA configuration
+ Must contains non-arguments public or protected
    constructor
+ Must be not nested
+ Can't be interface or enum
+ Can't be final
+ Can't contains final fields 
    which is used for mapping
+ Fields must be private, access 
    through getters and setters
+ Must contains primary key

## Access types

+ Field access
    + Just class fields
+ Property access
    + JavaBean style properties

## Embeddable classes

+ Class for using as field in another Entity
+ Must be marked by @Embeddable or be described
    in XML JPA configuration

## Entity attributes types

+ Primitivies and their wrappers
+ String
+ Serializable
+ enums
+ other Entities
+ Embeddable classes
+ Collections of types above

## Entity primary key types

+ Primitivies and their wrappers
+ String
+ BigDecimal and BigInteger
+ java.util.Date and java.sql.Date

+ Generated key can be only number type

## Entities relationship

+ OneToOne
+ OneToMany
+ ManyToOne
+ ManyToMany

+ Each relationship can be
    + Bidirectional
        + Each side contains link to another
    + Unidirectional

## Inheritance Mapping Strategies

+ Single table per class hierarchy
    + All data for all descendant objects 
        is stored in one table and each entry
        contains column type
    + Some entries contains null values for fields
        which not related with current type
+ Joined subclass strategy
    + All unique fields for subtypes is stored in
        other tables with primary key
+ Table per concerete class strategy
    + Each class has its own table

## EntityManager

+ Entities operations executor
    + persist
    + merge
    + remove
    + refresh
    + detach
    + lock
+ Entities getting
    + find
    + createQuery
    + createNamedQuery
    + createNativeQuery
    + contains
    + createNamedStoredProcedureQuery
    + createStoredProcedureQuery
+ Other JPA objects getting
    + getTransaction
    + getEntityManagerFactory
    + getCriteriaBuilder
    + getMetamodel
    + getDelegate
+ EntityGraph
    + createEntityGraph
    + getEntityGrpah
+ EntityManager and Entities operations
    + close
    + isOpen
    + getProperties
    + setProperty
    + clear

## Entity instance Life Cycle

+ new
    + Object is created but primary keys is not generated yet
        and it's not saved in db
+ managed
    + Primary keys is created and object is under JPA control
+ detached
    + Object is not under JPA control now
+ removed
    + Object will be removed after transaciton commit

## Persist operation in Life cycles

+ new
    + Object will change status to `managed`
        and will save to db at commit or `flush` operation
+ managed
    + Operation will be ignored however dependent entites
        can change status to `managed` if it has cascade
        annotation
+ removed
    + Object will change status to `managed`
+ detached
    + Operation will throw exception at once or at commit

## Remove operation in Life cycles

+ new
    + Operation will be ignored however dependent entites
        can change status to `removed` if it has cascade
        annotation and it has status `managed`
+ managed
    + Object will change status to `removed` and
        entry will be removed in db at commit, also
        dependent entries will be removed if it has cascade
        annotation and it has status `managed`
+ removed
    + Operation will be ignored
+ detached
    + Operation will throw exception at once or at commit

## Merge operation in Life cycles

+ new
    + Will be created new managed entity which will contains
        all data from previous entity
+ managed
    + Operation will be ignored however dependent cascade entites
        will be affected if it status is not `managed`
+ removed
    + Exception will be throwed at once or at commit
+ detached
    + Existed entity can be changed with passed data 
        or new entity will be created 

## Refresh operation in Life cycles

+ new, removed, detached
    + Exception will be throwed
+ managed
    + All changes will be pulled from db
        for current and dependent entities

## Detach operation in Life cycles

+ new, detached
    + Operation will be ignored
+ managed, removed
    + Change state to `detached` for current 
        and dependent entities
