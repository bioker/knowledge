# Collections

+ Хранилища и контейнеры для различных объектов формирующих структуру данных
+ Базовые операции
    + Добавление
    + Удаление
    + Изменение

+ Основные интерфейсы
    + List
        + Хранит упорядоченные элементы
        + ArrayList
            + Приемущество в навигации по элементам
        + Vector
            + Синхронизирован, поэтому в одном потоке работает
                медленнее других
        + LinkedList
            + Приемущество во вставке и удалении элементов
    + Set
        + Хранит неповторяющийся набор элементов
        + HashSet
            + Упорядочивает элементы по их hash значению
        + TreeSet
            + Упорядочивает элементы по их значениям
        + LinkedHashSet
            + Хранит элементы в порядке их добавления
        + SortedSet
    + Queue
        + PriorityQueue
    + Map
        + Хранит значения по ключам
        + HashTable устаревшая
        + HashMap располагает элементы по их hash значению
        + TreeMap элементы хранятся в отсортированном порядке
        + LinkedHashMap элементы хранятся в порядке вставки
    + Синхронизировать несинхронизированные коллекции можно
        методом Collections.synchronizedMap или
        Collections.synchronizedList ...

+ LinkedList vs ArrayList
    + Linked двунаправленный список
        + Используется если предполагается большое число
            операций вставки удаления
    + Array массив
        + Быстрее проходит сортировка
+ Vector vs ArrayList
    + Vector синхронизирован

+ Equals and HashCode
    + Для сравнения элементов коллекций используются методы equals() и hashcode()
    + Если переопределен метод equals то hashcode тоже должен быть переопределен
    + Если два объекта эквивалентны то их hashcode должен быть одинаковым
    + Collections
        + In List Java use equals method for check that list contains element
        + In Hash(Map|Table|Tree) Java use hashCode and equals
            + HashMap
                + Put operation 
                    + Get key hashCode
                    + Get index of array to put Node(Entry) object with key and value
                    + If array contains the same index Node, put new Node
                        as next for existing Node (LinkedList, or since 
                        Java 8 - Tree) else, just put as first Node
                        in array cell
                + Get operation
                    + Get key hashCode
                    + Get index of array element to retreive value from Node
                    + If array is Tree then use binary search for getting value else unary search
                        through array
                        + For each element use hashCode and equals 
                            for checking that element key is match and return related value 
                            if is it true

+ Map is not collection
    + List и Set это набор объектов
    + Map это набор пар ключ-значение

+ Iterator это объект для перебора элементов коллекции

+ Все коллекции из java.util реализуют интерфейс Collection,
    который, в свою очередь, расширяет интерфейс Iterable,
    в котором есть всего один метод Iterator iterator()

+ Map
    + вернуть все ключи - keySet()
    + вернуть все значения - values()
    + вернуть все пары ключ-значения - entrySet()

+ Collection to Array
    + toArray()

+ Iterable and Iterator
    + Itarable содержит один метод iterator, возвращающий Iterator
        объекта
+ Iterable Iterator ForEach
    + Мы можем использовать объекты расширяющие интерфейс Iterable
        в конструкции foreach
+ Iterator.next() without Iterator.hasNext()
    + Если следующий элемент не будет присутствовать то возникнет
        исключение - NoSuchElementException
+ Iterator.remove()
    + Может быть вызван только после next()
    + иначе - IllegalStateException()
+ Collection.remove() after Iterator getting
    + При модификации коллекции после получения итератора
        возникнет исключение - ConcurrentModificationException
+ ArrayList.elementData.lenght vs ArrayList.size()
    + elementData.lenght это размерность, которая всегда больше чем
        реальный размер
+ LinkedList
    + Двусвязный список
    + Каждый элемент хранит ссылку на предыдущий и следующий элемент

+ Время работы методов коллекций
    + contain() для LinkedList
        + O(n) время поиска пропорционально количество элементов
    + contain() для ArrayList
        + O(n)
    + add() LinkedList
        + O(n)
    + addFirst() addLast() LinkedList
        + O(1)
    + add() ArrayList
        + O(1)
        + если размероности не хватает то приходится создавать новый
            массив(размерности на 1.5 больше) а следовательно - O(n)

