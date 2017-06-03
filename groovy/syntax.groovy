#!/usr/bin/env groovy
println "Hello from the shebang line"

// a standalone single line comment
println "hello" // a comment till the end of the line

/* a standalone multiline comment
   spanning two lines */
println "hello" /* a multiline comment starting
                   at the end of a statement */
println 1 /* one */ + 2 /* two */

/**
 * A Class description
 */
class Person {
    /** the name of the person */
    String name

    /**
     * Creates a greeting method for a certain person.
     *
     * @param otherPerson the person to greet
     * @return a greeting message
     */
    String greet(String otherPerson) {
       "Hello ${otherPerson}"
    }
}

// valid identifiers
def name
def item3
def with_underscore
def $dollarStart

// invalid identifiers
//def 3tier
//def a+b
//def a#b

// All keywords are also valid identifiers when following a dot:
//foo.as
//foo.assert
//foo.break
//foo.case
//foo.catch

def map = [:]

map."an identifier with a space and double quotes" = "ALLOWED"
map.'with-dash-signs-and-single-quotes' = "ALLOWED"

assert map."an identifier with a space and double quotes" == "ALLOWED"
assert map.'with-dash-signs-and-single-quotes' == "ALLOWED"

// As we shall see in the following section on strings, Groovy provides different string literals. All kind of strings are actually allowed after the dot:

map.'single quote'
map."double quote"
map.'''triple single quote'''
map."""triple double quote"""
map./slashy string/
map.$/dollar slashy string/$

// Theres a difference between plain character strings and Groovys GStrings (interpolated strings), as in that the latter case, the interpolated values are inserted in the final string for evaluating the whole identifier:

def firstname = "Homer"
map."Simson-${firstname}" = "Homer Simson"

assert map.'Simson-Homer' == "Homer Simson"

// Single quoted strings are a series of characters surrounded by single quotes:

println 'a single quoted string'

// Single quoted strings are plain java.lang.String and dont support interpolation.

// All the Groovy strings can be concatenated with the + operator:

assert 'ab' == 'a' + 'b'

// Triple single quoted strings are multiline. You can span the content of the string across line boundaries without the need to split the string in several pieces, without contatenation or newline escape characters:

def aMultilineString = '''line one
line two
line three'''

// If your code is indented, for example in the body of the method of a class, your string will contain the whitespace of the indentation. The Groovy Development Kit contains methods for stripping out the indentation with the String#stripIndent() method, and with the String#stripMargin() method that takes a delimiter character to identify the text to remove from the beginning of a string.

// When creating a string as follows:

def startingAndEndingWithANewline = '''
line one
line two
line three
'''

// You will notice that the resulting string contains a newline character as first character. It is possible to strip that character by escaping the newline with a backslash:

def strippedFirstNewline = '''\
line one
line two
line three
'''

assert !strippedFirstNewline.startsWith('\n')

// You can escape single quotes with the the backslash character to avoid terminating the string literal:

println 'an escaped single quote: \' needs a backslash'

// And you can escape the escape character itself with a double backslash:

println 'an escaped escape character: \\ needs a double backslash'

// For characters that are not present on your keyboard, you can use unicode escape sequences: a backslash, followed by 'u', then 4 hexadecimal digits.

println 'The Euro currency symbol: \u20AC'

// Double quoted strings are a series of characters surrounded by double quotes:

println "a double quoted string"

// Double quoted strings are plain java.lang.String if theres no interpolated expression, but are groovy.lang.GString instances if interpolation is present.

// Any Groovy expression can be interpolated in all string literals, apart from single and triple single quoted strings. Interpolation is the act of replacing a placeholder in the string with its value upon evaluation of the string. The placeholder expressions are surrounded by ${} or prefixed with $ for dotted expressions. The expression value inside the placeholder is evaluated to its string representation when the GString is passed to a method taking a String as argument by calling toString() on that expression.

// Here, we have a string with a placeholder referencing a local variable:

def name2 = 'Guillaume' // a plain string
def greeting = "Hello ${name2}"

assert greeting.toString() == 'Hello Guillaume'

