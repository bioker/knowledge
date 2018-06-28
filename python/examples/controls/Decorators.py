#!/usr/bin/env python3.5
print('Decorators:')


def some_function():
    print("This is function")


def decorator(function):
    def wrapper():
        print("These are pre actions")
        function()
        print("These are post actions")
    return wrapper


f = decorator(some_function)


f()


def syntax_sugar_decorator(function):
    def wrapper():
        print("These are other pre actions")
        function()
        print("There are other post actions")
    return wrapper


@syntax_sugar_decorator
def some_another_function():
    print("This is another function")


some_another_function()
