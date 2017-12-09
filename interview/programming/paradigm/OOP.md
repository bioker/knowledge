# Object Oriented Programming

+ [Back](../PARADIGM.md)

## Principles

### Abstraction

+ Определение значимых свойств объекта и исключение не значимых

### Encapsulation

+ Сокрытие сложности реализации, представляя необходимый интерфейс

### Inheritance

+ Определение общих свойств и методов для потомков

### Polymorphism

+ Один интерфейс - множество методов (для разных классов)

+ Динамическое связывание
    + Используя вызов интерфейса мы можем во время выполнения
        менять поведение, подставляя нужную реализацию

## Relationship

### Inheritance(Is a)

+ When class must have all behavior of another (maybe with changes - redefinition)

### Association(Has a)

+ Relationship between classes - one two one, one to many, etc

#### Composition

+ Часть не может существовать самостоятельно (создается внутри объекта контейнера)

#### Aggregation

+ Часть может существовать самостоятельно (передается как параметр конструктора или через сеттер)
