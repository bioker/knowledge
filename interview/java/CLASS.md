# Java classes

## Блоки инициализации

+ Есть статические и нестатические блоки инициализации для
    выполнения действий перед загрузкой класса или созданием
    объекта соответственно
    + Статический блок static{}
    + Нестатический блок {}

## Преобразование

+ Восходящее - от потомка к предку, приведение не требуется

+ Нисходящее - от предка к потомку, приведение требуется

## Сигнатура метода

+ Имя метода и его параметры по порядку

+ К сигнатуре НЕ относятся возвращаемое значение и выбрасываемые исключения

## Class types

### Simple Class
### Static Nested Class
### Member Inner Class
### Local Inner Class
### Anonymous Inner Class
+ Статический внутренний класс называют вложенным

+ Создаются для доступа к закрытым методам и переменным класса
    если нужна некоторая абстракция внутри только этого класса

## Class loading

+ Загрузчики классов
    + Загрузчик JVM - загружает классы из rt.jar
    + Загрузчик расширений - загружает классы из $JAVAHOME/lib/ext
    + Системный загрузчик - загружает классы из classpath

