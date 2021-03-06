# Spring Documentation

+ [Back](README.md)

## Part I. Overview of Spring Framework

+ Это легковесное решение для веб приложений
+ Засчет модульной архитектуры к проекту подключается только то что нужно
+ Предполагает изолированность от бизнес логики приложения

### 1. Getting Started with Spring

+ Если обучение Spring только начинается то лучше будет начать с Spring Boot
+ Spring Boot направлен на скорость создания приложения

### 2. Introduction to the Spring Framework

+ Spring это фреймворк с обширным функционалом, который помогает разрабатывать
    веб приложения, фокусируясь на задачах приложения а не технических деталях
+ Spring позволяет разрабатывать приложения используя подход POJO к проектированию
    классов
+ Некоторые приемущества
    + Создавать метод выполняющийся в транзакции бд без использования transaction api
    + Создавать методы для выполнения по HTTP без использования Servlet API
    + Создавать методы для обработки сообщений без использования JMS API
    + Создавать методы управления выполнением без использования JMX API

#### 2.1 Dependency Injection and Inversion of Control

+ В любом java приложении логика построена на компонентах-классах
+ Между компонентами существуют различного рода зависимости
+ Платформа Java оставляет разработчикам выбор архитектуры приложения
+ Обычно для построения архитектуры используют шаблоны проектирования
+ Для решения проблем с построением архитектуры был придуман принцип
    инверсии зависимости
+ "The question is, what aspect of control are [they] inverting?" Martin Fowler posed this question
    about Inversion of Control (IoC) on his site in 2004. Fowler suggested renaming the principle to
    make it more self-explanatory and came up with Dependency Injection.

#### 2.2 Framework Modules

+ Spring состоит из функций организованных примерно в 20 модулей
+ Примерная структура модулей
    + Data Access/Integration
        + JDBC
        + ORM
        + OXM
        + JMS
        + Transactions
    + Web
        + WebSocket
        + Servlet
        + Web
        + Proflet
    + AOP
    + Aspects
    + Instrumentation
    + Messaging
    + Core
        + Beans
        + Core
        + Context
        + SpEL
    + Test

##### 2.2.1 Core Container

+ Состоит из
    + spring-core
    + spring-beans
    + spring-context
    + spring-context-support
    + spring-expression

+ Модули spring-core и spring-beans являются центром фреймворка,
    влючают функционал для Dependency Injection
+ BeanFactory это сложная реализация шаблона фабрика, позволяет
    избежать использования синглтонов, отделить конфигурацию и
    спецификацию от реальной логики приложения
+ Context (spring-context) это средство для предоставления доступа к объектам,
    аналогичное реестру JNDI
+ Context модуль наследует функционал доступа к объектам от Beans
    и добавляет к этому поддержку интернационализации, распространение событий
    загрузку ресурсов и создание контекстов (например Servlet Container)
+ Context модуль также поддерживает Java EE функции такие как EJB, JMX и т.п.
+ ApplicationContext это точка взаимодействия с Context модулем
+ Модуль spring-context-support предоставляет возможность интеграции сторонних
    библиотек в Spring приложение для кеширования (EhCache, Guava, JCache),
    отправки почты (JavaMail), выполнения заданий по расписанию (CommonJ, Quartz)
    и шаблонизаторам (FreeMarker, JasperReports, Velocity)
+ Модуль spring-expression предоставляет мощный язык выражений запросов и 
    управлением объектами. Это расширение unified expression language, который
    состоит в спецификации JSP 2.1. 
    + Язык предоставляет 
        + считывать и записывать значения свойств
        + инициализировать свойства 
        + внедрять методы 
        + получать доступ к данным в коллекциях и массивах
        + вычислять логические и арифметические операторы
        + именнованные переменные
        + получать доступ к объектам по имени из IoC контейнера
        + прозрачную выборку и проекцию списков

##### 2.2.2 AOP and Instrumentation

+ Модуль spring-aop предоставляет реализацию аспектно-ориентированного
    программирования помогающюю к примеру реализовывать методы перехватчики
    (Interceptors) и Pointcuts? для ослабления зависимостей между частями кода
    которые должны быть разделены. Используя source-level metadata функционал
    можно объеденять информацию о поведеднии кода так же как в .NET атрибутах
+ Модуль spring-aspects module предоставляет интеграцию с AspectJ
+ Модуль spring-instrument предоставляет функционал для работы непосредственно
    с классами и их загрузкой (Classloaging)
+ Модуль spring-instrument-tomcat содержит инструменты для работы с tomcat

##### 2.2.3 Messaging

+ Модуль spring-messaging предоставляет абстракцию для создания приложений
    архитектура которых базируется на обмене сообщениями

##### 2.2.4 Data Access/Integration

+ Содержит модули для работы с технологиями
    + JDBC
    + ORM
    + OXM
    + JMS
    + Transactions
+ Модуль spring-jdbc - абстракция для работы с jdbc
    + К примеру убирает необходимость написания обработчиков кодов ошибок
        разных баз данных
+ Модуль spring-tx предоставляет функционал для управления транзакциями над
    всеми POJO классами которые реализуют специальный интерфейс
+ Модуль spring-orm предоставляет интеграцию с популярными ORM технологиями
    + такими как
        + JPA
        + JDO
        + Hibernate
    + Используя этот модуль можно использовать ORM технологии всвязке с другими
        модулями Spring, например с spring-tx
+ Модуль spring-oxm предоставляет интеграцию с известными ObjectXmlMapping
    технологиями
    + такими как
        + JAXB
        + Castor
        + XMLBeans
        + JiBX
        + XStream
+ Модуль spring-jms для поддержки Java Messaging Service, с версии 4.1 это
    предоставляется в модуле spring-messaging

##### 2.2.5 Web

+ Содержит модули
    + spring-web
    + spring-webmvc
    + spring-websocket
    + spring-webmvc-proflet
+ Модуль spring-web содержит базовый, веб ориентированный функционал, такой как
    загрузка файлов из разных директорий и инициализация IoC контейнера используя
    Servlet listeners и web ориентированный application context
    + Так же содержит http клиент и части Spring для удаленного управления
+ Модуль spring-webmvc (Web Servlet) содержит реализации MVC и REST для веб
    приложений. MVC предоставляет чистую domain модель отдельно от web форм
    и предоставляет интеграцию с другими Spring модулями
+ Модуль spring-webmvc-proflet используется для отображения Proflet? среды на
    webmvc модуль

##### 2.2.6 Test

+ Интеграция с Unit и Integration тестированием поддерживая JUnit и TestNG
    + Предоставляет возможность тестировать ApplicationContext и пр.


