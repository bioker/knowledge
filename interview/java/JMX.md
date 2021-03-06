# JMX

+ Java Management Extensions
+ API для контроля удаленных приложений
+ Ресурсы предоставляются MBean(управляемый Java Bean)

+ Выгоды
    + Простота реализации
        + Архитектура основана на понятии "сервер управляемых объектов"
    + Масштабируемость
        + Службы агентов JMX устанавливаются в виде plug-in ов
        + Компонетная система
    + Возможность расширения
    + Концентрация на управлении приложениями

+ Features
    + Event notification позволяет MBean компонентам общаться друг с другом
        а так же с сервером управления, передавая свое состояние
    + Monitor Service
    + Timer Service посылает уведомления с учетом временного промежутка
    + M-let Service может создавать и регистрировать экземпляры MBean
        серверов
        + Список MBean компонентов и имен из классов определяются в m-let
            файле с помощью MLET меток

+ MBean
    + Java объекты которые реализуют определенный интерфейс
    + у этих объектов могут быть
        + поля
        + методы
        + извещения
        + конструкторы
    + типы
        + Standard MBeans
            + Самые простые бины, их управляющий интерфейс
                определяется набором методов
        + Dynamic MBeans
            + Реализуют специализированные интерфейс
                который делает их доступными во время выполнения
        + Open MBeans
            + Dynamic MBeans, которые используют только основные
                типы данных для универсальности использования
        + Model MBeans
            + Dynamic MBeans, которые полностью конфигурируемы и
                могут показать свое описание во время исполнения,
                что то вроде reflection
+ MBean server
    + Реестр объектов MBean
    + Не дает прямых ссылок
    + Регистрировать MBean могут
        + Другой MBean
        + Сам агент
        + Удаленное приложение через сервисы
    + При регистрации дается уникальное имя, по которому будет осуществлен
        доступ

