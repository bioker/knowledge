// Прежде, чем мы двинемся дальше – несколько терминов, чтобы понимать, о чём речь.
//
// Операнд – то, к чему применяется оператор. Например: 5 * 2 – оператор умножения с левым и правым операндами. Другое название: «аргумент оператора».
//
// Унарным называется оператор, который применяется к одному выражению. Например, оператор унарный минус "-" меняет знак числа на противоположный:
var x = 1;

x = -x;
alert( x ); // -1, применили унарный минус
// Бинарным называется оператор, который применяется к двум операндам. Тот же минус существует и в бинарной форме:

var x = 1, y = 3;
alert( y - x ); // 2, бинарный минус

// Сложение строк, бинарный +
//
// Обычно при помощи плюса '+' складывают числа.
//
// Но если бинарный оператор '+' применить к строкам, то он их объединяет в одну:

var a = "моя" + "строка";
alert( a ); // моястрока

// Если хотя бы один аргумент является строкой, то второй будет также преобразован к строке!
//
// Причем не важно, справа или слева находится операнд-строка, в любом случае нестроковый аргумент будет преобразован. Например:

alert( '1' + 2 ); // "12"
alert( 2 + '1' ); // "21"

// Это приведение к строке – особенность исключительно бинарного оператора "+".
//
// Остальные арифметические операторы работают только с числами и всегда приводят аргументы к числу.
//
// Например:

alert( 2 - '1' ); // 1
alert( 6 / '2' ); // 3

// Преобразование к числу, унарный плюс +
//
// Унарный, то есть применённый к одному значению, плюс ничего не делает с числами:

alert( +1 ); // 1
alert( +(1 - 2) ); // -1
// Как видно, плюс ничего не изменил в выражениях. Результат – такой же, как и без него.
//
// Тем не менее, он широко применяется, так как его «побочный эффект» – преобразование значения в число.
//
// Например, когда мы получаем значения из HTML-полей или от пользователя, то они обычно в форме строк.
//
// А что, если их нужно, к примеру, сложить? Бинарный плюс сложит их как строки:

var apples = "2";
var oranges = "3";

alert( apples + oranges ); // "23", так как бинарный плюс складывает строки

// Поэтому используем унарный плюс, чтобы преобразовать к числу:

var apples = "2";
var oranges = "3";

alert( +apples + +oranges ); // 5, число, оба операнда предварительно преобразованы в числа
// С точки зрения математики такое изобилие плюсов может показаться странным. С точки зрения программирования – никаких разночтений: сначала выполнятся унарные плюсы, приведут строки к числам, а затем – бинарный '+' их сложит.


// Приоритет
//
// В том случае, если в выражении есть несколько операторов – порядок их выполнения определяется приоритетом.
//
// Из школы мы знаем, что умножение в выражении 2 * 2 + 1 выполнится раньше сложения, т.к. его приоритет выше, а скобки явно задают порядок выполнения. Но в JavaScript – гораздо больше операторов, поэтому существует целая таблица приоритетов.
//
// Она содержит как уже пройденные операторы, так и те, которые мы еще не проходили. В ней каждому оператору задан числовой приоритет. Тот, у кого число больше – выполнится раньше. Если приоритет одинаковый, то порядок выполнения – слева направо.

// Отрывок из таблицы:
//
// Приоритет	Название	Обозначение
// …	…	…
// 15	унарный плюс	+
// 15	унарный минус	-
// 14	умножение	*
// 14	деление	/
// 13	сложение	+
// 13	вычитание	-
// …	…	…
// 3	присваивание	=
// …	…	…
// Так как «унарный плюс» имеет приоритет 15, выше, чем 13 у обычного «сложения», то в выражении +apples + +oranges сначала сработали плюсы у apples и oranges, а затем уже обычное сложение.

// Присваивание
//
// Обратим внимание, в таблице приоритетов также есть оператор присваивания =.
//
// У него – один из самых низких приоритетов: 3.
//
// Именно поэтому, когда переменную чему-либо присваивают, например, x = 2 * 2 + 1 сначала выполнится арифметика, а уже затем – произойдёт присваивание =.

var x = 2 * 2 + 1;

alert( x ); // 5
// Возможно присваивание по цепочке:

var a, b, c;

a = b = c = 2 + 2;

alert( a ); // 4
alert( b ); // 4
alert( c ); // 4
// Такое присваивание работает справа-налево, то есть сначала вычислятся самое правое выражение 2+2, присвоится в c, затем выполнится b = c и, наконец, a = b.

// Оператор "=" возвращает значение
// Все операторы возвращают значение. Вызов x = выражение не является исключением.
//
// Он записывает выражение в x, а затем возвращает его. Благодаря этому присваивание можно использовать как часть более сложного выражения:

var a = 1;
var b = 2;

var c = 3 - (a = b + 1);

alert( a ); // 3
alert( c ); // 0
// В примере выше результатом (a = b + 1) является значение, которое записывается в a (т.е. 3). Оно используется для вычисления c.
//
// Забавное применение присваивания, не так ли?
//
// Знать, как это работает – стоит обязательно, а вот писать самому – только если вы уверены, что это сделает код более читаемым и понятным.

// Взятие остатка %
//
// Оператор взятия остатка % интересен тем, что, несмотря на обозначение, никакого отношения к процентам не имеет.
//
// Его результат a % b – это остаток от деления a на b.
//
// Например:

