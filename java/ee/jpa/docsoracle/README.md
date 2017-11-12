# Java Persistance API

+ [Back](../README.md)

+ [Source](https://docs.oracle.com/javaee/6/tutorial/doc/bnbpy.html)

## Introduction

+ JPA provides facility for managing relational data in Java applications
+ JPA consists of:
    + JPA API
    + Query Language
    + Criteria API
    + Object/relational mapping metadata

### Enitity

+ Enitiy is lightweight persistance domain object
    + Usually an entity represents a table in relational db
+ Requirements for entity class
    + Must be annotated with javax.persistance.Entity
    + Must have public or protected no-args constructor
    + Must not be declared final
    + Fields must be private, protected or package-private and
        can be accessed only by methods
+ Requirements for entity class fields
    + Allowed types
        + Java primitive types
        + java.lang.String
        + Serializable
            + Java primitive type wrappers
            + java.math.BigInteger
            + java.math.BigDecimal
            + java.util.Date
            + java.util.Calendar
            + java.sql.Date
            + java.sql.Time
            + java.sql.TimeStamp
            + User-defined serializable types
            + byte[]
            + Byte[]
            + char[]
            + Character[]
        + Enum
        + Other Entities and Collections of it
        + Embeddable classes
+ Collections of properties and fields
    + Collection interfaces may be used:
        + java.util.Collection
        + java.util.Set
        + java.util.List
        + java.util.Map

## Query Language

+ Query Language terminology
    + Abstract schema
        + Abstraction for database schema
        + Here is the place where query translates to SQL
    + Abstract schema type
        + Mapping between type of field or property to
            db entry
    + Backus-Naur Form
        + A notation that describes 
            the syntax of high-level languages
    + Navigation
        + The traversal of relationships
        + The navigation operator is a period ('.')
    + Path expression
        + An Expression that navigates to entity state
            or relationship field
    + State field
        + Field of entity
    + Relationship field
        + Field of entity which has type 
            of another entity
## Criteria API
## Criteria Queries
## Concurrent Access to Entity
## Second level cache
