#!/usr/bin/env python3.5
print('Functions:')

a = 'Global variable'
b = 'Global variable'

def func(a, d=1):
    """
    Documentation of function
    """
    c = 'Local variable'
    print('Call of func')
    print('Access argument:', a)
    print('Access global variable:', b)
    print('Access local variable:', c)
    print('Access argument with default value:', d)
    return 'Result of the function'

print('Result: ', func('Function Argument'))
print('Documentation of string:', func.__doc__)

i = 0
def func2(arg=i):
    return arg
i = 1
print('Default value evaluated at defenition', func2())

def func3(n, m=[]):
    m.append(n)
    return m
func3(1)
func3(2)
print('Complex types content can be changed for default values:', func3(3))

def func4(a, b=2, c=3):
    print('a:', a)
    print('b:', b)
    print('c:', c)
print('Arguments can be passed by name')
func4(1, c=4)
