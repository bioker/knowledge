// Конструкция switch
// Конструкция switch заменяет собой сразу несколько if.
//
// Она представляет собой более наглядный способ сравнить выражение сразу с несколькими вариантами.
//
// Синтаксис
//
// Выглядит она так:
//
// switch(x) {
//   case 'value1':  // if (x === 'value1')
//     ...
//     [break]
//
//   case 'value2':  // if (x === 'value2')
//     ...
//     [break]
//
//   default:
//     ...
//     [break]
// }
// Переменная x проверяется на строгое равенство первому значению value1, затем второму value2 и так далее.
// Если соответствие установлено – switch начинает выполняться от соответствующей директивы case и далее, до ближайшего break (или до конца switch).
// Если ни один case не совпал – выполняется (если есть) вариант default.
// При этом case называют вариантами switch.
//
// Пример работы
//
// Пример использования switch (сработавший код выделен):

var a = 2 + 2;

switch (a) {
  case 3:
  alert( 'Маловато' );
  break;
  case 4:
  alert( 'В точку!' );
  break;
  case 5:
  alert( 'Перебор' );
  break;
  default:
  alert( 'Я таких значений не знаю' );
}
// Здесь оператор switch последовательно сравнит a со всеми вариантами из case.
//
// Сначала 3, затем – так как нет совпадения – 4. Совпадение найдено, будет выполнен этот вариант, со строки alert('В точку!') и далее, до ближайшего break, который прервёт выполнение.
//
// Если break нет, то выполнение пойдёт ниже по следующим case, при этом остальные проверки игнорируются.
//
// Пример без break:

var a = 2 + 2;

switch (a) {
  case 3:
  alert( 'Маловато' );
  case 4:
  alert( 'В точку!' );
  case 5:
  alert( 'Перебор' );
  default:
  alert( 'Я таких значений не знаю' );
}
// В примере выше последовательно выполнятся три alert:

alert( 'В точку!' );
alert( 'Перебор' );
alert( 'Я таких значений не знаю' );
// В case могут быть любые выражения, в том числе включающие в себя переменные и функции.
//
// Например:

var a = 1;
var b = 0;

switch (a) {
  case b + 1:
  alert( 1 );
  break;

  default:
  alert('нет-нет, выполнится вариант выше')
}
// Группировка case
//
// Несколько значений case можно группировать.
//
// В примере ниже case 3 и case 5 выполняют один и тот же код:

var a = 2+2;

switch (a) {
  case 4:
  alert('Верно!');
  break;

  case 3:                    // (*)
  case 5:                    // (**)
  alert('Неверно!');
  alert('Немного ошиблись, бывает.');
  break;

  default:
  alert('Странный результат, очень странный');
}
// При case 3 выполнение идёт со строки (*), при case 5 – со строки (**).
//
// Тип имеет значение
//
// Следующий пример принимает значение от посетителя.

var arg = prompt("Введите arg?")
switch (arg) {
  case '0':
  case '1':
  alert( 'Один или ноль' );

  case '2':
  alert( 'Два' );
  break;

  case 3:
  alert( 'Никогда не выполнится' );

  default:
  alert('Неизвестное значение: ' + arg)
}
// Что оно выведет при вводе числа 0? Числа 1? 2? 3?
//
// Подумайте, выпишите свои ответы, исходя из текущего понимания работы switch и потом читайте дальше…
//
// При вводе 0 выполнится первый alert, далее выполнение продолжится вниз до первого break и выведет второй alert('Два'). Итого, два вывода alert.
// При вводе 1 произойдёт то же самое.
// При вводе 2, switch перейдет к case '2', и сработает единственный alert('Два').
// При вводе 3, switch перейдет на default. Это потому, что prompt возвращает строку '3', а не число. Типы разные. Оператор switch предполагает строгое равенство ===, так что совпадения не будет.