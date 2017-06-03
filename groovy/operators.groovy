#!/usr/bin/env groovy
// 1. Artithmetic operators

// Groovy supports the usual familiar arithmetic operators you find in mathematics and in other
// programming languages like Java. All the Java arithmetic operators are supported. Lets go through
// them in the following examples.

// 1.1 Normal arithmetic operators

assert  1  + 2 == 3 // addition
assert  4  - 3 == 1 // substraction
assert  3  * 5 == 15 // multiplication
assert  3  / 2 == 1.5 // division
assert 10  % 3 == 1 // remainder
assert  2 ** 3 == 8 // power

// 1.2 Unary arithmetic operators

assert +3 == 3
assert -4 == 0 - 4
// Note the usage of parentheses to surround an expression to apply the unary minus to that surrounded expression.
assert -(-1) == 1

// In terms of unary arithmetics operators, the ++ (increment) and -- (decrement) operators are
// available, both in prefix and postfix notation:

def a = 2
def b = a++ * 3             

assert a == 3 && b == 6

def c = 3
def d = c-- * 2             

assert c == 2 && d == 6

def e = 1
def f = ++e + 3             

assert e == 2 && f == 5

def g = 4
def h = --g + 1             

assert g == 3 && h == 4

// 1.3 Assignment arithmetic operators

// The binary arithmetic operators we have seen above are also available in an assignment form:

def a1 = 4
a1 += 3

assert a1 == 7

def b1 = 5
b1 -= 3

assert b1 == 2

def c1 = 5
c1 *= 3

assert c1 == 15

def d1 = 10
d1 /= 2

assert d1 == 5

def e1 = 10
e1 %= 3

assert e1 == 1

def f1 = 3
f1 **= 2

assert f1 == 9

// 2. Relation operators

// Relational operators allow comparisons between objects, to know if two objects are the same or
// different, or if one is greater than, less than, or equal to the other.

assert 1 + 2 == 3
assert 3 != 4

assert -2 < 3
assert 2 <= 2
assert 3 <= 4

assert 5 > 1
assert 5 >= -2

// 3. Logical operators

assert !false           
assert true && true     
assert true || false

boolean checkIfCalled() {   
    called = true
}

called = false
true || checkIfCalled()
assert !called              

called = false
false || checkIfCalled()
assert called               

called = false
false && checkIfCalled()
assert !called              

called = false
true && checkIfCalled()
assert called

// 4. Bitwise operators

// Bitwise operators can be applied on a byte or an int and return an int:

int a2 = 0b00101010
assert a2==42
int b2 = 0b00001000
assert b2==8
assert (a2 & a2) == a2                     
assert (a2 & b2) == b2                     
assert (a2 | a2) == a2                     
assert (a2 | b2) == a2                     

int mask = 0b11111111                   
assert ((a2 ^ a2) & mask) == 0b00000000   
assert ((a2 ^ b2) & mask) == 0b00100010   
assert ((~a2) & mask)    == 0b11010101

// 5. Conditional operators

// 5.1 Not operator
assert (!true)    == false                      
assert (!'foo')   == false                      
assert (!'')      == true

// 5.2 Ternary opertator

// The ternary operator is a shortcut expression that is equivalent to an if/else branch assigning some value to a variable.

String string = 'test'
result = (string!=null && string.length()>0) ? 'Found' : 'Not found'
result = string ? 'Found' : 'Not found'

// 5.3 Elvis operator

// The "Elvis operator" is a shortening of the ternary operator. One instance of where this is handy is for returning a 'sensible default' value if an expression resolves to false-ish (as in Groovy truth). A simple example might look like this:

String displayName
class User{
    String name
}
User user = new User()
displayName = user.name ? user.name : 'Anonymous'   
displayName = user.name ?: 'Anonymous'   

// 6. Object operators

// 6.1 Safe navigation operator

// The Safe Navigation operator is used to avoid a NullPointerException. Typically when you have a
// reference to an object you might need to verify that it is not null before accessing methods or
// properties of the object. To avoid this, the safe navigation operator will simply return null
// instead of throwing an exception, like so:

def person = null 
def name = person?.name                      
assert name == null

