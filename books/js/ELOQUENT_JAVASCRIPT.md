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
    + Greater than - `5 > 2`
    + Less than - `2 < 5`
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
