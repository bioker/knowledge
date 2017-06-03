#!/usr/bin/env groovy
// 1. Package names

// Package names play exactly the same role as in Java. They allows us to separate the code base
// without any conflicts. Groovy classes must specify their package before the class definition,
// else the default package is assumed.

// Defining a package is very similar to Java:
package net.wls

// To refer to some class Foo in the com.yoursite.com package you will need to use the fully
// qualified name com.yoursite.com.Foo, or else you can use an import statement as well see below.

// 2. Imports

// In order to refer to any class you need a qualified reference to its package. Groovy follows
// Javas notion of allowing import statement to resolve class references.

// For example, Groovy provides several builder classes, such as MarkupBuilder. MarkupBuilder is inside
// the package groovy.xml so in order to use this class, you need to import it as shown:

// importing the class MarkupBuilder
import groovy.xml.MarkupBuilder

// using the imported class to create an object
def xml = new MarkupBuilder()

assert xml != null

// 2.1. Default imports

// Default imports are the imports that Groovy language provides by default. For example look at the
// following code:

new Date()

// The same code in Java needs an import statement to Date class like this: import java.util.Date.
// Groovy by default imports these classes for you.

// The below imports are added by groovy for you:

import java.lang.*
import java.util.*
import java.io.*
import java.net.*
import groovy.lang.*
import groovy.util.*
import java.math.BigInteger
import java.math.BigDecimal

// This is done because the classes from these packages are most commonly used. By importing these
// boilerplate code is reduced.

// 2.2. Simple import

// A simple import is an import statement where you fully define the class name along with the
// package. For example the import statement import groovy.xml.MarkupBuilder in the code below is a
// simple import which directly refers to a class inside a package.

// importing the class MarkupBuilder
import groovy.xml.MarkupBuilder

// using the imported class to create an object
def xml1 = new MarkupBuilder()

assert xml1 != null

// 2.3. Star import

// Groovy, like Java, provides a special way to import all classes from a package using *, the so
// called star import. MarkupBuilder is a class which is in package groovy.xml, alongside another
// class called StreamingMarkupBuilder. In case you need to use both classes, you can do:

import groovy.xml.MarkupBuilder
import groovy.xml.StreamingMarkupBuilder

def markupBuilder = new MarkupBuilder()

assert markupBuilder != null

assert new StreamingMarkupBuilder() != null

// Thats perfectly valid code. But with a * import, we can achieve the same effect with just one
// line. The star imports all the classes under package groovy.xml:

import groovy.xml.*

def markupBuilder1 = new MarkupBuilder()

assert markupBuilder1 != null

assert new StreamingMarkupBuilder() != null

// One problem with * imports is that they can clutter your local namespace. But with the kinds of
// aliasing provided by Groovy, this can be solved easily.

// 2.4. Static import

// Groovys static import capability allows you to reference imported classes as if they were static
// methods in your own class:

import static Boolean.FALSE

assert !FALSE //use directly, without Boolean prefix!

// This is similar to Javas static import capability but is a more dynamic than Java in that it
// allows you to define methods with the same name as an imported method as long as you have
// different types:

// import static java.lang.String.format 

import static java.lang.String.format 

class SomeClass {

    String format(Integer i) { 
        i.toString()
    }

    static void main(String[] args) {
        assert format('String') == 'String' 
        assert new SomeClass().format(Integer.valueOf(1)) == '1'
    }
}

// If you have the same types, the imported class takes precedence.

// 2.5. Static import aliasing

// Static imports with the as keyword provide an elegant solution to namespace problems. Suppose you
// want to get a Calendar instance, using its getInstance() method. Its a static method, so we can
// use a static import. But instead of calling getInstance() every time, which can be misleading
// when separated from its class name, we can import it with an alias, to increase code readability:

import static Calendar.getInstance as now

assert now().class == Calendar.getInstance().class

// 2.6. Static star import

// A static star import is very similar to the regular star import. It will import all the static
// methods from the given class.

// For example, lets say we need to calculate sines and cosines for our application. The class
// java.lang.Math has static methods named sin and cos which fit our need. With the help of a static
// star import, we can do:

import static java.lang.Math.*

assert sin(0) == 0.0
assert cos(0) == 1.0

// 2.7. Import aliasing

// With type aliasing, we can refer to a fully qualified class name using a name of our choice. This
// can be done with the as keyword, as before.

// For example we can import java.sql.Date as SQLDate and use it in the same file as java.util.Date
// without having to use the fully qualified name of either class:

import java.util.Date
import java.sql.Date as SQLDate

Date utilDate = new Date(1000L)
SQLDate sqlDate = new SQLDate(1000L)

assert utilDate instanceof java.util.Date
assert sqlDate instanceof java.sql.Date

// 3. Scripts versus classes

// 3.1. public static void main vs script

// Groovy supports both scripts and classes. Take the following code for example:

class Main {                                    
    static void main(String... args) {          
        println 'Groovy class world!'                 
    }
}

// This is typical code that you would find coming from Java, where code has to be embedded into a
// class to be executable. Groovy makes it easier, the following code is equivalent:

println 'Groovy script world!'

// 3.2. Script class

// A script is always compiled into a class. The Groovy compiler will compile the class for you,
// with the body of the script copied into a run method. The previous example is therefore compiled
// as if it was the following:

import org.codehaus.groovy.runtime.InvokerHelper
class Main1 extends Script {                     
    def run() {                                 
        println 'Groovy world!'                 
    }
    static void main(String[] args) {           
        InvokerHelper.runScript(Main, args)     
    }
}

// 3.3. Methods

// It is possible to define methods into a script, as illustrated here:

int fib(int n) {
    n < 2 ? 1 : fib(n-1) + fib(n-2)
}
assert fib(10)==89

// You can also mix methods and code. The generated script class will carry all methods into the
// script class, and assemble all script bodies into the run method:

println 'Hello'                                 

int power(int n) { 2**n }                       

println "2^6==${power(6)}"

// This code is internally converted into:

import org.codehaus.groovy.runtime.InvokerHelper
class Main2 extends Script {
    int power(int n) { 2** n}                   
    def run() {
        println 'Hello'                         
        println "2^6==${power(6)}"              
    }
    static void main(String[] args) {
        InvokerHelper.runScript(Main2, args)
    }
}

// Even if Groovy creates a class from your script, it is totally transparent for the user. In
// particular, scripts are compiled to bytecode, and line numbers are preserved. This implies that
// if an exception is thrown in a script, the stack trace will show line numbers corresponding to
// the original script, not the generated code that we have shown.

// 3.4. Variables

// Variables in a script do not require a type definition. This means that this script:

int x = 1
int y = 2
assert x+y == 3
x1 = 1
x2 = 2
assert x1 + x2 == 3

// However there is a semantic difference between the two:

// if the variable is declared as in the first example, it is a local variable. It will be declared
// in the run method that the compiler will generate and will not be visible outside of the script
// main body. In particular, such a variable will not be visible in other methods of the script

// if the variable is undeclared, it goes into the script binding. The binding is visible from the
// methods, and is especially important if you use a script to interact with an application and need
// to share data between the script and the application. Readers might refer to the integration
// guide for more information.

// If you want a variable to become a field of the class without going into the Binding, you can use 
// the @Field annotation.
