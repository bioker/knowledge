# Common Programming things

## Typing

### Checking while compilation

#### Static

+ Check at compilation
+ Advantages
    + Types checking happens once at compilation
    + Previous point is why programs with static typing usually is faster
    + With some conditions, it allow find out some mistakes at compilation
    + Faster development with ide autocompletion

#### Dynamic

+ Check at runtime
+ Advantages
    + Good abstraction
    + Allow make algorithms more generically
    + Easier for learning

##### Duck typing

+ It Allow work with objects by their interfaces
+ If it looks like a duck, swims like a duck and quacks like a duck, 
    then it probably is a duck.

### Checking while variables processing

#### Strong

+ Don't allow use operators with different types in one expression
+ Advantages
    + Reliability - compiler error instead wrong behavior
    + Speed - implicit types conversion can be costly
    + Program work understanding
    + You know what you will get

#### Weak

+ Allow use operators with different types in one expression
+ Advantages
    + Mixed expressions (Strings and Numbes)
    + Abstraction
    + Shorter writing

### Checking while variables definition

#### Explicit

+ Programmer define exactly type of variable
+ Advantages
    + Functions and methods has signature
    + We know what type is used in function or method

#### Implicit

+ Programmer can define variable without exactly type
+ Advantages
    + Shorter function definition
    + Changes will not break work