// But any Groovy expression is valid, as we can see in this example with an arithmetic expression:

def sum = "The sum of 2 and 3 equals ${2 + 3}"
assert sum.toString() == 'The sum of 2 and 3 equals 5'

// In addition to ${} placeholders, we can also use a lone $ sign prefixing a dotted expression:

def person = [name: 'Guillaume', age: 36]
assert "$person.name is $person.age years old" == 'Guillaume is 36 years old'

// But only dotted expressions of the form a.b, a.b.c, etc, are valid, but expressions that would contain parentheses like method calls, curly braces for closures, or arithmetic operators would be invalid. Given the following variable definition of a number:

def number = 3.14

// The following statement will throw a groovy.lang.MissingPropertyException because Groovy believes youre trying to access the toString property of that number, which doesnt exist:

//shouldFail(MissingPropertyException) {
//    println "$number.toString()"
//}

// You can think of "$number.toString()" as being interpreted by the parser as "${number.toString}()".
// If you need to escape the $ or ${} placeholders in a GString so they appear as is without interpolation, you just need to use a \ backslash character to escape the dollar sign:

assert '${name}' == "\${name}"

// So far, weve seen we could interpolate arbitrary expressions inside the ${} placeholder, but there is a special case and notation for closure expressions. When the placeholder contains an arrow, ${}, the expression is actually a closure expressionyou can think of it as a closure with a dollar prepended in front of it:

// The closure is a parameterless closure which doesnt take arguments.
def sParameterLessClosure = "1 + 2 == ${-> 3}" 
assert sParameterLessClosure == '1 + 2 == 3'

// Here, the closure takes a single java.io.StringWriter argument, to which you can append content with the << leftShift operator. In either case, both placeholders are embedded closures.
def sOneParamClosure = "1 + 2 == ${ w -> w << 3}" 
assert sOneParamClosure == '1 + 2 == 3'

// In appearance, it looks like a more verbose way of defining expressions to be interpolated, but closures have an interesting advantage over mere expressions: lazy evaluation.

// Lets consider the following sample:

// We define a number variable containing 1 that we then interpolate within two GStrings, as an expression in eagerGString and as a closure in lazyGString.
def number2 = 1 
def eagerGString = "value == ${number2}"
def lazyGString = "value == ${ -> number2 }"

// We expect the resulting string to contain the same string value of 1 for eagerGString.
assert eagerGString == "value == 1" 
// Similarly for lazyGString
assert lazyGString ==  "value == 1" 

// Then we change the value of the variable to a new number
number2 = 2 

// With a plain interpolated expression, the value was actually bound at the time of creation of the GString.
assert eagerGString == "value == 1" 

// But with a closure expression, the closure is called upon each coercion of the GString into String, resulting in an updated string containing the new number value.
assert lazyGString ==  "value == 2" 

// When a method (whether implemented in Java or Groovy) expects a java.lang.String, but we pass a
// groovy.lang.GString instance, the toString() method of the GString is automatically and
// transparently called.

// The signature of the takeString() method explicitly says its sole parameter is a String
String takeString(String message) {         
    // We also verify that the parameter is indeed a String and not a GString.
    assert message instanceof String        
    return message
}

// We create a GString variable
def message = "The message is ${'hello'}"   
// We double check its an instance of the GString
assert message instanceof GString           

// We then pass that GString to a method taking a String as parameter
def result = takeString(message)            
assert result instanceof String
assert result == 'The message is hello'

// Although interpolated strings can be used in lieu of plain Java strings, they differ with strings in a particular way: their hashCodes are different. Plain Java strings are immutable, whereas the resulting String representation of a GString can vary, depending on its interpolated values. Even for the same resulting string, GStrings and Strings dont have the same hashCode.

assert "one: ${1}".hashCode() != "one: 1".hashCode()

// GString and Strings having different hashCode values, using GString as Map keys should be avoided, especially if we try to retrieve an associated value with a String instead of a GString.

def key = "a"
// The map is created with an initial pair whose key is a GString
def m = ["${key}": "letter ${key}"]     

// When we try to fetch the value with a String key, we will not find it, as Strings and GString have different hashCode values
assert m["a"] == null