// 6.2 Direct field access operator

// Normally in Groovy, when you write code like this:

class User2 {
    public final String name                 
    User2(String name) { this.name = name}
    String getName() { "Name: $name" }       
}
def user2 = new User2('Bob')
assert user2.name == 'Name: Bob' 

// The user.name call triggers a call to the property of the same name, that is to say, here, to the
// getter for name. If you want to retrieve the field instead of calling the getter, you can use the
// direct field access operator:

assert user2.@name == 'Bob'

// use of .@ forces usage of the field instead of the getter

// 6.3 Method pointer operator

// The method pointer operator (.&) call be used to store a reference to a method in a variable, in
// order to call it later:

def str = 'example of method reference'            
def fun = str.&toUpperCase                         
def upper = fun()                                  
assert upper == str.toUpperCase()

// There are multiple advantages in using method pointers. First of all, the type of such a method
// pointer is a groovy.lang.Closure, so it can be used in any place a closure would be used. In
// particular, it is suitable to convert an existing method for the needs of the strategy pattern:

class Person{
    String name
    Integer age
}
def transform(List elements, Closure action) {                    
    def result = []
    elements.each {
        result << action(it)
    }
    result
}
String describe(Person p) {                                       
    "$p.name is $p.age"
}
def action = this.&describe                                       
def list = [
    new Person(name: 'Bob',   age: 42),
    new Person(name: 'Julia', age: 35)]                           
assert transform(list, action) == ['Bob is 42', 'Julia is 35'] 

// Method pointers are bound by the receiver and a method name. Arguments are resolved at runtime,
// meaning that if you have multiple methods with the same name, the syntax is not different, only
// resolution of the appropriate method to be called will be done at runtime:

def doSomething(String str) { str.toUpperCase() }    
def doSomething(Integer x) { 2*x }                   
def reference = this.&doSomething                    
assert reference('foo') == 'FOO'                     
assert reference(123)   == 246

// 7.1 Regular expression operators

// 7.1 Pattern operator

// The pattern operator (~) provides a simple way to create a java.util.regex.Pattern instance:

def p = ~/foo/
assert p instanceof java.util.regex.Pattern

// while in general, you find the pattern operator with an expression in a slashy-string, it can be
// used with any kind of String in Groovy:


p = ~'foo'
p = ~"foo"
p = ~$/dollar/slashy $ string/$                                   
String pattern = 'test'
p = ~"${pattern}"

// 7.2 Find operator

// Alternatively to building a pattern, you can directly use the find operator =~ to build a
// java.util.regex.Matcher instance:

def text = "some text to match"
def m = text =~ /match/                                           
assert m instanceof java.util.regex.Matcher                                       
if (!m) {                                                         
    throw new RuntimeException("Oops, text not found!")
}

// 7.3 Match operator

// The match operator (==~) is a slight variation of the find operator, that does not return a
// Matcher but a boolean and requires a strict match of the input string:

m = text ==~ /match/                                              
assert m instanceof Boolean                                       
if (m) {                                                          
    throw new RuntimeException("Should not reach that point!")
}

// 8. Other operators

// 8.1 Spread operator

// The Spread Operator (*.) is used to invoke an action on all items of an aggregate object. It is
// equivalent to calling the action on each item and collecting the result into a list:

class Car {
    String make
    String model
}
def cars = [
       new Car(make: 'Peugeot', model: '508'),
       new Car(make: 'Renault', model: 'Clio')]       
def makes = cars*.make                                
assert makes == ['Peugeot', 'Renault']

// The spread operator is null-safe, meaning that if an element of the collection is null, it will
// return null instead of throwing a NullPointerException:

cars = [
   new Car(make: 'Peugeot', model: '508'),
   null,                                              
   new Car(make: 'Renault', model: 'Clio')]
assert cars*.make == ['Peugeot', null, 'Renault']     
assert null*.make == null

// The spread operator can be used on any class which implements the Iterable interface:

class Component {
    Long id
    String name
}
class CompositeObject implements Iterable<Component> {
    def components = [
        new Component(id: 1, name: 'Foo'),
        new Component(id: 2, name: 'Bar')]