alert( 5 % 2 ); // 1, остаток от деления 5 на 2
alert( 8 % 3 ); // 2, остаток от деления 8 на 3
alert( 6 % 3 ); // 0, остаток от деления 6 на 3


// Инкремент/декремент: ++, --
//
// Одной из наиболее частых операций в JavaScript, как и во многих других языках программирования, является увеличение или уменьшение переменной на единицу.
//
// Для этого существуют даже специальные операторы:

// Инкремент ++ увеличивает на 1:

var i = 2;
i++;      // более короткая запись для i = i + 1.
alert(i); // 3
// Декремент -- уменьшает на 1:

var i = 2;
i--;      // более короткая запись для i = i - 1.
alert(i); // 1

// Важно:
// Инкремент/декремент можно применить только к переменной. Код 5++ даст ошибку.
//
// Вызывать эти операторы можно не только после, но и перед переменной: i++ (называется «постфиксная форма») или ++i («префиксная форма»).
//
// Обе эти формы записи делают одно и то же: увеличивают на 1.
//
// Тем не менее, между ними существует разница. Она видна только в том случае, когда мы хотим не только увеличить/уменьшить переменную, но и использовать результат в том же выражении.

// Например:
var i = 1;
var a = ++i; // (*)

alert(a); // 2
// В строке (*) вызов ++i увеличит переменную, а затем вернёт ее значение в a. Так что в a попадёт значение i после увеличения.
//
// Постфиксная форма i++ отличается от префиксной ++i тем, что возвращает старое значение, бывшее до увеличения.
//
// В примере ниже в a попадёт старое значение i, равное 1:

var i = 1;
var a = i++; // (*)

alert(a); // 1
// Если результат оператора не используется, а нужно только увеличить/уменьшить переменную – без разницы, какую форму использовать:

var i = 0;
i++;
++i;
alert( i ); // 2
// Если хочется тут же использовать результат, то нужна префиксная форма:

var i = 0;
alert( ++i ); // 1
// Если нужно увеличить, но нужно значение переменной до увеличения – постфиксная форма:

var i = 0;
alert( i++ ); // 0
// Инкремент/декремент можно использовать в любых выражениях
// При этом он имеет более высокий приоритет и выполняется раньше, чем арифметические операции:

var i = 1;
alert( 2 * ++i ); // 4
var i = 1;
alert( 2 * i++ ); // 2, выполнился раньше но значение вернул старое
// При этом, нужно с осторожностью использовать такую запись, потому что в более длинной строке при быстром «вертикальном» чтении кода легко пропустить такой i++, и будет неочевидно, что переменая увеличивается.
//
// Три строки, по одному действию в каждой – длиннее, зато нагляднее:

var i = 1;
alert( 2 * i );
i++;


// Побитовые операторы
//
// Побитовые операторы рассматривают аргументы как 32-разрядные целые числа и работают на уровне их внутреннего двоичного представления.
//
// Эти операторы не являются чем-то специфичным для JavaScript, они поддерживаются в большинстве языков программирования.
//
// Поддерживаются следующие побитовые операторы:

// AND(и) ( & )
// OR(или) ( | )
// XOR(побитовое исключающее или) ( ^ )
// NOT(не) ( ~ )
// LEFT SHIFT(левый сдвиг) ( << )
// RIGHT SHIFT(правый сдвиг) ( >> )
// ZERO-FILL RIGHT SHIFT(правый сдвиг с заполнением нулями) ( >>> )

// Сокращённая арифметика с присваиванием
//
// Часто нужно применить оператор к переменной и сохранить результат в ней же, например:

var n = 2;
n = n + 5;
n = n * 2;
// Эту запись можно укоротить при помощи совмещённых операторов, вот так:

var n = 2;
n += 5; // теперь n=7 (работает как n = n + 5)
n *= 2; // теперь n=14 (работает как n = n * 2)

alert( n ); // 14
// Так можно сделать для операторов +,-,*,/,% и бинарных <<,>>,>>>,&,|,^.

// Вызов с присваиванием имеет в точности такой же приоритет, как обычное присваивание, то есть выполнится после большинства других операций:

var n = 2;
n *= 3 + 5;

alert( n ); // 16  (n = 2 * 8)


// Оператор запятая
//
// Один из самых необычных операторов – запятая ','.
//
// Его можно вызвать явным образом, например:


var a = (5, 6);

alert( a );
// Запятая позволяет перечислять выражения, разделяя их запятой ','. Каждое из них – вычисляется и отбрасывается, за исключением последнего, которое возвращается.
//
// Запятая – единственный оператор, приоритет которого ниже присваивания. В выражении a = (5,6) для явного задания приоритета использованы скобки, иначе оператор '=' выполнился бы до запятой ',', получилось бы (a=5), 6.
//
// Зачем же нужен такой странный оператор, который отбрасывает значения всех перечисленных выражений, кроме последнего?
//
// Обычно он используется в составе более сложных конструкций, чтобы сделать несколько действий в одной строке. Например:


// три операции в одной строке
for (a = 1, b = 3, c = a*b; a < 10; a++) {
  ...
}
// Такие трюки используются во многих JavaScript-фреймворках для укорачивания кода.