// Triple double quoted strings behave like double quoted strings, with the addition that they are multiline, like the triple single quoted strings.

def name3 = 'Groovy'
def template = """
    Dear Mr ${name3},

    You're the winner of the lottery!

    Yours sincerly,

    Dave
"""
assert template.toString().contains('Groovy')

// Beyond the usual quoted strings, Groovy offers slashy strings, which use / as delimiters. Slashy strings are particularly useful for defining regular expressions and patterns, as there is no need to escape backslashes.

def fooPattern = /.*foo.*/
assert fooPattern == '.*foo.*'

// Only forward slashes need to be escaped with a backslash:

def escapeSlash = /The character \/ is a forward slash/
assert escapeSlash == 'The character / is a forward slash'

// Slashy strings are multiline:

def multilineSlashy = /one
    two
    three/

assert multilineSlashy.contains('\n')

// Slashy strings can also be interpolated (ie. a GString):

def color = 'blue'
def interpolatedSlashy = /a ${color} car/

assert interpolatedSlashy == 'a blue car'

// There are a few gotchas to be aware of.

// An empty slashy string cannot be represented with a double forward slash, as its understood by the Groovy parser as a line comment. Thats why the following assert would actually not compile as it would look like a non-terminated statement:

// assert '' == //

// As slashy strings were mostly designed to make regexp easier so a few things that are errors in GStrings like $() will work with slashy strings.

// Dollar slashy strings are multiline GStrings delimited with an opening $/ and and a closing /$. The escaping character is the dollar sign, and it can escape another dollar, or a forward slash. But both dollar and forward slashes dont need to be escaped, except to escape the dollar of a string subsequence that would start like a GString placeholder sequence, or if you need to escape a sequence that would start like a closing dollar slashy string delimiter.

// Heres an example:

def name4 = "Guillaume"
def date = "April, 1st"

def dollarSlashy = $/
    Hello $name4,
    today we're ${date}.

    $ dollar sign
    $$ escaped dollar sign
    \ backslash
    / forward slash
    $/ escaped forward slash
    $/$ escaped dollar slashy string delimiter
/$

assert [
    'Guillaume',
    'April, 1st',
    '$ dollar sign',
    '$ escaped dollar sign',
    '\\ backslash',
    '/ forward slash',
        '$/ escaped forward slash',
        '/$ escaped dollar slashy string delimiter'

        ].each { dollarSlashy.contains(it) }

// string summary table
// type    interpolated    multiline    escapechar
// ''		no		no		\
// ''''''	no		yes		\
// ""		yes		no		\
// """"""	yes		yes		\
// //		yes		yes		\
// $/$/		yes 		yes		$

// Unlike Java, Groovy doesnt have an explicit character literal. However, you can be explicit about making a Groovy string an actual character, by three different means:

// by being explicit when declaring a variable holding the character by specifying the char type
char c1 = 'A' 
assert c1 instanceof Character

// by using type coercion with the as operator
def c2 = 'B' as char 
assert c2 instanceof Character

// by using a cast to char operation
def c3 = (char)'C' 
assert c3 instanceof Character

// Groovy supports different kinds of integral literals and decimal literals, backed by the usual Number types of Java.

// The integral literal types are the same as in Java:

// byte
// char
// short
// int
// long
// java.lang.BigInteger

// You can create integral numbers of those types with the following declarations:

// primitive types
byte  b = 1
char  c = 2
short s = 3
int   i = 4
long  l = 5

// infinite precision
BigInteger bi =  6

// If you use optional typing by using the def keyword, the type of the integral number will vary: itll adapt to the capacity of the type that can hold that number.

// For positive numbers:

def a = 1
assert a instanceof Integer

// Integer.MAX_VALUE
def b2 = 2147483647
assert b2 instanceof Integer

// Integer.MAX_VALUE + 1
def c4 = 2147483648
assert c4 instanceof Long

// Long.MAX_VALUE
def d = 9223372036854775807
assert d instanceof Long

// Long.MAX_VALUE + 1
def e = 9223372036854775808
assert e instanceof BigInteger

// As well as for negative numbers:

