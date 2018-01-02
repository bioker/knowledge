# Marijn Haverbeke - Eloquent JavaScript

## Introduction

### About programming

+ Art of programming is art of complexity control

+ Best practices is not panacea

#### Why programming language is important

+ Programming language allow us to extend 
    dictionary of computer and thus, teach it 
    make more complex things

#### What is JavaScript

+ JavaScript is agile language
+ Flexibility allow us to do things that 
    can be done in other strict languages

#### Code and what to do with it

+ Don't allow yourself to think that you 
    understand how code works until you haven't implemented it

### Language basics

+ Way to represent decimal number in binary format

|128| 64| 32| 16| 8 | 4 | 2 | 1 |
|---|---|---|---|---|---|---|---|
| 0 | 0 | 0 | 0 | 1 | 1 | 0 | 1 |
| 0 | +0| +0| +0| +8| +4| +0| +1| 

> = 13

#### Types and Operators

+ Number
+ String
+ Boolean
+ Object
+ Function
+ Undefined
+ Null

##### Number

+ Integer - `13, -1`
+ Float - `9.18, 2.998e8`
+ `Infinity, -Infinity`
+ `NaN`

+ Operators
    + Addition - `13 + 1`
    + Subtraction - `13 - 1`
    + Multiplying - `13 * 1`
    + Division - `13 / 1`
    + Remainder - `13 % 2`

##### String

+ `"in double quotes"`
+ `'in single quotes'`

+ Operators
    + Concatenation - `'look at ' + 'this' + ' string'`
    + Unicode comparison
        +  `'ab' < 'ac'`
        +  `'ab' <= 'ab'`

##### Boolean

+ `true`
+ `false`

+ Operators
    + And - `true && true`
    + Or - `true || false`
    + Not - `!true`

##### Object

```
{
    x: 1,
    y: 2,
    z: 3
}
```

##### Function

```
var f1 = function (){
    console.log("I'm function");
}
```

##### Undefined

```
// default value for new variable
var x;
x === undefined;
```

##### Null

```
// used to mark empty value
function findValue(arr, index){
    if(arr.length > index){
        return arr.get(index);
    } else {
        return null;
    }
}
```

#### Other operators

+ Unary
    + Type of - `typeof 'this is string'`
    + Increment 
        + Pre increment `var i = 1; console.log(++i); // 2`
        + Post increment `var i = 1; console.log(i++); // 1`
    + Decrement 
        + Pre decrement `var i = 1; console.log(--i); // 0`
        + Post decrement `var i = 1; console.log(i--); // 1`
    + Delete
        + Object `delete variable;`
        + Property `delete variable.property;`
        + Element `delete array[index];`
        + Property in `with` block - `with(variable){ delete property;}`
+ Ternary
    + Conditional - `true ? 'its true' : 'its false'`

#### Automatic types conversion

```
console.log(8 * null)
// → 0
console.log("5" - 1)
// → 4
console.log("5" + 1)
// → 51
console.log("five" * 2)
// → NaN
console.log(false == 0)
// → true
```

+ Just keep it mind

### Program Structure

+ Expression
    + Fragment of code that produces a value
+ Statement
    + One or more expressions that change something
        + Print output
        + Save input to database
        + etc
+ Variables
    + Runtime defined expressions associated with some value
+ Environment
    + Collection of variables that exist at a given time
        + Variables - part of language
        + Variables for interaction with external environment 
            (browser for example)

#### Keywords

```
break case catch class const continue debugger
default delete do else enum export extends false
finally for function if implements import in
instanceof interface let new null package private
protected public return static super switch this
throw true try typeof var void while with yield
```

#### Functions

+ Function is value with executable part of program
+ Functions can return result
    + Return max of two numbers - `Math.max(2,4)`
+ Functions can be with side effect and without it
    + Side effect function example - `alert('look at me')`
        + Execution is influencing to something external
        + Execution is dependent of something external
    + Function without side effect - `Math.max(2,4)`
        + Execution and result is not dependent 
            or influence to something external

#### Control Flow

+ Control Flow is Sequences of statements 
    that will be executed with defined order
+ How to control order of execution
    + Conditions
        + IfElse
        + Switch
    + Loops
        + For
        + While
        + DoWhile

#### Exercises

##### Triangle

```
for(var i = 0; i < 10; i++){
    var line = '#';
    for(var j = i; j > 0; j--){
        line += '#';
    }
    console.log(line);
}
```

##### FizzBuzz

```
for(var i = 1; i <= 100; i++){
    if(i % (3 * 5) == 0){
        console.log('FizzBuzz');
    } else if (i % 5 == 0){
        console.log('Buzz');
    } else if (i % 3 == 0){
        console.log('Fizz');
    } else {
        console.log(i);
    }
};
```

##### ChessBoard

```
let chessBoard = function(size){
    let line = '';
    for(var i = 1; i <= size; i++){
        for(var j = 1; j <= size; j++){
            let lineIsEven = i % 2 == 0;
            let cellIsEven = j % 2 == 0;
	    if(lineIsEven){
                if(cellIsEven){
                    line += '#';
                } else {
                    line += ' ';
                }
            } else {
                if(cellIsEven){
                    line += ' ';
                } else {
                    line += '#';
                }
            }
        }
	line += '\n';
    }
    return line;
}
```

