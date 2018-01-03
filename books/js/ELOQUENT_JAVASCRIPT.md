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

## Language basics

+ Way to represent decimal number in binary format

|128| 64| 32| 16| 8 | 4 | 2 | 1 |
|---|---|---|---|---|---|---|---|
| 0 | 0 | 0 | 0 | 1 | 1 | 0 | 1 |
| 0 | +0| +0| +0| +8| +4| +0| +1| 

> = 13

### Types and Operators

+ Number
+ String
+ Boolean
+ Object
+ Function
+ Undefined
+ Null

#### Number

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

#### String

+ `"in double quotes"`
+ `'in single quotes'`

+ Operators
    + Concatenation - `'look at ' + 'this' + ' string'`
    + Unicode comparison
        +  `'ab' < 'ac'`
        +  `'ab' <= 'ab'`

#### Boolean

+ `true`
+ `false`

+ Operators
    + And - `true && true`
    + Or - `true || false`
    + Not - `!true`

#### Object

```
{
    x: 1,
    y: 2,
    z: 3
}
```

#### Function

```
var f1 = function (){
    console.log("I'm function");
}
```

#### Undefined

```
// default value for new variable
var x;
x === undefined;
```

#### Null

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

### Other operators

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

### Automatic types conversion

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

## Program Structure

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

### Keywords

```
break case catch class const continue debugger
default delete do else enum export extends false
finally for function if implements import in
instanceof interface let new null package private
protected public return static super switch this
throw true try typeof var void while with yield
```

### Functions

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

### Control Flow

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

### Exercises

#### Triangle

```
for(var i = 0; i < 10; i++){
    var line = '#';
    for(var j = i; j > 0; j--){
        line += '#';
    }
    console.log(line);
}
```

#### FizzBuzz

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

#### ChessBoard

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

## Functions

+ Functions application is decomposition of code

### Definition

+ Function can be defined as variable (type will be `object`)

```
var square = function(x){
    return x * x;
}
```

+ Definition contains
    + Variable name for further using
    + Keyword `function`
    + Set of parameters in parenthesis
    + Body of function in braces

### Parameters and Scopes

+ JS use call-by-sharing strategy for passing parameters
    + Parameters with simple type will be copies of passed variables
    + Parameters with type `object` will be references
        + If change reference then real variable will not be changed
        + If you'll change property of object it will affect real variable
+ Variables declared by `var` can be used only inside function 
    where it was declared
+ Variables declared by `let` can be used only inside `{}` block
    + If you declare `var` variable inside `if` block in function it will be
        accessible in next sentences even after `if` block. When you use `let`
        for declaring this variable will be accessible only in `if` block
+ Variables declared outside any function is global (can be used anywhere)
+ Global variables is evil in most cases
+ Variables declared by `var` and `let` can be used in nested functions (lexical scoping)

### Function as Values

+ Function variables can be
    + Passed as parameter
    + Reassigned
    + Used in arbitrary expression
    + etc

### Declaration Notation

+ Function can be declared without `var` or `let`
+ Difference is possibility to use function before declaration

```
console.log(square(3));

function square(x){
    return x * x
}
```

### The Call Stack

+ For storing local variables and current 
    place of code execution JS use a call stack
+ Every time when nested function is invoked new entry 
    appears in stack for it's scope. After execution of 
    this function current entry is removing, previous entry 
    becoming current and function of this entry continue it's execution
    + This is two functions example but it can contains any 
        amount of nested functions. Limit is defined by size 
        of stack for this programm

### Optional arguments

+ In JS amount of passed arguments  is not strict
+ Redundant arguments will be ignored
+ Necessary parameters which not been passed will 
    have undefined value

### Closure

+ Closure is possibility to access variable in 
    function scope after it creation

```
function wrapValue(n) {
  var localVariable = n;
  return function() { return localVariable; };
}

var wrap1 = wrapValue(1);
var wrap2 = wrapValue(2);
console.log(wrap1());
// → 1
console.log(wrap2());
// → 2
```

+ Arguments is variables too

```
function multiplier(factor) {
    return function(number) {
        return number * factor;
    };
}

var twice = multiplier(2);
console.log(twice(5));
// → 10
```

### Recursion

+ Recursion is possibility of calling 
    function in its body
+ Recursion is slower than loop
+ Recursion sometimes is clearer 
    than loop for understanding what happening
+ Choice between understandable and fast code
    + Prefer understandable code
    + Optimize only when and where 
        it really necessary (demands, problems)

### Growing Functions

+ Two more or less natural ways to create a function
    + Code repetition
    + Part of code for performing determined action
+ Function must do one determined thing (S in SOLID principles)
+ Don't write your own functionality if there 
    is existed library with suitable parameters

### Side Effect

+ Functions can be divided into those that are called for
    + Side Effect
    + Return Value
    + Both of it
+ Side Effect function change something outside
+ Return Value function calculate some value inside and return it

#### Pure Function

+ Pure function is Return Value function that doesn't 
    rely on side effects from other code
+ Pure function always return the same value 
    with the same arguments
+ Pure function can be tested without context 
    because it context independent

### Exercises

#### Math Min

```
function min(x, y){
    if(x === y){
        return x;
    } else if (x < y){
        return x;
    } else {
        return y;
    }
}
```

#### Recursion

```
function isEven(x){
    if(x === 0){
        return true;
    } else if (x === 1){
        return false;
    } else {
        return isEven(x - (x < 0 ? -2 : 2))
    }
}
```

#### Bean Counting

```
function countChar(str, ch){
    var result = 0;
    for(var i = 0; i < str.length; i++){
        if(str.charAt(i) === ch){
            result++;
        }
    }
    return result;
}

function countBs(str){
    return countChar(str, 'B');
}
```