def na = -1
assert na instanceof Integer

// Integer.MIN_VALUE
def nb = -2147483648
assert nb instanceof Integer

// Integer.MIN_VALUE - 1
def nc = -2147483649
assert nc instanceof Long

// Long.MIN_VALUE
def nd = -9223372036854775808
assert nd instanceof Long

// Long.MIN_VALUE - 1
def ne = -9223372036854775809
assert ne instanceof BigInteger

// Numbers can also be represented in binary, octal, hexadecimal and decimal bases.

// Binary numbers start with a 0b prefix:

int bInt = 0b10101111
assert bInt == 175

short bShort = 0b11001001
assert bShort == 201 as short

byte bByte = 0b11
assert bByte == 3 as byte

long bLong = 0b101101101101
assert bLong == 2925l

BigInteger bBigInteger = 0b111100100001
assert bBigInteger == 3873g

int bNegativeInt = -0b10101111
assert bNegativeInt == -175

// Octal numbers are specified in the typical format of 0 followed by octal digits.

int oInt = 077
assert oInt == 63

short oShort = 011
assert oShort == 9 as short

byte oByte = 032
assert oByte == 26 as byte

long oLong = 0246
assert oLong == 166l

BigInteger oBigInteger = 01111
assert oBigInteger == 585g

int oNegativeInt = -077
assert oNegativeInt == -63

// Hexadecimal numbers are specified in the typical format of 0x followed by hex digits.

int xInt = 0x77
assert xInt == 119

short xShort = 0xaa
assert xShort == 170 as short

byte xByte = 0x3a
assert xByte == 58 as byte

long xLong = 0xffff
assert xLong == 65535l

BigInteger xBigInteger = 0xaaaa
assert xBigInteger == 43690g

Double xDouble = new Double('0x1.0p0')
assert xDouble == 1.0d

int xNegativeInt = -0x77
assert xNegativeInt == -119

// The decimal literal types are the same as in Java:

// float
// double
// java.lang.BigDecimal

// You can create decimal numbers of those types with the following declarations:

// primitive types
float  f = 1.234
double d2 = 2.345

// infinite precision
BigDecimal bd =  3.456

// Decimals can use exponents, with the e or E exponent letter, followed by an optional sign, and a integral number representing the exponent:

assert 1e3  ==  1_000.0
assert 2E4  == 20_000.0
assert 3e+1 ==     30.0
assert 4E-2 ==      0.04
assert 5e-1 ==      0.5

// Conveniently for exact decimal number calculations, Groovy choses java.lang.BigDecimal as its decimal number type. In addition, both float and double are supported, but require an explicit type declaration, type coercion or suffix. Even if BigDecimal is the default for decimal numbers, such literals are accepted in methods or closures taking float or double as parameter types.

// Decimal numbers cant be represented using a binary, octal or hexadecimal representation.

// When writing long literal numbers, its harder on the eye to figure out how some numbers are grouped together, for example with groups of thousands, of words, etc. By allowing you to place underscore in number literals, its easier to spot those groups:

long creditCardNumber = 1234_5678_9012_3456L
long socialSecurityNumbers = 999_99_9999L
double monetaryAmount = 12_345_132.12
long hexBytes = 0xFF_EC_DE_5E
long hexWords = 0xFFEC_DE5E
long maxLong = 0x7fff_ffff_ffff_ffffL
long alsoMaxLong = 9_223_372_036_854_775_807L
long bytes = 0b11010010_01101001_10010100_10010010

// We can force a number (including binary, octals and hexadecimals) to have a specific type by giving a suffix (see table below), either uppercase or lowercase.

assert 42I == new Integer('42')
assert 42i == new Integer('42') // lowercase i more readable
assert 123L == new Long("123") // uppercase L more readable
assert 2147483648 == new Long('2147483648') // Long type used, value too large for an Integer
assert 456G == new BigInteger('456')
assert 456g == new BigInteger('456')
assert 123.45 == new BigDecimal('123.45') // default BigDecimal type used
assert 1.200065D == new Double('1.200065')
assert 1.234F == new Float('1.234')
assert 1.23E23D == new Double('1.23E23')
assert 0b1111L.class == Long // binary
assert 0xFFi.class == Integer // hexadecimal
assert 034G.class == BigInteger // octal

