// Именованные функциональные выражения
// Специально для работы с рекурсией в JavaScript существует особое расширение функциональных выражений, которое называется «Named Function Expression» (сокращённо NFE) или, по-русски, «именованное функциональное выражение».
//
// Named Function Expression
//
// Обычное функциональное выражение:
//
// var f = function(...) { /* тело функции */ };
// Именованное с именем sayHi:
//
// var f = function sayHi(...) { /* тело функции */ };
// Что же это за имя, которое идёт в дополнение к f, и зачем оно?
//
// Имя функционального выражения (sayHi) имеет особый смысл. Оно доступно только изнутри самой функции.
//
// Это ограничение видимости входит в стандарт JavaScript и поддерживается всеми браузерами, кроме IE8-.
//
// Например:
//
var f = function sayHi(name) {
  alert( sayHi ); // изнутри функции - видно (выведет код функции)
};

alert( sayHi ); // снаружи - не видно (ошибка: undefined variable 'sayHi')
// Кроме того, имя NFE нельзя перезаписать:

var test = function sayHi(name) {
  sayHi = "тест"; // попытка перезаписи
  alert( sayHi ); // function... (перезапись не удалась)
};

test();
// В режиме use strict код выше выдал бы ошибку.

// Как правило, имя NFE используется для единственной цели – позволить изнутри функции вызвать саму себя.

//
// Пример использования
//
// NFE используется в первую очередь в тех ситуациях, когда функцию нужно передавать в другое место кода или перемещать из одной переменной в другую.
//
// Внутреннее имя позволяет функции надёжно обращаться к самой себе, где бы она ни находилась.
//
// Вспомним, к примеру, функцию-факториал из задачи Вычислить факториал:

function f(n) {
  return n ? n * f(n - 1) : 1;
};

alert( f(5) ); // 120
// Попробуем перенести её в другую переменную g:

function f(n) {
  return n ? n * f(n - 1) : 1;
};

var g = f;
f = null;

alert( g(5) ); // запуск функции с новым именем - ошибка при выполнении!
// Ошибка возникла потому что функция из своего кода обращается к своему старому имени f. А этой функции уже нет, f = null.
//
// Для того, чтобы функция всегда надёжно работала, объявим её как Named Function Expression:

var f = function factorial(n) {
  return n ? n*factorial(n-1) : 1;
};

var g = f;  // скопировали ссылку на функцию-факториал в g
f = null;

alert( g(5) ); // 120, работает!
// В браузере IE8- создаются две функции
// Как мы говорили выше, в браузере IE до 9 версии имя NFE видно везде, что является ошибкой с точки зрения стандарта.
//
// …Но на самом деле ситуация ещё забавнее. Старый IE создаёт в таких случаях целых две функции: одна записывается в переменную f, а вторая – в переменную factorial.
//
// Например:

var f = function factorial(n) { /*...*/ };

// в IE8- false
// в остальных браузерах ошибка, т.к. имя factorial не видно
alert( f === factorial );
// Все остальные браузеры полностью поддерживают именованные функциональные выражения.
//
// Устаревшее специальное значение arguments.callee
// Если вы давно работаете с JavaScript, то, возможно, знаете, что раньше для этой цели также служило специальное значение arguments.callee.
//
// Если это название вам ни о чём не говорит – всё в порядке, читайте дальше, мы обязательно обсудим его в отдельной главе.
//
// Если же вы в курсе, то стоит иметь в виду, что оно официально исключено из современного стандарта. А NFE – это наше настоящее.
//
// Итого
//
// Если функция задана как Function Expression, ей можно дать имя.
//
// Оно будет доступно только внутри функции (кроме IE8-).
//
// Это имя предназначено для надёжного рекурсивного вызова функции, даже если она записана в другую переменную.
//
// Обратим внимание, что с Function Declaration так поступить нельзя. Такое «специальное» внутреннее имя функции задаётся только в синтаксисе Function Expression.
