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

#### Types

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