// base and exponent are ints and the result can be represented by an Integer
assert    2    **   3    instanceof Integer    //  8
assert   10    **   9    instanceof Integer    //  1_000_000_000

// the base is a long, so fit the result in a Long
// (although it could have fit in an Integer)
assert    5L   **   2    instanceof Long       //  25

// the result can't be represented as an Integer or Long, so return a BigInteger
assert  100    **  10    instanceof BigInteger //  10e20
assert 1234    ** 123    instanceof BigInteger //  170515806212727042875...

// the base is a BigDecimal and the exponent a negative int
// but the result can be represented as an Integer
assert    0.5  **  -2    instanceof Integer    //  4

// the base is an int, and the exponent a negative float
// but again, the result can be represented as an Integer
assert    1    **  -0.3f instanceof Integer    //  1

// the base is an int, and the exponent a negative int
// but the result will be calculated as a Double
// (both base and exponent are actually converted to doubles)
assert   10    **  -1    instanceof Double     //  0.1

// the base is a BigDecimal, and the exponent is an int, so return a BigDecimal
assert    1.2  **  10    instanceof BigDecimal //  6.1917364224

// the base is a float or double, and the exponent is an int
// but the result can only be represented as a Double value
assert    3.4f **   5    instanceof Double     //  454.35430372146965
assert    5.6d **   2    instanceof Double     //  31.359999999999996

// the exponent is a decimal value
// and the result can only be represented as a Double value
assert    7.8  **   1.9  instanceof Double     //  49.542708423868476
assert    2    **   0.1f instanceof Double     //  1.0717734636432956

// Boolean values can be stored in variables, assigned into fields, just like any other data type:

def myBooleanVariable = true
boolean untypedBooleanVar = false
booleanField = true

// Groovy uses a comma-separated list of values, surrounded by square brackets, to denote lists. Groovy lists are plain JDK java.util.List, as Groovy doesnt define its own collection classes. The concrete list implementation used when defining list literals are java.util.ArrayList by default, unless you decide to specify otherwise, as we shall see later on.

// We define a list numbers delimited by commas and surrounded by square brackets, and we assign that list into a variable
def numbers = [1, 2, 3]         

// The list is an instance of Javas java.util.List interface
assert numbers instanceof List  
// The size of the list can be queried with the size() method, and shows our list contains 3 elements
assert numbers.size() == 3  

// In the above example, we used a homogeneous list, but you can also create lists containing values of heterogeneous types:

// Our list here contains a number, a string and a boolean value
def heterogeneous = [1, "a", true]

// We mentioned that by default, list literals are actually instances of java.util.ArrayList, but it is possible to use a different backing type for our lists, thanks to using type coercion with the as operator, or with explicit type declaration for your variables:

def arrayList = [1, 2, 3]
assert arrayList instanceof java.util.ArrayList

// We use coercion with the as operator to explicitly request a java.util.LinkedList implementation
def linkedList = [2, 3, 4] as LinkedList    
assert linkedList instanceof java.util.LinkedList

// We can say that the variable holding the list literal is of type java.util.LinkedList
LinkedList otherLinked = [3, 4, 5]          
assert otherLinked instanceof java.util.LinkedList

// You can access elements of the list with the [] subscript operator (both for reading and setting values) with positive indices or negative indices to access elements from the end of the list, as well as with ranges, and use the << leftShift operator to append elements to a list:

def letters = ['a', 'b', 'c', 'd']

// Access the first element of the list (zero-based counting)
assert letters[0] == 'a'     
assert letters[1] == 'b'

// Access the last element of the list with a negative index: -1 is the first element from the end of the list
assert letters[-1] == 'd'    
assert letters[-2] == 'c'

// Use an assignment to set a new value for the third element of the list
letters[2] = 'C'             
assert letters[2] == 'C'

// Use the << leftShift operator to append an element at the end of the list
letters << 'e'               
assert letters[ 4] == 'e'
assert letters[-1] == 'e'