    @Override
    Iterator<Component> iterator() {
        components.iterator()
    }
}
def composite = new CompositeObject()
assert composite*.id == [1,2]
assert composite*.name == ['Foo','Bar']

//  8.1.1 Spreading method arguments

// There may be situations when the arguments of a method call can be found in a list that you need
// to adapt to the method arguments. In such situations, you can use the spread operator to call the
// method. For example, imagine you have the following method signature:

int function(int x, int y, int z) {
    x*y+z
}
// then if you have the following list:
def args = [4,5,6]
// you can call the method without having to define intermediate variables:
assert function(*args) == 26
// It is even possible to mix normal arguments with spread ones:
args = [4]
assert function(*args,5,6) == 26

// 8.1.2 Spread list elements

// When used inside a list literal, the spread operator acts as if the spread element contents were inlined into the list:

def items = [4,5]                      
def list1 = [1,2,3,*items,6]            
assert list1 == [1,2,3,4,5,6]     

// 8.1.3 Spread map elements

def m1 = [c:3, d:4]                   
def map = [a:1, b:2, *:m1]            
assert map == [a:1, b:2, c:3, d:4]   

def m2 = [c:3, d:4]                   
def map1 = [a:1, b:2, *:m2, d: 8]      
assert map1 == [a:1, b:2, c:3, d:8] 

// 8.2 Range operator

// Groovy supports the concept of ranges and provides a notation (..) to create ranges of objects:

def range = 0..5                                    
assert (0..5).collect() == [0, 1, 2, 3, 4, 5]       
assert (0..<5).collect() == [0, 1, 2, 3, 4]         
assert (0..5) instanceof List                       
assert (0..5).size() == 6   

// Ranges implementation is lightweight, meaning that only the lower and upper bounds are stored.
// You can create a range from any Comparable object that has next() and previous() methods to
// determine the next / previous item in the range. For example, you can create a range of
// characters this way:

assert ('a'..'d').collect() == ['a','b','c','d']

// 8.3 Spaceship operator

// The spaceship operator (<=>) delegates to the compareTo method:

assert (1 <=> 1) == 0
assert (1 <=> 2) == -1
assert (2 <=> 1) == 1
assert ('a' <=> 'z') == -1

// 8.4 Subscript operator

// The subscript operator is a short hand notation for getAt or putAt, depending on whether you find
// it on the left hand side or the right hand side of an assignment:

def list2 = [0,1,2,3,4]
assert list2[2] == 2                         
list2[2] = 4                                 
assert list2[0..2] == [0,1,4]                
list2[0..2] = [6,6,6]                        
assert list2 == [6,6,6,3,4]

// The subscript operator, in combination with a custom implementation of getAt/putAt is a
// convenient way for destructuring objects:

class User3 {
    Long id
    String name
    def getAt(int i) {                                             
        switch (i) {
            case 0: return id
            case 1: return name
        }
        throw new IllegalArgumentException("No such element $i")
    }
    void putAt(int i, def value) {                                 
        switch (i) {
            case 0: id = value; return
            case 1: name = value; return
        }
        throw new IllegalArgumentException("No such element $i")
    }
}
def user3 = new User3(id: 1, name: 'Alex')                           
assert user3[0] == 1                                                
assert user3[1] == 'Alex'                                           
user3[1] = 'Bob'                                                    
assert user3.name == 'Bob' 

// 8.5 Membership operator

//  The membership operator (in) is equivalent to calling the isCase method. In the context of a
//  List, it is equivalent to calling contains, like in the following example:

def list4 = ['Grace','Rob','Emmy']
assert ('Emmy' in list4)

// 8.6 Identity operator

// In Groovy, using == to test equality is different from using the same operator in Java. In
// Groovy, it is calling equals. If you want to compare reference equality, you should use is like
// in the following example:

def list5 = ['Groovy 1.8','Groovy 2.0','Groovy 2.3']        
def list6 = ['Groovy 1.8','Groovy 2.0','Groovy 2.3']        
assert list5 == list6                                       
assert !list5.is(list6)

// 8.7 Coercion operator

// The coercion operator (as) is a variant of casting. Coercion converts object from one type to
// another without them being compatible for assignment. Lets take an example:

Integer x = 123
String s = (String) x
assert s == '123'

// This can be fixed by using coercion instead:

Integer x1 = 123
String s1 = x1 as String 
assert s1 == '123'

// When an object is coerced into another, unless the target type is the same as the source type,
// coercion will return a new object. The rules of coercion differ depending on the source and
// target types, and coercion may fail if no conversion rules are found. Custom conversion rules may
// be implemented thanks to the asType method:

class Identifiable {
    String name
}
class User4 {
    Long id
    String name
    def asType(Class target) {                                              
        if (target==Identifiable) {
            return new Identifiable(name: name)
        }
        throw new ClassCastException("User cannot be coerced into $target")
    }
}
def u = new User4(name: 'Xavier')                                            
def p1 = u as Identifiable                                                   
assert p1 instanceof Identifiable                                            
assert !(p1 instanceof User)

// 8.8 Diamond operator

// The diamond operator (<>) is a syntactic sugar only operator added to support compatibility with
// the operator of the same name in Java 7. It is used to indicate that generic types should be
// inferred from the declaration:

List<String> strings = new LinkedList<>()

// 8.9 Call operator

// The call operator () is used to call a method named call implicitly. For any object which defines
// a call method, you can omit the .call part and use the call operator instead:

class MyCallable {
    int call(int x) {           
        2*x
    }
}

def mc = new MyCallable()
assert mc.call(2) == 4          
assert mc(2) == 4

// 9. Operator precedence

// The table below lists all groovy operators in order of precedence.

// level 1

// new - object creation
// () - explicit parentheses
// () - method call 
// {} - closure
// [] - iteral list/map
// . - member access
// .& - method closure
// .@ - attribute access
// .? - safe dereferencing
// * - spread
// *. - spread-dot
// *: - spread-map
// ~ - bitwise negate/pattern
// ! - not
// (type) - typecase
// [] - list/map/array index
// ++ - postincrement
// -- - postdecrement

// level 3
// ** power

// level 4
// ++ - preincrement
// -- - predecrement
// + - unary plus
// - - unary minus

// level 5
// * - multiply
// / - div
// % - reminder

// level 6
// + - addition
// - - substraction

// level 7
// << - left shift
// >> - right shift
// >>> - unsigned right shift
// .. - inclusive range
// ..< - exclusive range

// level 8
// < - less than
// <= - less or equal than
// > - more than
// >= - more or equal than
// in - in (list for example)
// instanceof - class checking
// as - type coercion

// level 9
// == - equals
// != - not equals
// <=> - compare to
// =~ - regex find
// ==~ - regex match

// level 10
// & - binary and

// level 11 
// ^ - binary xor

// level 12
// | - binary or

// level 13
// && - logical and

// level 14
// || - logical or

// level 15
// ? : - ternary condition
// ?: - elvis operator

// level 16
// =
// **=
// *=
// /=
// %=
// +=
// -=
// <<=
// >>=
// >>>=
// &=
// ^=
// |=

// 10. Operators overloading

class Bucket {
    int size

    Bucket(int size) { this.size = size }

    Bucket plus(Bucket other) {                     
        return new Bucket(this.size + other.size)
    }
}

// Just by implementing the plus() method, the Bucket class can now be used with the + operator like
// so:

def bu1 = new Bucket(4)
def bu2 = new Bucket(11)
assert (bu1 + bu2).size == 15

// All (non-comparator) Groovy operators have a corresponding method that you can implement in your
// own classes. The only requirements are that your method is public, has the correct name, and has
// the correct number of arguments. The argument types depend on what types you want to support on
// the right hand side of the operator. For example, you could support the statement

// Here is a complete list of the operators and their corresponding methods:

// Operator - Method
// + - plus
// - - minus
// * - multiply
// / - div
// % - mod
// ** - power
// | - or
// & - and
// ^ - xor
// as - asType
// () - call
// [] - getAt
// []=  - putAt
// in - isCase
// << - leftShift
// >> - rightShift
// >>> - rightShiftUnsigned
// ++ - next
// -- - previous
// +a - a.positive()
// -a - a.negative()
// ~a - a.bitwiseNegate()
