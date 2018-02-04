#!/usr/bin/env python3.5
print('Lists:')

squares = [1 ** 2, 2 ** 2, 3 ** 2, 4 ** 2]
cubes = [1 ** 3, 2 ** 2, 3 ** 3, 4 ** 3]
cubes[2] = 2 ** 3

letters = ['a', 'b', 'c', 'd', 'e', 'f', 'g']

print(squares)
print(cubes)

print(cubes[:])

print(letters)
letters[2:4] = ['C', 'D']
print(letters)
letters[:] = []
print(letters)

print(len(cubes))

nested = [[1, 2, 3], ['a','b','c']]

print(nested)