// Access two elements at once, returning a new list containing those two elements
assert letters[1, 3] == ['b', 'd']         
// Use a range to access a range of values from the list, from a start to an end element position
assert letters[2..4] == ['C', 'd', 'e']    


// As lists can be heterogeneous in nature, lists can also contain other lists to create multi-dimensional lists:

// Define a list of list of numbers
def multi = [[0, 1], [2, 3]]     
// Access the second element of the top-most list, and the first element of the inner list
assert multi[1][0] == 2    

// Groovy reuses the list notation for arrays, but to make such literals arrays, you need to explicitely define the type of the array through coercion or type declaration.

// Define an array of strings using explicit variable type declaration
String[] arrStr = ['Ananas', 'Banana', 'Kiwi']  

// Assert that we created an array of strings
assert arrStr instanceof String[]    
assert !(arrStr instanceof List)

// Create an array of ints with the as operator
def numArr = [1, 2, 3] as int[]      

// Assert that we created an array of primitive ints
assert numArr instanceof int[]       
assert numArr.size() == 3

// You can also create multi-dimensional arrays:

// You can define the bounds of a new array
def matrix3 = new Integer[3][3]         
assert matrix3.size() == 3

// Or declare an array without specifying its bounds
Integer[][] matrix2                     
matrix2 = [[1, 2], [3, 4]]
assert matrix2 instanceof Integer[][]

// Access to elements of an array follows the same notation as for lists:

String[] names = ['Cdric', 'Guillaume', 'Jochen', 'Paul']

// Retrieve the first element of the array
assert names[0] == 'Cdric'     

// Set the value of the third element of the array to a new value
names[2] = 'Blackdrag'          
assert names[2] == 'Blackdrag'

// Sometimes called dictionaries or associative arrays in other languages, Groovy features maps. Maps associate keys to values, separating keys and values with colons, and each key/value pairs with commas, and the whole keys and values surrounded by square brackets.

// We define a map of string color names, associated with their hexadecimal-coded html colors
def colors = [red: '#FF0000', green: '#00FF00', blue: '#0000FF']   

// We use the subscript notation to check the content associated with the red key
assert colors['red'] == '#FF0000'    
// We can also use the property notation to assert the color greens hexadecimal representation
assert colors.green  == '#00FF00'    

// Similarly, we can use the subscript notation to add a new key/value pair
colors['pink'] = '#FF00FF'           
// Or the property notation, to add the yellow color
colors.yellow  = '#FFFF00'           

assert colors.pink == '#FF00FF'
assert colors['yellow'] == '#FFFF00'

assert colors instanceof java.util.LinkedHashMap

// When using names for the keys, we actually define string keys in the map.
// Groovy creates maps that are actually instances of java.util.LinkedHashMap.

// If you try to access a key which is not present in the map:

assert colors.unknown == null

// In the examples above, we used string keys, but you can also use values of other types as keys:

def numbers2 = [1: 'one', 2: 'two']

assert numbers2[1] == 'one'

// Here, we used numbers as keys, as numbers can unambiguously be recognized as numbers, so Groovy will not create a string key like in our previous examples. But consider the case you want to pass a variable in lieu of the key, to have the value of that variable become the key:

def key2 = 'name'
// The key associated with the 'Guillaume' name will actually be the "key2" string, not the value associated with the key2 variable
def person2 = [key2: 'Guillaume']      

// The map doesnt contain the 'name' key
assert !person2.containsKey('name')   
// Instead, the map contains a 'key2' key
assert person2.containsKey('key2')    

// You can also pass quoted strings as well as keys: ["name": "Guillaume"]. This is mandatory if your key string isnt a valid identifier, for example if you wanted to create a string key containing a hash like in: ["street-name": "Main street"].
// When you need to pass variable values as keys in your map definitions, you must surround the variable or expression with parentheses:

// This time, we surround the key2 variable with parentheses, to instruct the parser we are passing a variable rather than defining a string key
person2 = [(key2): 'Guillaume']        

// The map does contain the name key
assert person2.containsKey('name')    
// But the map doesnt contain the key2 key as before
assert !person2.containsKey('key2') 
